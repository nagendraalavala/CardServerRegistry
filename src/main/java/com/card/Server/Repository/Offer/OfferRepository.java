package com.card.Server.Repository.Offer;

import com.card.Server.Entity.Offer.OfferEntity;
import com.card.Server.types.Offer.OfferResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository  extends JpaRepository<OfferEntity, Long> {

    @Query("SELECT of FROM OfferEntity of WHERE of.offLocation = :location and of.cardProvider = :cardProvider and of.cardType = :cardType")
    OfferEntity findByoffLocationAndcardProviderAndcardType(@Param("location") String location, @Param("cardProvider") String cardProvider, @Param("cardType") String cardType);
}
