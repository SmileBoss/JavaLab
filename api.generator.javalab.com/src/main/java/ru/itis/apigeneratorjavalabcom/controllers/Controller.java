package ru.itis.apigeneratorjavalabcom.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.apigeneratorjavalabcom.models.dto.StatementsDto;
import ru.itis.apigeneratorjavalabcom.services.interfaces.StatementService;

import javax.persistence.EntityNotFoundException;


@RestController
@AllArgsConstructor
public class Controller {

    private StatementService statementService;


    @PostMapping("/statement")
    public ResponseEntity<byte[]> createStatement(@RequestBody StatementsDto statement) {
        try {
            byte[] data = statementService.generateDocument(statement);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);

            return new ResponseEntity<>(data, headers, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new EntityNotFoundException(e.getMessage());
        }
    }
}
