package com.sgic.internal.product.entities;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Options {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="has_gps")
    private String hasGPS;

    private String transmission;

    public String getHasgps() {
        return hasGPS;
    }

    public void setHasGPS(String hasGPS) {
        this.hasGPS = hasGPS;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
}
