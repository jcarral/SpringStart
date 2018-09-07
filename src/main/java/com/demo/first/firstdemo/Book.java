package com.demo.first.firstdemo;

public class Book {
	private Editorial editorial;
	private String name;
	private Author author;
	private Loan loan;

	public Book() {
	}

	public Book(Editorial editorial, String name, Author author, Loan loan) {
		super();
		this.editorial = editorial;
		this.name = name;
		this.author = author;
		this.loan = loan;
	}

	/**
	 * @return the editorial
	 */
	public Editorial getEditorial() {
		return editorial;
	}

	/**
	 * @param editorial the editorial to set
	 */
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
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

	/**
	 * @return the author
	 */
	public Author getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Author author) {
		this.author = author;
	}

	/**
	 * @return the loan
	 */
	public Loan getLoan() {
		return loan;
	}

	/**
	 * @param loan the loan to set
	 */
	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [editorial=" + editorial + ", name=" + name + ", author=" + author + ", loan=" + loan + "]";
	}

}
