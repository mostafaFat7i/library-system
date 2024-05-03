package com.mostafa.librarysystem.dto.book;


import lombok.*;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class CreateBookRequestDTO {
    @NotBlank(message = "Title is required")
    private String title;
    @NotBlank(message = "Author is required")
    private String author;
    @NotBlank(message = "Publication year is required")
    private int publicationYear;
    @NotBlank(message = "ISBN is required")
    private String isbn;
}
