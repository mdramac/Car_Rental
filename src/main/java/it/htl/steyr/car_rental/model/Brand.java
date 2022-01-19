package it.htl.steyr.car_rental.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mdramac_brand")
public class Brand {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private Set<Car> car;

    public String getId() {
        return brand;
    }
}
