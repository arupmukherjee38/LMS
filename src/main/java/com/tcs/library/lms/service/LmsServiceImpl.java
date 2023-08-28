package com.tcs.library.lms.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.library.lms.model.Author;
import com.tcs.library.lms.model.Book;
import com.tcs.library.lms.model.BorrowingRecord;
import com.tcs.library.lms.model.BorrowingRequest;
import com.tcs.library.lms.repository.AuthorRepo;
import com.tcs.library.lms.repository.BookRepo;
import com.tcs.library.lms.repository.BorrowingRecordRepo;

@Service
public class LmsServiceImpl implements LmsService {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private AuthorRepo authorRepo;

	@Autowired
	private BorrowingRecordRepo borrowingRecordRepo;

	@Override
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Author createAuthor(Author author) {
		return authorRepo.save(author);
	}

	@Override
	public BorrowingRecord borrowingBook(BorrowingRequest borrowingRequest) {
		Optional<Book> book = getBook(borrowingRequest.getBookId());
		BorrowingRecord borrowingRecord= new BorrowingRecord();
		if (book.isPresent()) {
			book.get().setStatus(book.get().getStatus().BORROWED);
			//updateBook(book);
			borrowingRecord.setBook(book.get());
			borrowingRecord.setBorrowingDate(LocalDate.now());
			borrowingRecord.setUser(borrowingRequest.getUserName());
			return borrowingRecordRepo.save(borrowingRecord);
		}
		return null;
	}

	@Override
	public Optional<Book> getBook(Long id) {
		// TODO Auto-generated method stub
		return Optional.of(bookRepo.findById(id).orElse(null)) ;
	}

	@Override
	public Book updateBook(Book book) {

		return bookRepo.save(book);
	}

	@Override
	public boolean deleteBook(Long id) {

		Optional<Book> book = getBook(id);

		if (book.isPresent()) {
			bookRepo.delete(book.get());
			return true;
		}
		return false;
	}

	@Override
	public List<Book> getAllBookByAuthor(Long id) {
		// TODO Auto-generated method stub
		Optional<Author> author = getAuthor(id);
		List<Book> books = null;
		if (author.isPresent()) {

	        books = author.get().getBooks();
		}
		return books;
	}

	@Override
	public BorrowingRecord returnBook(BorrowingRequest borrowingRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Author> getAuthor(Long id) {
		// TODO Auto-generated method stub
		System.out.println(authorRepo.findById(id));
		return Optional.of(authorRepo.findById(id).orElse(null));
	}

	@Override
	public Author updateAuthor(Author author) {
		// TODO Auto-generated method stub
		return authorRepo.save(author);
	}

	@Override
	public boolean deleteAuthor(Long id) {
		// TODO Auto-generated method stub
		Optional<Author> author = getAuthor(id);

		if (author.isPresent()) {
			authorRepo.delete(author.get());
			return true;
		}
		return false;
	}

}
