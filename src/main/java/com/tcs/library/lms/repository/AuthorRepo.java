package com.tcs.library.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.library.lms.model.Author;

public interface AuthorRepo extends JpaRepository<Author, Long>{

}
