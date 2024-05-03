package com.mostafa.librarysystem.repo;

import com.mostafa.librarysystem.entities.Book;
import com.mostafa.librarysystem.entities.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord,Long> {
    BorrowingRecord findByBookIdAndPatronIdAndReturnDateIsNull(Long bookId, Long patronId);

    List<BorrowingRecord> findByBookAndReturnDateIsNull(Book book);

}
