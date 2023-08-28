package com.tcs.library.lms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.library.lms.model.Author;
import com.tcs.library.lms.model.Book;
import com.tcs.library.lms.model.BorrowingRecord;
import com.tcs.library.lms.model.BorrowingRequest;
import com.tcs.library.lms.service.LmsService;

@RestController
@RequestMapping("/lms-api/v1/")
public class LmsController {

	@Autowired
	private LmsService LmsService;
	
	@PostMapping("/book")
    public Book createBook(@RequestBody Book book) {
		return LmsService.createBook(book);
    }
	@GetMapping("/book/{id}")
    public Optional<Book> getBook(@PathVariable Long id) {
		return LmsService.getBook(id);
    }
	@PostMapping("/author")
    public Author createAuthor(@RequestBody Author author) {
		return LmsService.createAuthor(author);
    }
	@GetMapping("/author/{id}")
    public Author getAuthor(@PathVariable Long id) {
		return LmsService.getAuthor(id).get();
    }
	@PostMapping("/borrowing-book")
    public BorrowingRecord borrowingBook(@RequestBody BorrowingRequest borrowingRequest) {
		return LmsService.borrowingBook(borrowingRequest);
    }
	@DeleteMapping("/author/{id}")
    public String deleAuthor(@PathVariable Long id) {
		return LmsService.deleteAuthor(id)?"succes":"failed";
    }
	@DeleteMapping("/book/{id}")
    public String delebook(@PathVariable Long id) {
		return LmsService.deleteBook(id)?"succes":"failed";
    }
}
