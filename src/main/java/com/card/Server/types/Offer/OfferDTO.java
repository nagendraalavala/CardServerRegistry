package com.card.Server.types.Offer;

import lombok.Data;

@Data
public class OfferDTO {
    private String cardProvider;
    private String cardType;
    private String offDesc;
    private String offLocation;
    private int offFrom;
    private int offTo;
    private String defaultOffDesc;

}
