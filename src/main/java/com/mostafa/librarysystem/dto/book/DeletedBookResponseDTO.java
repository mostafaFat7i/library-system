package com.mostafa.librarysystem.dto.book;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mostafa.librarysystem.dto.ResponseStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class DeletedBookResponseDTO {

    @JsonProperty("status")
    private ResponseStatus status;
}
