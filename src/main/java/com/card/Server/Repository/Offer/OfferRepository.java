package com.card.Server.Repository.Offer;

import com.card.Server.Entity.Offer.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository  extends JpaRepository<OfferEntity, Long> {

    @Query("SELECT IIF(:month >= oe.OffFrom and :month <= oe.OffTo or :month is null, oe.offDesc, oe.defaultOffDesc), oe FROM OfferEntity oe WHERE (oe.offLocation = :location or :location is null ) and (oe.cardProvider = :cardProvider or :cardProvider is null)" +
            " and (oe.cardType = :cardType or :cardType is null) ")
    OfferEntity findByoffLocationAndcardProviderAndcardTypeAndMonth(@Param("location") String location, @Param("cardProvider") String cardProvider, @Param("cardType") String cardType, @Param("month") int currentMonth);
}
