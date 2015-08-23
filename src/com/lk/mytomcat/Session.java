package com.lk.mytomcat;

import java.util.Date;
import java.util.HashMap;

public class Session {

	public String sid;

	
	public Long time=null;
	
	public Session(){
		setTime();
	}
	
	public void setTime(){
		time=new Date().getTime();
	}
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	private HashMap<String, Object> attributes = new HashMap();

	public void addAttribute(String key, Object obj) {
		attributes.put(key, obj);
	}

	public void removeAttribute(String key) {
		attributes.remove(key);
	}

	public Object getAttribute(String key) {
		return attributes.get(key);
	}
}
