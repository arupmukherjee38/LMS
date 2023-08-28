package com.tcs.library.lms.service;

import java.util.List;
import java.util.Optional;

import com.tcs.library.lms.model.Author;
import com.tcs.library.lms.model.Book;
import com.tcs.library.lms.model.BorrowingRecord;
import com.tcs.library.lms.model.BorrowingRequest;

public interface LmsService {

	Book createBook(Book book);
	
	Optional<Book> getBook(Long id);
	
	Book updateBook(Book book);
	
	boolean deleteBook(Long id);
	
	List<Book> getAllBookByAuthor(Long id);

	BorrowingRecord borrowingBook(BorrowingRequest borrowingRequest);
	
	BorrowingRecord returnBook(BorrowingRequest borrowingRequest);

	Author createAuthor(Author author);
	
	Optional<Author> getAuthor(Long id);
	
	Author updateAuthor( Author author);
	
	boolean deleteAuthor(Long id);
	
}
