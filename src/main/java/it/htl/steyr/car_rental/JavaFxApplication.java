package it.htl.steyr.car_rental;

import it.htl.steyr.car_rental.controller.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApplication extends Application {
    private static final String APPLICATION_TITLE = "Hello World";

    private ConfigurableApplicationContext springContext;
    private Parent root;

    @Override
    public void init() throws Exception {
        String[] args = new String[0];

        /**
         * Get an "instance" of the spring framework to enable all spring-specific
         * features (dependency injection, autoloading, java persistance api, ...).
         */
        this.springContext =
                new SpringApplicationBuilder().
                        sources(CarRentalApplication.class).
                        run(args);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene.fxml"));

        /**
         * Set spring as the factory (when controllers were generated).
         * So spring is able to do its magic.
         */
        fxmlLoader.setControllerFactory(springContext::getBean);
        root = fxmlLoader.load();
        Controller c = fxmlLoader.getController();
        System.out.println(c);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(APPLICATION_TITLE);
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        springContext.stop();
    }
}