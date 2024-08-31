package com.demo.ms.infraestructure.adapter.input;

import com.demo.ms.application.port.input.CardServicesPort;
import com.demo.ms.infraestructure.adapter.input.mapper.CardMapperResponse;
import com.demo.ms.infraestructure.adapter.input.model.CardRequest;
import com.demo.ms.infraestructure.adapter.input.model.CardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestApi {

    private final CardServicesPort cardServices;
    private final CardMapperResponse cardMapperResponse;

    @GetMapping("api/v1/{hash}")
    public ResponseEntity<CardResponse> getByHash(@PathVariable String hash) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(cardMapperResponse.cardToCardResponse(cardServices.getCardById(hash)));
    }

    @GetMapping("api/v1")
    public ResponseEntity<List<CardResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cardMapperResponse.cardsToCardResponses(cardServices.getCards()));
    }

    @PostMapping("api/v1")
    public ResponseEntity<CardResponse> create(@RequestBody CardRequest cardRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                cardMapperResponse.cardToCardResponse(
                        cardServices.addCard(cardMapperResponse.cardToCardRequest(cardRequest))
                )
        );
    }

    @PutMapping("api/v1/{hash}")
    public ResponseEntity<CardResponse> update(@PathVariable String hash, @RequestBody CardRequest cardRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                cardMapperResponse.cardToCardResponse(
                        cardServices.updateCard(hash,cardMapperResponse.cardToCardRequest(cardRequest))
                )
        );
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("api/v1/{hash}")
    public void delete(@PathVariable String hash) {
        cardServices.deleteCard(hash);
    }

}
