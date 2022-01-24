package ru.itis.apigeneratorjavalabcom.services.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.itis.apigeneratorjavalabcom.models.dao.Statements;
import ru.itis.apigeneratorjavalabcom.models.dto.StatementsDto;


public interface StatementService {

    public Statements save(StatementsDto statements);

    public <T> byte[] generateDocument(T document) throws JsonProcessingException;
}
