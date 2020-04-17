package com;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.jni.Time;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gyhl.test.entity.User;
import com.gyhl.test.mapper.UserMapper;


@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SpringBoot01Test2ApplicationTests {

	/*
	 * @Autowired private UserMapper um;
	 */
	@Test
	void contextLoads() {
	 Date ddDate=new Date();
	 System.out.println(ddDate.getTime());
	 
	 String aaString="asdas-aeadg-xxx-zz-x-xxxx";
	 String[] argStrings=aaString.split("-");
	 System.out.println(argStrings.length);
	}

	@Autowired
	private UserMapper um;

	@Test
	 void contextLodaads() {

		User u1 = new User();
		u1.setId(1);
		u1.setName("zzz");

		try {
			um.insert(u1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}
	
	
	@Test
	void excel() {
		
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		System.out.println(a.size());
	}
}
