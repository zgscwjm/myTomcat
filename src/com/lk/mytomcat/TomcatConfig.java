package com.lk.mytomcat;

import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

public class TomcatConfig {
	
	public static String get(String key){
		return table.get(key);
	}
	private static Hashtable<String, String> table = null;
	static {
		try {
			// 加载配置文件信息
			FileInputStream file = new FileInputStream(".//tomcat.config");
			java.util.Properties p = new Properties();
			p.load(file);
			table = new Hashtable();
			Set<Object> s = p.keySet();
			for (Object obj : s) {
				table.put(obj.toString(), p.getProperty(obj.toString()));
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(0);
		}
	}

}
