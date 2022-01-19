package it.htl.steyr.car_rental.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mdramac_client")
public class Client {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "iban", nullable = false)
    private String iban;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private Set<Rental> rental;


    /**
     * @OneToMany means: this is the "one" side of the realtion.
     *            mappedBy = "account " references to the class
     *            variable "private Account account" in the Transaction
     *            class.
     */

    public void setIban(String iban) {
        this.iban = iban;
    }


    @Id
    public String getIban() {
        return iban;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
