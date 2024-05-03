package com.mostafa.librarysystem.controllers;

import com.mostafa.librarysystem.dto.ResponseStatus;
import com.mostafa.librarysystem.dto.book.*;
import com.mostafa.librarysystem.services.BookService;
import com.mostafa.librarysystem.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;
    ResponseStatus status;

    @GetMapping("/books")
    public ResponseEntity<GetAllBooksResponseDTO> getAllBooks(){
        ResponseStatus status;
        GetAllBooksResponseDTO response;

        List<BookDTO> data = bookService.getAllBooks();
        if (data !=null){
            status=ResponseStatus.builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_MESSAGE).build();
            response=new GetAllBooksResponseDTO(status,data);
        }
        else {
            status=ResponseStatus.builder().code(Constants.ERROR_CODE).message(Constants.ERROR_MESSAGE).build();
            response=new GetAllBooksResponseDTO(status,null);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<GetBookByIdResponseDTO> getBookById(@PathVariable Long id) {
        GetBookByIdResponseDTO response;

        BookDTO book = bookService.getBookById(id);
        if (book !=null){
            status=ResponseStatus.builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_MESSAGE).build();
            response=new GetBookByIdResponseDTO(status,book);
        }
        else {
            status=ResponseStatus.builder().code(Constants.ERROR_CODE).message(Constants.ERROR_MESSAGE).build();
            response=new GetBookByIdResponseDTO(status,null);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<CreateBookResponseDTO> addBook(@RequestBody CreateBookRequestDTO requestDTO) {
        CreateBookResponseDTO response;
        BookDTO book = bookService.addBook(requestDTO);
        if (book !=null){
            status=ResponseStatus.builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_MESSAGE).build();
            response=new CreateBookResponseDTO(status,book);
        }
        else {
            status=ResponseStatus.builder().code(Constants.ERROR_CODE).message(Constants.ERROR_MESSAGE).build();
            response=new CreateBookResponseDTO(status,null);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<UpdateBookResponseDTO> updateBook(@PathVariable Long id, @RequestBody UpdateBookRequestDTO requestDTO) {
        UpdateBookResponseDTO response;
        BookDTO updatedBook = bookService.updateBook(id, requestDTO);
        if (updatedBook != null) {
            status=ResponseStatus.builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_MESSAGE).build();
            response=new UpdateBookResponseDTO(status,updatedBook);
        } else {
            status=ResponseStatus.builder().code(Constants.ERROR_CODE).message(Constants.ERROR_MESSAGE).build();
            response=new UpdateBookResponseDTO(status,null);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<DeletedBookResponseDTO> deleteBook(@PathVariable Long id) {
        DeletedBookResponseDTO response;

        boolean deleted = bookService.deleteBook(id);
        if (deleted) {
            status=ResponseStatus.builder().code(Constants.SUCCESS_CODE).message(Constants.SUCCESS_DELETE_MESSAGE).build();
            response=new DeletedBookResponseDTO(status);
        } else {
            status=ResponseStatus.builder().code(Constants.ERROR_Deleted_CODE).message(Constants.SUCCESS_DELETE_MESSAGE).build();
            response=new DeletedBookResponseDTO(status);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }


}
