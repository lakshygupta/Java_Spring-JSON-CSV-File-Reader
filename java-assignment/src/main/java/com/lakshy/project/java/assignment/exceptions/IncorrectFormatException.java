package com.lakshy.project.java.assignment.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncorrectFormatException extends RuntimeException {
	String fieldName;
	String expectedType;
	String foundType;
	
	public IncorrectFormatException(String fieldName, String expectedType, String foundType) {
		super(String.format("Invalid Value type in field %s, Expected Type : %s, Found Type : %s",fieldName,expectedType,foundType));
		this.fieldName = fieldName;
		this.expectedType = expectedType;
		this.foundType = foundType;
	}
	
	
}
