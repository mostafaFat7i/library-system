package com.mostafa.librarysystem.repo;

import com.mostafa.librarysystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
