package com.tcs.library.lms.model;

import lombok.Data;

@Data
public class BorrowingRequest {

	private Long bookId;
	private Long borrowingId;
	private String userName;
}
