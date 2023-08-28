package com.tcs.library.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.library.lms.model.Book;

public interface BookRepo extends JpaRepository<Book, Long>{

}
