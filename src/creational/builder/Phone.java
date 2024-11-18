package creational.builder;

public class Phone {

	private String brand;
	private String model;
	private long storage;
	private int cameraFront;
	private int cameraBack;
	private int ram;
	private int os;
	
	public Phone(String brand, String model, long storage, int cameraFront, int cameraBack, int ram, int os) {
		super();
		this.brand = brand;
		this.model = model;
		this.storage = storage;
		this.cameraFront = cameraFront;
		this.cameraBack = cameraBack;
		this.ram = ram;
		this.os = os;
	}

	public Phone() {
		
	}
	
	public void getConfigurations() {
		System.out.println("Brand : " + brand 
				+ "model : " + model
				+ "storage : " + storage
				+ "ram : " + ram);
	}
	
}
