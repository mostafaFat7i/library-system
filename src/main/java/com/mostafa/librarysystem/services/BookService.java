package com.mostafa.librarysystem.services;

import com.mostafa.librarysystem.dto.book.BookDTO;
import com.mostafa.librarysystem.dto.book.CreateBookRequestDTO;
import com.mostafa.librarysystem.dto.book.UpdateBookRequestDTO;
import com.mostafa.librarysystem.entities.Book;
import com.mostafa.librarysystem.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    @Transactional(readOnly = true)
    public List<BookDTO> getAllBooks(){
        return bookRepository.findAll().stream().map(this::convertToResponseDto).collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(this::convertToResponseDto)
                .orElse(null);
    }


    @Transactional
    public BookDTO addBook(CreateBookRequestDTO requestDTO) {
        Book book = new Book();
        book.setTitle(requestDTO.getTitle());
        book.setAuthor(requestDTO.getAuthor());
        book.setPublicationYear(requestDTO.getPublicationYear());
        book.setIsbn(requestDTO.getIsbn());

        Book savedBook = bookRepository.save(book);
        return convertToResponseDto(savedBook);
    }

    @Transactional
    public BookDTO updateBook(Long id, UpdateBookRequestDTO requestDTO) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(requestDTO.getTitle());
            book.setAuthor(requestDTO.getAuthor());
            book.setPublicationYear(requestDTO.getPublicationYear());
            book.setIsbn(requestDTO.getIsbn());

            Book updatedBook = bookRepository.save(book);
            return convertToResponseDto(updatedBook);
        } else {
            return null;
        }
    }

    @Transactional
    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private BookDTO convertToResponseDto(Book book) {
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setPublicationYear(book.getPublicationYear());
        dto.setIsbn(book.getIsbn());
        return dto;
    }

}
