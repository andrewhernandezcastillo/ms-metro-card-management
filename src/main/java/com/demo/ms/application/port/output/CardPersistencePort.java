package com.demo.ms.application.port.output;

import com.demo.ms.dominio.model.Card;

import java.util.List;
import java.util.Optional;

public interface CardPersistencePort {

    Card addCard(Card card);
    void deleteCard(String card);
    List<Card> getCards();
    Optional<Card> getCardById(String id);

}
