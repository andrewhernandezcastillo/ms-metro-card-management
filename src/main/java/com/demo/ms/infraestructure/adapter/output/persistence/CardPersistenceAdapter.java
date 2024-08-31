package com.demo.ms.infraestructure.adapter.output.persistence;

import com.demo.ms.application.port.output.CardPersistencePort;
import com.demo.ms.dominio.model.Card;
import com.demo.ms.infraestructure.adapter.output.mapper.CardMapperAdapter;
import com.demo.ms.infraestructure.adapter.output.repository.CardRepositoryAdapter;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CardPersistenceAdapter implements CardPersistencePort {

    private final CardRepositoryAdapter cardRepositoryAdapter;
    private final CardMapperAdapter cardMapperAdapter;

    @Override
    public Card addCard(Card card) {
        return cardMapperAdapter.toCard(
                cardRepositoryAdapter.save(
                        cardMapperAdapter.toCardEntity(card)
                )
        );
    }
    @Transactional
    @Override
    public void deleteCard(String card) {
        cardRepositoryAdapter.deleteByHashCode(card);
    }

    @Override
    public List<Card> getCards() {
        return cardMapperAdapter.toCard(cardRepositoryAdapter.findAll());
    }

    @Override
    public Optional<Card> getCardById(String id) {
        return cardRepositoryAdapter.findByHashCode(id)
                .map(cardMapperAdapter::toCard);
    }

}
