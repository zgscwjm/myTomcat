package com.lk.mytomcat;

import java.util.HashMap;
import java.util.Vector;

public class Request {
	

	public String sessionCookie = "";
	
	public void updateSessionTime(){
		Session session=SessionObjectPool.getSessionObjectPool()
		.getSession2(this.getCookie("JSESSIONID"));
		if(session!=null){
			session.setTime();
			
		}
		
	}

	public Session getSession() {
		// JSESSIONID=
		Session ss = SessionObjectPool.getSessionObjectPool().getSession(
				this.getCookie("JSESSIONID"));
		sessionCookie = "JSESSIONID=" + ss.getSid();
        
		return ss;
	}

	private Tou tou = null;

	private Vector<Cookie> cookies = new Vector<Cookie>();
	public Vector<Value> p = new Vector();

	public void setP(String p1) {
		if (p1 == null || p1.trim().equals("")) {
			return;
		}
		String[] ss = p1.split("&");

		for (String string : ss) {
			Value v = new Value();
			v.setKey(string.split("=")[0]);
			v
					.setValue(string.split("=").length > 1 ? string.split("=")[1]
							: "");
			p.add(v);
		}

	}

	public String getP(String key) {
		for (Value v : p) {
			if (v.getKey().equalsIgnoreCase(key)) {
				return v.getValue();
			}
		}
		return null;
	}

	public String[] getPs(String key) {
		Vector<String> vv = new Vector();

		for (Value v : p) {
			if (v.getKey().equalsIgnoreCase(key)) {
				vv.add(v.getValue());
			}
		}
		if (vv.size() < 1) {
			return null;
		}
		Object[] obj = vv.toArray();

		String[] ss = new String[obj.length];
		for (int i = 0; i < obj.length; i++) {
			ss[i] = obj[i].toString();
		}
		return ss;
	}

	public String getCookie(String key) {

		for (Cookie cc : cookies) {
			if (cc.getKey().equalsIgnoreCase(key)) {
				return cc.getValue();
			}

		}
		return null;

	}

	public void setTou(Tou tou) {
		this.tou = tou;
		String cookie = tou.getCookie();
		String[] cookies = cookie.split("; ");
		for (String string : cookies) {
			String[] cc = string.split("=");

			Cookie c = new Cookie();
			c.setKey(cc[0]);
			c.setValue(cc.length > 1 ? cc[1] : null);
			this.cookies.add(c);

		}
	}

	public Tou getTou() {
		return tou;
	}
}
