package com.example.demo.entities;

public class Section {

	private long id;
	private String name;
	private long delegate;
	
	
	public Section() {
		super();
	}
	
	public Section(long id, String name, long delegate) {
		super();
		this.id = id;
		this.name = name;
		this.delegate = delegate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDelegate() {
		return delegate;
	}
	public void setDelegate(long delegate) {
		this.delegate = delegate;
	}

	@Override
	public String toString() {
		return "Section [id=" + id + ", name=" + name + ", delegate=" + delegate + "]";
	}
	
	
	
	
	
}
