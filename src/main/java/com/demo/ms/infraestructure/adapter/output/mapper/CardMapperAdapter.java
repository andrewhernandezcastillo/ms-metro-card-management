package com.demo.ms.infraestructure.adapter.output.mapper;

import com.demo.ms.dominio.model.Card;
import com.demo.ms.infraestructure.adapter.output.entity.CardEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CardMapperAdapter {

    CardEntity toCardEntity(Card card);
    Card toCard(CardEntity cardEntity);
    List<Card> toCard(List<CardEntity> cardEntities);

}
