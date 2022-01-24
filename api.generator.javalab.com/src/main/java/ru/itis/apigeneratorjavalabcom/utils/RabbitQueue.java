package ru.itis.apigeneratorjavalabcom.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum RabbitQueue {

    STATEMENTS_TOPIC("STATEMENTS_TOPIC"),
    REPLY_QUEUE_NAME("PDF_REPLY");

    private String topic;

}
