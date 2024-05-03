package com.mostafa.librarysystem;

import com.mostafa.librarysystem.entities.Book;
import com.mostafa.librarysystem.entities.Patron;
import com.mostafa.librarysystem.repo.BookRepository;
import com.mostafa.librarysystem.repo.PatronRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class LibrarySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystemApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(BookRepository bookRepository, PatronRepository patronRepository) {
		return args -> {
			Book[] books = {
					new Book("Book 1", "Author 1", 2000, "ISBN 1"),
					new Book("Book 2", "Author 2", 2005, "ISBN 2"),
					new Book("Book 3", "Author 3", 2010, "ISBN 3"),
					new Book("Book 4", "Author 4", 2015, "ISBN 4"),
					new Book("Book 5", "Author 5", 2020, "ISBN 5"),
					new Book("Book 6", "Author 6", 2021, "ISBN 6")
			};

			Patron[] patrons = {
					new Patron("Mostafa Fathi", "mostafa@gmail.com"),
					new Patron("Ahmad Kamal", "ahmed@gmail.com"),
					new Patron("Mona Johnson", "mona@gmail.com"),
					new Patron("Julia Wilson", "julia@gmail.com"),
					new Patron("Michael Brown", "michael@gmail.com")
			};

			bookRepository.saveAll(Arrays.asList(books));
			patronRepository.saveAll(Arrays.asList(patrons));

		};
	}

}
