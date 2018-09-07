package com.demo.first.firstdemo;

public class Library {
	private Book book;
	private String name;

	public Library() {
	}

	public Library(Book book, String name) {
		super();
		this.book = book;
		this.name = name;
	}

	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
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
		return "Library [book=" + book + ", name=" + name + "]";
	}

}
