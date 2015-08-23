package com.lk.mytomcat;

public class HttpServlet implements Servlet {

	@Override
	public void service(Request r, Response rs)throws Exception {

		if (r.getTou().getMethod().equalsIgnoreCase("post")) {
			doPost(r, rs);

		} else {
			doGet(r, rs);

		}

	}

	public void doGet(Request r, Response rs)throws Exception {

	}

	public void doPost(Request r, Response rs)throws Exception {

	}

}
