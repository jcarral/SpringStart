package com.demo.first.firstdemo;

public class Editorial {
	private String name;
	private String owner;

	public Editorial(String name) {
		super();
		this.name = name;
	}

	public Editorial() {
	};

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
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
		return "Editorial [name=" + name + ", owner=" + owner + "]";
	}
}
