package com.demo.first.firstdemo;

public class Loan {
	private String reference;

	public Loan() {
	}

	public Loan(String reference) {
		super();
		this.reference = reference;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Loan [reference=" + reference + "]";
	}

}
