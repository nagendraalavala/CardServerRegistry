package com.card.Server.Entity.Card;

import com.card.Server.Entity.Offer.OfferEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cardId;
    private String cardProvider;
    private String cardType;

    @OneToMany
    private List<OfferEntity> offerEntity;


//    @ManyToOne(cascade = CascadeType.PERSIST)
//    private UserEntity userEntity;
}
