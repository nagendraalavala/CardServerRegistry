package com.card.Server.Controller.Card;


import com.card.Server.Service.Card.CardService;
import com.card.Server.types.Card.CardDTO;
import com.card.Server.types.Card.CardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/host")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/card/sign-up")
    public Object newCard(CardDTO cardDTO)
    {
        return cardService.addNewCard(cardDTO);
    }

    @GetMapping("/card/")
    public List<CardResponse> getAllCards()
    {
        return cardService.findAllCards();
    }

}
