package com.card.Server.types.Card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardResponse {
    private Long cardId;
    private String cardProvider;
    private String cardType;

}
