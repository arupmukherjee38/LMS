package com.tcs.library.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.library.lms.model.BorrowingRecord;

public interface BorrowingRecordRepo extends JpaRepository<BorrowingRecord, Long>{

}
