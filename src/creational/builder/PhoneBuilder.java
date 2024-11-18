package creational.builder;

public class PhoneBuilder {

	private String brand;
	private String model;
	private long storage;
	private int cameraFront;
	private int cameraBack;
	private int ram;
	private int os;
	
	public PhoneBuilder setBrand(String brand) {
		this.brand = brand;
		return this;
	}
	public PhoneBuilder setModel(String model) {
		this.model = model;
		return this;
	}
	public PhoneBuilder setStorage(long storage) {
		this.storage = storage;
		return this;
	}
	public PhoneBuilder setCameraFront(int cameraFront) {
		this.cameraFront = cameraFront;
		return this;
	}
	public PhoneBuilder setCameraBack(int cameraBack) {
		this.cameraBack = cameraBack;
		return this;
	}
	public PhoneBuilder setRam(int ram) {
		this.ram = ram;
		return this;
	}
	public PhoneBuilder setOs(int os) {
		this.os = os;
		return this;
	}
	
	public Phone getPhone() {
		return new Phone(brand, model, storage, cameraFront, cameraBack, ram, os);
	}
	
}
