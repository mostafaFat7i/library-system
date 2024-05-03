package com.mostafa.librarysystem.controllers;


import com.mostafa.librarysystem.services.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BorrowingController {
    @Autowired
    private BorrowingService borrowingService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<String> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        boolean success = borrowingService.borrowBook(bookId, patronId);
        if (success) {
            return ResponseEntity.ok("Book borrowed successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to borrow book.");
        }
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<String> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        boolean success = borrowingService.returnBook(bookId, patronId);
        if (success) {
            return ResponseEntity.ok("Book returned successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to return book.");
        }
    }

}
