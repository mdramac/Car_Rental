package it.htl.steyr.car_rental.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "mdramac_rental")
public class Rental {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "active", nullable = false)
    private int active;

    @Column(name = "rental_date", nullable = false)
    private Date rental_date;

    @Column(name = "return_date", nullable = false)
    private Date return_date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer")
    private Client client;


    public Long getId() {
        return id;
    }


}
