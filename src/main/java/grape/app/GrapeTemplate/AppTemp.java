package grape.app.GrapeTemplate;

import httpServer.booter;

public class AppTemp {
	public static void main(String[] args) {
		booter booter = new booter();
		System.out.println("GrapeTemp!");
		try {
			System.setProperty("AppName", "GrapeTemp");
			booter.start(6002);
		} catch (Exception e) {

		}
	}
}
