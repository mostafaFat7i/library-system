package com.mostafa.librarysystem.dto.patron;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class PatronDTO {
    private Long id;
    private String name;
    private String contactInformation;
}
