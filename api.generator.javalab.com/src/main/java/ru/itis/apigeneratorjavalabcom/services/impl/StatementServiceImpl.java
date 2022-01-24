package ru.itis.apigeneratorjavalabcom.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.itis.apigeneratorjavalabcom.config.RabbitConfig;
import ru.itis.apigeneratorjavalabcom.models.dao.Statements;
import ru.itis.apigeneratorjavalabcom.models.dto.PdfResponseDto;
import ru.itis.apigeneratorjavalabcom.models.dto.StatementsDto;
import ru.itis.apigeneratorjavalabcom.repositories.StatementsRepository;
import ru.itis.apigeneratorjavalabcom.services.interfaces.StatementService;
import ru.itis.apigeneratorjavalabcom.utils.RabbitQueue;

import java.time.LocalDateTime;

import static ru.itis.apigeneratorjavalabcom.utils.RabbitQueue.STATEMENTS_TOPIC;

@Service
@AllArgsConstructor
public class StatementServiceImpl implements StatementService {

    private final StatementsRepository statementsRepository;
    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;

    @Override
    public <T> byte[] generateDocument(T document) throws JsonProcessingException {
        String queue = STATEMENTS_TOPIC.getTopic();

        PdfResponseDto responseDto = objectMapper.readValue((String) rabbitTemplate.convertSendAndReceive(
                RabbitConfig.TOPIC_EXCHANGE_NAME, queue, document), PdfResponseDto.class);

        if (responseDto != null) {
            return responseDto.getData();
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Statements save(StatementsDto statementsDto) {

        Statements statements = Statements.builder()
                .date(LocalDateTime.now())
                .firstname(statementsDto.getFirstname())
                .lastname(statementsDto.getLastname())
                .patronymic(statementsDto.getPatronymic())
                .build();

        return statementsRepository.save(statements);
    }
}
