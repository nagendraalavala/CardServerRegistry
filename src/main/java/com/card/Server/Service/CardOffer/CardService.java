package com.card.Server.Service.CardOffer;


import com.card.Server.Entity.CardOffer.CardEntity;
import com.card.Server.Repository.CardOffer.CardRepository;
import com.card.Server.types.Card.CardDAO;
import com.card.Server.types.Card.CardDTO;
import com.card.Server.types.Card.CardResponse;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final Logger logger = LoggerFactory.getLogger(CardService.class);

    @Autowired
    private CardRepository cardRepo;
    private ModelMapper modelMapper;
    private CardDAO cardDAO;
    private CardDTO cardDTO;

    @Autowired
    public CardService(CardRepository cardRepo) {
        this.cardRepo = cardRepo;
        this.modelMapper = new ModelMapper();
        this.cardDAO = new CardDAO();
        this.cardDTO = new CardDTO();
    }

    //AddCard
    public ResponseEntity<CardDAO> addNewCard(CardDTO cardDTO)
    {
        CardEntity cardEntity = modelMapper.map(cardDTO, CardEntity.class);
        cardRepo.save(cardEntity);
        CardDAO response = new CardDAO();
        response.setMessage(cardEntity.getCardProvider() + " " + cardEntity.getCardType() + " Card Added Successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    //GetAllCards
    public List<CardResponse> findAllCards() {
        List<CardEntity> cards = cardRepo.findAll();
        logger.info(String.valueOf("CardEntity: " + cards));
        List<CardResponse> response = cards.stream().map(cardEntity ->modelMapper.map(cardEntity, CardResponse.class)).collect(Collectors.toList());
        logger.info("Response: " + response);
        return response;
    }


}
