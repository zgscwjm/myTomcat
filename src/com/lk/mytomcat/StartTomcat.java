package com.lk.mytomcat;

public class StartTomcat {
	public static void main(String[] args) {

		try {
			TomcatServer.openServer();
		} catch (Exception e) {
			try {
				TomcatServer.closeServer();
			} catch (Exception e1) {

			}
		}

	}
}
