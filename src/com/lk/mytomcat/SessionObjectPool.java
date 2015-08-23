package com.lk.mytomcat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class SessionObjectPool {
	public int toInt(Date t) {
		Calendar c2 = java.util.Calendar.getInstance();
		c2.setTime(t);

		String s1 = (c2.get(c2.HOUR_OF_DAY)) + "";
		String s2 = (c2.get(c2.MINUTE)) + "";

		if (s2.length() == 1) {
			s2 = "0" + s2;
		}
		return Integer.parseInt(s1 + s2);
	}

	public int toInt(Date t, int m) {
		Calendar c2 = java.util.Calendar.getInstance();
		c2.setTime(t);
		c2.add(c2.MINUTE, m);
		String s1 = (c2.get(c2.HOUR_OF_DAY)) + "";
		String s2 = (c2.get(c2.MINUTE)) + "";

		if (s2.length() == 1) {
			s2 = "0" + s2;
		}
		return Integer.parseInt(s1 + s2);
	}

	private SessionObjectPool() {

		new Thread() {

			public void run() {
				while (true) {
					HashMap mm = (HashMap) map.clone();
					Set<String> sets = mm.keySet();
					for (String string : sets) {
						Session session = (Session) mm.get(string);
						Calendar c1 = java.util.Calendar.getInstance();

						int l = toInt(new Date(session.time), Integer
								.parseInt(TomcatConfig
										.get("tomcat.session.time")));
						int n = toInt(new Date());

						if (l <= n) {
							map.remove(string);
						}
						try {
							Thread.sleep(1000 * 3);
						} catch (Exception e) {
						}

					}
				}

			};

		}.start();

	}

	private HashMap<String, Session> map = new HashMap();

	public Session getSession(String sid) {
		HashMap mm = (HashMap) map.clone();
		Session session = (Session) mm.get(sid);
		if (session == null) {
			session = new Session();
			session.setSid("MYWEB1" + new Date().getTime() + "R"
					+ ((int) (1000000 * Math.random())));
			map.put(session.getSid(), session);
		}
		return session;
	}

	public Session getSession2(String sid) {
		HashMap mm = (HashMap) map.clone();
		Session session = (Session) mm.get(sid);

		return session;
	}

	private static SessionObjectPool pool = new SessionObjectPool();

	public static SessionObjectPool getSessionObjectPool() {

		return pool;
	}
}
