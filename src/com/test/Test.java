package com.test;

import java.io.FileInputStream;

import com.lk.mytomcat.HttpServlet;
import com.lk.mytomcat.Request;
import com.lk.mytomcat.Response;
import com.lk.mytomcat.Session;

public class Test extends HttpServlet {

	@Override
	public void doGet(Request r, Response rs) throws Exception {

		System.out.println(r.getP("wjm"));
//		rs.goToPage("a.html");
		//Session session=r.getSession();
//		System.out.println(session.getSid());
//		
		//session.addAttribute("KKK", "LISI");
//		
//		
		rs.setResponseTou("text/html");
//		rs.addCookie("username1", "aaaaaaaaaa");
//		rs.addCookie("username2", "aaaaaaaaaa");
//		rs.addCookie("username3", "aaaaaaaaaa");
//		rs.addCookie("username4", "aaaaaaaaaa");
		rs.end();
//
//		System.out.println(r.getCookie("username1"));
//		System.out.println(r.getCookie("username2"));
//		System.out.println(r.getCookie("username3"));
//		System.out.println(r.getCookie("username4"));
//	 
//		//
//		// FileInputStream fin = new FileInputStream("webapp//aaa.ppt");
//		//
//		// byte[] b = new byte[fin.available()];
//		// fin.read(b);
//		//
//		// rs.out8.write(b);
//		// rs.out8.flush();
//
		rs.out.close();

	}

}
