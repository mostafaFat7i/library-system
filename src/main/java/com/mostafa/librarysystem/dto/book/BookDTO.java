package com.mostafa.librarysystem.dto.book;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
}
