package com.lk.mytomcat;

import java.util.Hashtable;

public class JieXiQingQiuTouImpl implements JieXiQingQiuTouIF {

	@Override
	public Tou jiexi(String txt) throws Exception {

		if (txt.length() < 50) {
			throw new Exception("非法请求！");

		}

		Tou t = new Tou();
		t.setTxt(txt);

		String a = txt.substring(0, txt.indexOf("\n"));

		String method = (a.substring(0, a.indexOf(" ")));

		String http = (a.substring(a.lastIndexOf(" ") + 1, a.length()));
		String url = (a.substring(a.indexOf(" ") + 1, a.lastIndexOf(" ")));
		// /a.html?username=100&password=111
		String p = "";

		if (method.equalsIgnoreCase("post")) {

			try {
				p = (txt.substring(txt.lastIndexOf("\n")+1, txt.length()));
			} catch (Exception ex) {
			}

		}
		if (method.equalsIgnoreCase("get")) {

			try {
				p = url.substring(url.indexOf("?") + 1, url.length());
				url = url.substring(0, url.indexOf("?"));
			} catch (Exception ex) {
			}

		}

		t.setP(p);

		t.setMethod(method);
		t.setUrl(url);

		String[] yyy = txt.split("\n");
		Hashtable<String, String> table = new Hashtable();
		for (String string : yyy) {
			String[] k = string.split(": ");
			table
					.put(k[0], k.length <= 1 ? "" : k[1].replace('\n', ' ')
							.trim());
		}

		t.setTable(table);
		t.setAccept(table.get("Accept"));
		t.setAccept_encoding(table.get("Accept-Encoding"));
		t.setAccept_language(table.get("Accept-Language"));
		t.setConnection(table.get("Connection"));
		t.setPort(table.get("Host").split(":")[1]);
		t.setIp(table.get("Host").split(":")[0]);
		t.setCookie(table.get("Cookie"));
		
		

		return t;
	}
	//
	// public static void main(String[] args) {
	// String url = "GET / HTTP/1.1\n"
	// +
	// "Accept: image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, application/x-ms-application, application/x-ms-xbap, application/vnd.ms-xpsdocument, application/xaml+xml, */*\n"
	// + "Accept-Language: zh-cn\n"
	// +
	// "User-Agent: Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)\n"
	// + "Accept-Encoding: gzip, deflate\n" + "Host: 127.0.0.1:8080\n"
	// + "Connection: Keep-Alive\n"
	// + "Cookie: s_fid=08B7BF94570D28FD-245AF5DD68268849\n";
	// String[] yyy = url.split("\n");
	// for (int i = 0; i < yyy.length; i++) {
	//
	// System.out.println(yyy[i].split(": ")[0]);
	// }
	// }

}
