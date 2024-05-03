**Library Management System API using Spring Boot**

---

**Project Description:**

This project endeavors to create an API for a Library Management System using Spring Boot. The aim is to assist librarians in efficiently managing books, patrons, and borrowing records.

**Requirements:**

**Entities:**

- **Book:** Includes attributes like ID, title, author, publication year, ISBN, etc.
- **Patron:** Contains details like ID, name, contact information, etc.
- **Borrowing Record:** Tracks the association between books and patrons, including borrowing and return dates.

**API Endpoints:**

- **Book management endpoints:**
  - **GET /api/books:** Retrieve a list of all books.
  - **GET /api/books/{id}:** Retrieve details of a specific book by ID.
  - **POST /api/books:** Add a new book to the library.
  - **PUT /api/books/{id}:** Update an existing book's information.
  - **DELETE /api/books/{id}:** Remove a book from the library.
- **Patron management endpoints:**
  - **GET /api/patrons:** Retrieve a list of all patrons.
  - **GET /api/patrons/{id}:** Retrieve details of a specific patron by ID.
  - **POST /api/patrons:** Add a new patron to the system.
  - **PUT /api/patrons/{id}:** Update an existing patron's information.
  - **DELETE /api/patrons/{id}:** Remove a patron from the system.
- **Borrowing endpoints:**
  - **POST /api/borrow/{bookId}/patron/{patronId}:** Allow a patron to borrow a book.
  - **PUT /api/return/{bookId}/patron/{patronId}:** Record the return of a borrowed book by a patron.

**Data Storage:**

- Utilize an appropriate database (MySQL) to persist book, patron, and borrowing record details.
- Establish proper relationships between entities (e.g., one-to-many between books and borrowing records).

**Validation and Error Handling:**

- Implement input validation for API requests, ensuring validation of required fields.
- Handle exceptions gracefully and return appropriate HTTP status codes and error messages.

**Transaction Management:**

- Implement declarative transaction management using Spring's @Transactional annotation to ensure data integrity during critical operations.

**Testing:**

- Compose unit tests to validate the functionality of API endpoints.
- Employ testing frameworks like JUnit5 for testing.

---

**Instructions for Deployment:**

1. Clone this repository to your local machine.
2. Configure your MySQL database settings in the application.properties file.
3. Run the application using your preferred IDE or by executing `mvn spring-boot:run` in the terminal.
4. Access the API endpoints using tools like Postman or curl.

