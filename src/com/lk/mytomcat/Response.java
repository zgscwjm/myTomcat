package com.lk.mytomcat;

import java.io.PrintWriter;

public class Response {
	Request rs = null;

	public Response(Request rs) {
		this.rs = rs;
	}

	/*
	 * p.println("HTTP/1.1 307 Temporary Redirect");
	 * p.println("Location: a.html");
	 */

	public void goToPage(String url) {
		out.println("HTTP/1.1 307 Temporary Redirect");
		out.println("Location: " + url);
		out.flush();
	}

	public void setResponseTou(String type) {
		out.println("HTTP/1.1 200 OK");
		out.println("Server: " + TomcatConfig.get("tomcat.server.name"));
		out.println("Content-Type: " + type);
		out.println("Set-Cookie:" + rs.sessionCookie + "; path=/");

	}

	public void addCookie(String key, String value) {
		out.println("Set-Cookie:" + key + "=" + value + "; path=/");
		out.flush();

	}

	public void end() {
		out.println("Connection: Keep-Alive");
		out.println();
		out.flush();

	}

	public java.io.PrintWriter out = null;
	public java.io.OutputStream out8 = null;

	public java.io.PrintWriter getOut() {
		return out;
	}

	public void setOut(java.io.OutputStream out8) {
		this.out = new PrintWriter(out8);
		this.out8 = out8;
	}

}
