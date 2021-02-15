package com.card.Server.types.Offer;

import lombok.Data;

@Data
public class OfferDTO {
    private String cardProvider;
    private String cardType;
    private String offDesc;
    private String offLocation;
    private String offFrom;
    private String offTo;

}
