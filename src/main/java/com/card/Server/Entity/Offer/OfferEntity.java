package com.card.Server.Entity.Offer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OfferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ofId;
    private String cardProvider;
    private String cardType;
    private String offDesc;
    private String offLocation;
    private String status;
    private String offFrom;
    private String offTo;
}
