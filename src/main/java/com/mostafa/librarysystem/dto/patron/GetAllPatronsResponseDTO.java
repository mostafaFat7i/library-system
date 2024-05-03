package com.mostafa.librarysystem.dto.patron;


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
public class GetAllPatronsResponseDTO {

    @JsonProperty("status")
    private ResponseStatus status;

    @JsonProperty("data")
    private List<PatronDTO> data;
}
