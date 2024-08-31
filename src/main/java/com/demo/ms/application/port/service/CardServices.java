package com.demo.ms.application.port.service;

import com.demo.ms.application.port.input.CardServicesPort;
import com.demo.ms.application.port.output.CardPersistencePort;
import com.demo.ms.dominio.exception.NotFoundException;
import com.demo.ms.dominio.model.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServices implements CardServicesPort {

    private final CardPersistencePort cardPersistencePort;

    @Override
    public Card addCard(Card card) {
        card.setHashCode(UUID.randomUUID().toString());
        return cardPersistencePort.addCard(card);
    }

    @Override
    public Card updateCard(String id, Card card) {
        return cardPersistencePort.getCardById(id)
                .map(item->{
                    item.setName(card.getName());
                    item.setHashCode(id);
                    item.setAddress(card.getAddress());
                    item.setAmount(card.getAmount());
                    item.setLastname(card.getLastname());
                    return cardPersistencePort.addCard(item);
                })
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public void deleteCard(String card) {
        cardPersistencePort.deleteCard(card);
    }

    @Override
    public List<Card> getCards() {
        return cardPersistencePort.getCards();
    }

    @Override
    public Card getCardById(String id) {
        return cardPersistencePort.getCardById(id)
                .orElseThrow(NotFoundException::new);
    }
}
