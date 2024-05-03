package com.mostafa.librarysystem.services;

import com.mostafa.librarysystem.entities.Book;
import com.mostafa.librarysystem.entities.BorrowingRecord;
import com.mostafa.librarysystem.entities.Patron;
import com.mostafa.librarysystem.repo.BookRepository;
import com.mostafa.librarysystem.repo.BorrowingRecordRepository;
import com.mostafa.librarysystem.repo.PatronRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BorrowingService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private PatronRepository patronRepository;


    @Transactional
    public boolean borrowBook(Long bookId, Long patronId){
        Book book = bookRepository.findById(bookId).orElse(null);
        Patron patron = patronRepository.findById(patronId).orElse(null);
        BorrowingRecord borrowingRecord = new BorrowingRecord();

        if (book != null && patron != null && bookAvailableForBorrowing(book)) {
            borrowingRecord.setBook(book);
            borrowingRecord.setPatron(patron);
            borrowingRecord.setBorrowingDate(LocalDate.now());
            borrowingRecordRepository.save(borrowingRecord);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean returnBook(Long bookId, Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordRepository.findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId);

        if (borrowingRecord != null) {
            borrowingRecord.setReturnDate(LocalDate.now());
            borrowingRecordRepository.save(borrowingRecord);
            return true;
        }
        return false;
    }

    private boolean bookAvailableForBorrowing(Book book) {
        List<BorrowingRecord> borrowingRecords = borrowingRecordRepository.findByBookAndReturnDateIsNull(book);
        return borrowingRecords.isEmpty();
    }

}
