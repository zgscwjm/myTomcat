package com.test;

import java.io.FileInputStream;

import com.lk.mytomcat.HttpServlet;
import com.lk.mytomcat.Request;
import com.lk.mytomcat.Response;
import com.lk.mytomcat.Session;

public class Test2 extends HttpServlet {

	@Override
	public void doGet(Request r, Response rs) throws Exception {

		Session session=r.getSession();
		System.out.println(session.getSid());
		
	 
		System.out.println(session.getAttribute("KKK"));
		
		rs.setResponseTou("text/html");
	 
		rs.end();

	 
		rs.out.close();

	}

}
