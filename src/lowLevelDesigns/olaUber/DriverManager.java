package lowLevelDesigns.olaUber;

import java.util.HashMap;

public class DriverManager {

	private static DriverManager manager;
	private HashMap<String, Driver> drivers;
	
	public static DriverManager getInstance() {
		//if multiple threads have reached to get manager at time when instance has not yet been created.
		if(null == manager) {
			synchronized (DriverManager.class) {
				//first thread to enter must only create the instance and rest of waiting threads should not.
				if(null == manager) {
					manager = new DriverManager();
				}
			}
		}
		return manager;
	}
	
	private DriverManager() {
		drivers = new HashMap<>();
	}
	
	public Driver getDriver(String id) {
		return drivers.get(id);
	}
	
	public void addDriver(String id, Driver driver) {
		drivers.put(id, driver);
	}
}
