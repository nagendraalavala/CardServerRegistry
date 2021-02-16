package com.card.Server.Service.Offer;

import com.card.Server.Entity.Offer.OfferEntity;
import com.card.Server.Repository.Offer.OfferRepository;
import com.card.Server.types.Offer.OfferDAO;
import com.card.Server.types.Offer.OfferDTO;
import com.card.Server.types.Offer.OfferResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferService {

    private OfferRepository offerRepo;
    private OfferEntity offerEntity;
    private OfferDTO offerDTO;
    private OfferDAO offerDAO;
    private OfferResponse offerResponse;
    private ModelMapper modelMapper;

    @Autowired
    public OfferService(OfferRepository offerRepo) {
        this.offerRepo = offerRepo;
        this.offerEntity = new OfferEntity();
        this.offerDTO = new OfferDTO();
        this.offerDAO = new OfferDAO();
        this.offerResponse = new OfferResponse();
        this.modelMapper = new ModelMapper();
    }

    //AddOffer
    public ResponseEntity<OfferDAO> addOfferToCard(OfferDTO offerDTO)
    {
        OfferEntity offerEntity = modelMapper.map(offerDTO, OfferEntity.class);
        offerEntity.setStatus("Active");
        offerRepo.save(offerEntity);
        OfferDAO offerDAO = new OfferDAO();
        offerDAO.setMessage( " Offer Added for" + " " +  offerDTO.getCardProvider() + " " + offerDTO.getCardType() + " Successfully" );
        return ResponseEntity.status(HttpStatus.CREATED).body(offerDAO);
    }

    public List<OfferResponse> findAllOffers() {
        List<OfferEntity> offers = offerRepo.findAll();
        List<OfferResponse> response = offers.stream().map(userEntity ->modelMapper.map(userEntity, OfferResponse.class)).collect(Collectors.toList());
        return response;
    }

    public OfferResponse findOfferByLocation(String location, String cardProvider, String cardType)
    {
        OfferEntity entity = offerRepo.findByoffLocationAndcardProviderAndcardTypeAndMonth(location, cardProvider, cardType);
        OfferResponse response = modelMapper.map(entity, OfferResponse.class);
        return response;
    }
}
