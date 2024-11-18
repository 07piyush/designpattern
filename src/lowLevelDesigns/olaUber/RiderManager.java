package lowLevelDesigns.olaUber;

import java.util.HashMap;

public class RiderManager {

	private HashMap<String, Rider> riders;
	private static RiderManager manager;
	
	//lazy initialization with double checked locking. to prevent overhead of synchronized every time manager is 
	//requested by a client.
	public static RiderManager getInstance() {
		//if manager is already created then no need to block threads from getting the instance. 
		if(null == manager) {
			//multiple threads can be queued at a time when instance was not created.
			synchronized (RiderManager.class) {
				//only first thread that pass through creates the instance.
				if(null == manager) {
					manager  = new RiderManager();
				}
			}
		}
		return manager;
	}
	
	private RiderManager() {
		riders = new HashMap<>();
	}
	
	public void addRider(String id, Rider rider) {
		riders.put(id, rider);
	}
	
	public Rider getRider(String id) {
		return riders.get(id);
	}
}
