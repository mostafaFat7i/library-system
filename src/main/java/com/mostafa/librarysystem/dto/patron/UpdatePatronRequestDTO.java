package com.mostafa.librarysystem.dto.patron;


import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class UpdatePatronRequestDTO {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Contact information is required")
    private String contactInformation;
}
