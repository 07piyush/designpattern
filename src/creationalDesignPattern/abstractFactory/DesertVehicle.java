package creationalDesignPattern.abstractFactory;

public class DesertVehicle implements Vehicle{

	@Override
	public void start() {
		System.out.println("starting dessert SUV");
		
	}

	@Override
	public void move() {
		System.out.println("Moving dessert SUV");
		
	}

}
