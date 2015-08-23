package com.test1;

import com.lk.mytomcat.HttpServlet;
import com.lk.mytomcat.Request;
import com.lk.mytomcat.Response;

public class ShowServlet extends HttpServlet {

	@Override
	public void doGet(Request r, Response rs) throws Exception {
		// TODO Auto-generated method stub
		doPost(r, rs);
	}

	@Override
	public void doPost(Request r, Response rs) throws Exception {

		try {
			String username = (String) r.getSession().getAttribute("username");

			if (username == null) {
				rs.goToPage("login.html");
				return;
			} else {

				rs.setResponseTou("text/html;charset=gbk");
				rs.end();
				rs.out.println("»¶Ó­[" + username + "]µÇÂ¼£¡");
				rs.out.close();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
