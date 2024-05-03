package com.mostafa.librarysystem.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mostafa.librarysystem.dto.ResponseStatus;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class GetAllBooksResponseDTO {
    @JsonProperty("status")
    private ResponseStatus status;

    @JsonProperty("data")
    private List<BookDTO> data;
}
