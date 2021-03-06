package com.card.Server.types.Offer;

import lombok.Data;

@Data
public class OfferResponse {
    private String cardProvider;
    private String cardType;
    private String offDesc;
    private String offLocation;
    private String status;
    private int offFrom;
    private int offTo;
    private String defaultOffDesc;
}
