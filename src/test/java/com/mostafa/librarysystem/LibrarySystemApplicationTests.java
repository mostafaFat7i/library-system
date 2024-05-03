package com.mostafa.librarysystem;

import com.mostafa.librarysystem.controllers.BookController;
import com.mostafa.librarysystem.controllers.BorrowingController;
import com.mostafa.librarysystem.controllers.PatronController;
import com.mostafa.librarysystem.dto.book.*;
import com.mostafa.librarysystem.dto.patron.*;
import com.mostafa.librarysystem.services.BookService;
import com.mostafa.librarysystem.services.BorrowingService;
import com.mostafa.librarysystem.services.PatronService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LibrarySystemApplicationTests {

	@Mock
	private BookService bookService;

	@InjectMocks
	private BookController bookController;

	@Mock
	private PatronService patronService;

	@InjectMocks
	private PatronController patronController;

	@Mock
	private BorrowingService borrowingService;

	@InjectMocks
	private BorrowingController borrowingController;

	@Test
	public void testAddBook() {

		CreateBookRequestDTO requestDTO = new CreateBookRequestDTO();
		BookDTO createdBook = new BookDTO();
		when(bookService.addBook(requestDTO)).thenReturn(createdBook);


		ResponseEntity<CreateBookResponseDTO> responseEntity = bookController.addBook(requestDTO);


		assert responseEntity.getStatusCode() == HttpStatus.OK;
		assert responseEntity.getBody() != null;
		assert responseEntity.getBody().getData() != null;
	}
	@Test
	public void testUpdateBook() {

		Long bookId = 1L;
		UpdateBookRequestDTO requestDTO = new UpdateBookRequestDTO();
		BookDTO updatedBook = new BookDTO();
		when(bookService.updateBook(bookId, requestDTO)).thenReturn(updatedBook);


		ResponseEntity<UpdateBookResponseDTO> responseEntity = bookController.updateBook(bookId, requestDTO);


		assert responseEntity.getStatusCode() == HttpStatus.OK;
		assert responseEntity.getBody() != null;
		assert responseEntity.getBody().getData() != null;
	}
	@Test
	public void testDeleteBook() {
		Long bookId = 1L;
		when(bookService.deleteBook(bookId)).thenReturn(true);

		ResponseEntity<DeletedBookResponseDTO> responseEntity = bookController.deleteBook(bookId);

		assert responseEntity.getStatusCode() == HttpStatus.OK;
		assert responseEntity.getBody() != null;
	}

	@Test
	public void testGetAllPatrons() {
		List<PatronDTO> patrons = Arrays.asList(new PatronDTO(), new PatronDTO());
		when(patronService.getAllPatrons()).thenReturn(patrons);


		ResponseEntity<GetAllPatronsResponseDTO> responseEntity = patronController.getAllPatrons();

		assert responseEntity.getStatusCode() == HttpStatus.OK;
		assert responseEntity.getBody() != null;
		assert responseEntity.getBody().getData().size() == 2;
	}

	@Test
	public void testGetPatronById() {

		Long patronId = 1L;
		PatronDTO patron = new PatronDTO();
		when(patronService.getPatronById(patronId)).thenReturn(patron);


		ResponseEntity<GetPatronByIdResponseDTO> responseEntity = patronController.getPatronById(patronId);

		assert responseEntity.getStatusCode() == HttpStatus.OK;
		assert responseEntity.getBody() != null;
		assert responseEntity.getBody().getData() != null;
	}
	@Test
	public void testAddPatron() {
		CreatePatronRequestDTO requestDTO = new CreatePatronRequestDTO();
		PatronDTO createdPatron = new PatronDTO();
		when(patronService.addPatron(requestDTO)).thenReturn(createdPatron);

		ResponseEntity<CreatePatronResponseDTO> responseEntity = patronController.addPatron(requestDTO);

		assert responseEntity.getStatusCode() == HttpStatus.OK;
		assert responseEntity.getBody() != null;
		assert responseEntity.getBody().getData() != null;
	}

	@Test
	public void testUpdatePatron() {
		Long patronId = 1L;
		UpdatePatronRequestDTO requestDTO = new UpdatePatronRequestDTO();
		PatronDTO updatedPatron = new PatronDTO();
		when(patronService.updatePatron(patronId, requestDTO)).thenReturn(updatedPatron);

		ResponseEntity<UpdatePatronResponseDTO> responseEntity = patronController.updatePatron(patronId, requestDTO);

		assert responseEntity.getStatusCode() == HttpStatus.OK;
		assert responseEntity.getBody() != null;
		assert responseEntity.getBody().getData() != null;
	}

	@Test
	public void testDeletePatron() {
		Long patronId = 1L;
		when(patronService.deletePatron(patronId)).thenReturn(true);

		ResponseEntity<DeletedPatronResponseDTO> responseEntity = patronController.deletePatron(patronId);

		assert responseEntity.getStatusCode() == HttpStatus.OK;
		assert responseEntity.getBody() != null;
	}



	@Test
	public void testBorrowBook_Success() {
		Long bookId = 1L;
		Long patronId = 1L;
		when(borrowingService.borrowBook(bookId, patronId)).thenReturn(true);

		ResponseEntity<String> responseEntity = borrowingController.borrowBook(bookId, patronId);

		assert responseEntity.getStatusCode() == HttpStatus.OK;
		assert responseEntity.getBody().equals("Book borrowed successfully.");
	}

	@Test
	public void testBorrowBook_Failure() {
		Long bookId = 1L;
		Long patronId = 1L;
		when(borrowingService.borrowBook(bookId, patronId)).thenReturn(false);

		ResponseEntity<String> responseEntity = borrowingController.borrowBook(bookId, patronId);

		assert responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST;
		assert responseEntity.getBody().equals("Failed to borrow book.");
	}

	@Test
	public void testReturnBook_Success() {
		Long bookId = 1L;
		Long patronId = 1L;
		when(borrowingService.returnBook(bookId, patronId)).thenReturn(true);

		ResponseEntity<String> responseEntity = borrowingController.returnBook(bookId, patronId);

		assert responseEntity.getStatusCode() == HttpStatus.OK;
		assert responseEntity.getBody().equals("Book returned successfully.");
	}

	@Test
	public void testReturnBook_Failure() {
		Long bookId = 1L;
		Long patronId = 1L;
		when(borrowingService.returnBook(bookId, patronId)).thenReturn(false);

		ResponseEntity<String> responseEntity = borrowingController.returnBook(bookId, patronId);

		assert responseEntity.getStatusCode() == HttpStatus.BAD_REQUEST;
		assert responseEntity.getBody().equals("Failed to return book.");
	}

}
