package com.lk.mytomcat;

import java.util.Hashtable;

public class Tou {
	private String method = null;
	private String p = null;
	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	private String url = null;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getAccept_language() {
		return accept_language;
	}

	public void setAccept_language(String acceptLanguage) {
		accept_language = acceptLanguage;
	}

	public String getUser_agent() {
		return user_agent;
	}

	public void setUser_agent(String userAgent) {
		user_agent = userAgent;
	}

	public String getAccept_encoding() {
		return accept_encoding;
	}

	public void setAccept_encoding(String acceptEncoding) {
		accept_encoding = acceptEncoding;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getCookie() {
		return cookie;
	}

	public void setCookie(String cookie) {
		this.cookie = cookie;
	}

	public Hashtable<String, String> getTable() {
		return table;
	}

	public void setTable(Hashtable<String, String> table) {
		this.table = table;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	private String accept = null;
	private String accept_language = null;
	private String user_agent = null;

	private String accept_encoding = null;
	private String ip = null;
	private String port = null;

	private String connection = null;
	private String cookie = null;
	private Hashtable<String, String> table = null;

	private String txt = null;
}
