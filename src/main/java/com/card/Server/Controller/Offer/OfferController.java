package com.card.Server.Controller.Offer;

import com.card.Server.Entity.Offer.OfferEntity;
import com.card.Server.Service.Offer.OfferService;
import com.card.Server.types.Card.CardResponse;
import com.card.Server.types.Offer.OfferDTO;
import com.card.Server.types.Offer.OfferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/host")
public class OfferController {

    @Autowired
    private OfferService offerService;

    @PostMapping("/offer/sign-up")
    public Object newOffer(OfferDTO offerDTO)
    {
        return offerService.addOfferToCard(offerDTO);
    }

    @GetMapping("/offer/")
    public List<OfferResponse> getAllCards()
    {
        return offerService.findAllOffers();
    }

    @GetMapping("/offer/offer")
    public OfferResponse getOfferByLocation(@RequestParam(required = false) String location, @RequestParam(required = false) String cardProvider, @RequestParam(required = false) String cardType  )
    {
        return offerService.findOfferByLocation(location, cardProvider, cardType);

    }
}
