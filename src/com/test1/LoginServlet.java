package com.test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.lk.mytomcat.HttpServlet;
import com.lk.mytomcat.Request;
import com.lk.mytomcat.Response;

public class LoginServlet extends HttpServlet {

	@Override
	public void doGet(Request r, Response rs) throws Exception {
		// TODO Auto-generated method stub
		doPost(r, rs);
	}

	@Override
	public void doPost(Request r, Response rs) throws Exception {

		String username = r.getP("username");
		String password = r.getP("password");

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:sqlserver://localhost:1433;DatabaseName=test", "sa", "");
		ResultSet rs1 = conn.createStatement().executeQuery(
				"SELECT * FROM USERS WHERE USERNAME='" + username
						+ "'  and PASSWORD='" + password + "'");
		try {
			if (rs1.next()) {

				r.getSession().addAttribute("username", username);
				rs.setResponseTou("text/html;charset=gbk");
				rs.end();
				rs.out.println("»¶Ó­µÇÂ¼£¡");
				rs.out.close();

			} else {

				rs.goToPage("login.html");
				return;
			}
		} finally {
			conn.close();
		}
	}

}
