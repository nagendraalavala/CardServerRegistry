package com.card.Server.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   // @JoinColumn(name = "iduser", insertable = false, updatable = false)
    private Long adId;
    private String country;
    private String state;
    private String city;
    private String Address1;
    private String Address2;
    private int zipCode;
}
