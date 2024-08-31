package com.demo.ms.infraestructure.adapter.input.mapper;

import com.demo.ms.dominio.model.Card;
import com.demo.ms.infraestructure.adapter.input.model.CardRequest;
import com.demo.ms.infraestructure.adapter.input.model.CardResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapperResponse {

    CardResponse cardToCardResponse(Card card);
    Card cardToCardRequest(CardRequest card);
    List<CardResponse> cardsToCardResponses(List<Card> cards);

}
