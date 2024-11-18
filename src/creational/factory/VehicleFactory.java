package creational.factory;

public class VehicleFactory {
	
	public static Vehicle getVehicle(VehicleType type) {
	
		Vehicle vehicle = null;
		switch(type) {
		
		case BIKE : vehicle = new Bike();
			break;
		case CAR : vehicle = new Car();
			break;
		default:
			
		}
		
		return vehicle;
	}

}
