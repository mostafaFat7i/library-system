package com.mostafa.librarysystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseStatus {
    @JsonProperty("code")
    private Integer code;

    @JsonProperty("message")
    private String message;
}
