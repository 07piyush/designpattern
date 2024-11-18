package creational.abstractFactory;

public class SnowVehicle implements Vehicle{

	@Override
	public void start() {
		System.out.println("starting snow rover..");
		
	}

	@Override
	public void move() {
		System.out.println("moving snow rover");
		
	}

}
