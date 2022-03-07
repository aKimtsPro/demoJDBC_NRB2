package com.example.demo;

import com.example.demo.dao.SectionDAO;
import com.example.demo.entities.Section;
import com.example.demo.exceptions.ElementNotFoundException;

public class Main {
	
	public static void main(String[] args) {

		SectionDAO dao = new SectionDAO();
		
		Section s = new Section(9999, "test", 1);
		
		if(dao.insert(s))
			System.out.println("works");
		else 
			System.out.println("dont works");
		
		try {
			System.out.println(dao.getOne(9999));
		} catch (ElementNotFoundException e) {
			System.out.println("not workin");
		}
		
	}

}
