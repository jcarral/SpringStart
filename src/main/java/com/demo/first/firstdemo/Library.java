package com.demo.first.firstdemo;

import java.util.List;

public class Library {
	private List<Book> books;
	private String name;

	public Library() {
	}

	public Library(List<Book> books, String name) {
		super();
		this.books = books;
		this.name = name;
	}

	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}

	/**
	 * @param book the book to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Library [book=" + books + ", name=" + name + "]";
	}

}
