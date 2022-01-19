package it.htl.steyr.car_rental.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Entity
@Table(name = "mdramac_car")
public class Car {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    //private Date date;

    @Column(name = "modell", nullable = false)
    private String modell;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "daily_rate", nullable = false)
    private long daily_rate;

    public String getModell() {
        return modell;
    }

    public Brand getBrand() {
        return brand;
    }

    public long getDaily_rate() {
        return daily_rate;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setDaily_rate(long daily_rate) {
        this.daily_rate = daily_rate;
    }
}
