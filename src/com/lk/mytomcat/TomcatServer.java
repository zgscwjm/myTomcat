package com.lk.mytomcat;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatServer extends Thread {
	private Socket socket = null;
	public TomcatServer(Socket socket) {
		this.socket = socket;
	}

	// 执行客户端请求
	public void run() {

		try {
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			// 得到请求头内容
			byte[] b = new byte[1024 * 1024];
			in.read(b);
			String txt = new String(b).trim();

			// 请求头的处理
			JieXiQingQiuTouIF jiexi = (JieXiQingQiuTouIF) Class.forName(
					TomcatConfig.get("tomcat.tou.class")).newInstance();
			Tou t = jiexi.jiexi(txt);

			// 请求头的封装
			Request r = new Request();
			r.setP(t.getP());
			r.setTou(t);

			Response re = new Response(r);
			
			
			r.updateSessionTime();
			if (WEBConfig.get(t.getUrl()) != null) {
				//有这个类
				try {
					Servlet servlet = (Servlet) Class.forName(
							WEBConfig.get(t.getUrl())).newInstance();
					re.setOut(out);
					servlet.service(r, re);
				} catch (Exception ex) {
					File f = new File(TomcatConfig.get("tomcat.webapp"),
							"500.html");
					FileInputStream fin = new FileInputStream(f);
					byte[] b1 = new byte[(int) f.length()];
					PrintWriter w=new PrintWriter(out);
					w.println("HTTP/1.1 200 OK");
					w.println("Server: "+TomcatConfig.get("tomcat.server.name"));
					w.println("Connection: Keep-Alive");
					w.println("Content-Type: text/html");
					w.println("Cache-control: private");
					w.println();
					w.flush();
					fin.read(b1);
					fin.close();
					out.write(b1);

				}
			} else {
				
				
				File f = new File(TomcatConfig.get("tomcat.webapp"), t.getUrl());
				if (!f.exists()) {
					f = new File(TomcatConfig.get("tomcat.webapp"), "404.html");
				}
				FileInputStream fin = new FileInputStream(f);
				byte[] b1 = new byte[(int) f.length()];
				fin.read(b1);
				fin.close();
				
				
				PrintWriter w=new PrintWriter(out);
				w.println("HTTP/1.1 200 OK");
				w.println("Server: "+TomcatConfig.get("tomcat.server.name"));
				w.println("Connection: Keep-Alive");
				w.println("Content-Type: text/html");
				w.println("Cache-control: private");
				w.println();
				w.flush();
				out.write(b1);
			}
			out.close();
			in.close();
			socket.close();

		} catch (Exception ex) {
		}

	}

	private static ServerSocket server = null;

	public static void openServer() throws Exception {

		server = new ServerSocket(Integer.parseInt(TomcatConfig
				.get("tomcat.port")));
		// Socket socket=server.accept();
		while (true)
			new TomcatServer(server.accept()).start();

	}

	public static void closeServer() throws Exception {
		if (server != null) {
			if (!server.isClosed()) {
				server.close();
			}
		}
	}

}
