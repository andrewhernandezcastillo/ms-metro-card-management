package com.demo.ms.application.port.input;

import com.demo.ms.dominio.model.Card;

import java.util.List;

public interface CardServicesPort {

    Card addCard(Card card);
    Card updateCard(String id, Card card);
    void deleteCard(String card);
    List<Card> getCards();
    Card getCardById(String id);

}
