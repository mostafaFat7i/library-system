package com.mostafa.librarysystem.dto.patron;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mostafa.librarysystem.dto.ResponseStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class DeletedPatronResponseDTO {

    @JsonProperty("status")
    private ResponseStatus status;
}
