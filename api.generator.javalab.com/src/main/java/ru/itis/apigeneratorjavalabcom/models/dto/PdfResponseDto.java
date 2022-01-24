package ru.itis.apigeneratorjavalabcom.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PdfResponseDto implements Serializable {

    private Long createdAt;

    private byte[] data;

}
