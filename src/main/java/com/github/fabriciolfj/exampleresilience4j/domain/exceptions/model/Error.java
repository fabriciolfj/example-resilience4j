package com.github.fabriciolfj.exampleresilience4j.domain.exceptions.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Error {

    private String message;
    private LocalDateTime date;
    private int status;

    public static Error toError(final String msg, final HttpStatus httpStatus) {
        return Error.builder()
                .message(msg)
                .date(LocalDateTime.now())
                .status(httpStatus.value())
                .build();
    }
}
