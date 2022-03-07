package com.example.demo.exceptions;

public class ElementNotFoundException extends Exception {
	
	private final Object id;

	public ElementNotFoundException(Object id) {
		super("element with id {"+id+"} not found");
		this.id = id;
	}

	public Object getId() {
		return id;
	}

}
