package ru.itis.apigeneratorjavalabcom.receivers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.itis.apigeneratorjavalabcom.models.dao.Statements;
import ru.itis.apigeneratorjavalabcom.models.dto.PdfResponseDto;
import ru.itis.apigeneratorjavalabcom.models.dto.StatementsDto;
import ru.itis.apigeneratorjavalabcom.services.interfaces.StatementService;
import ru.itis.apigeneratorjavalabcom.utils.GeneratorPdf;

import static ru.itis.apigeneratorjavalabcom.utils.RabbitQueue.REPLY_QUEUE_NAME;


@Component
@RequiredArgsConstructor
public class ReceiverService {

    private static final Logger log = LoggerFactory.getLogger(ReceiverService.class);
    private final ObjectMapper objectMapper;
    private final StatementService statementService;
    private final GeneratorPdf generatorPdf;
    private final RabbitTemplate rabbitTemplate;


    @RabbitListener(queues = "STATEMENTS_TOPIC")
    public String receive(@Payload StatementsDto statement) throws Exception {
        log.info("Received: " + statement.toString());
        Statements statements = statementService.save(statement);
        PdfResponseDto responsePdf = PdfResponseDto.builder()
                .data(generatorPdf.generate(statements))
                .createdAt(System.currentTimeMillis())
                .build();

        rabbitTemplate.convertAndSend(REPLY_QUEUE_NAME.getTopic(),
                responsePdf);

        return objectMapper.writeValueAsString(responsePdf);
    }

    @RabbitListener(queues = "PDF_REPLY")
    public void receiveMessage(PdfResponseDto message) {
        log.info("Backup of: " + message.toString());
    }

}
