package com.zzu.cxsj.Dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentDaoTest {

	@Test
	public void testListAllBook() {
		StudentDao stud = new StudentDao();
		System.out.println(stud.listAllBook("20142480223"));
	}

}
