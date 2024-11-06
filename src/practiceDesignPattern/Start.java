package practiceDesignPattern;

import creationalDesignPattern.builder.Phone;
import creationalDesignPattern.builder.PhoneBuilder;
import creationalDesignPattern.factory.Vehicle;
import creationalDesignPattern.factory.VehicleFactory;
import creationalDesignPattern.factory.VehicleType;
import structuralDesignPattern.adapter.AudioPlayer;

public class Start {

	public static void main(String[] args) {
		
		//1. factory: Creational 
		//Client do not need to worry about how end product is created. only factory.
		//loose coupling with product.
		//new products/classes of product can be easily added.
		//i.e. Supports open/close principle.
		//Centralized object creation, hence ease of management and debugging.
		Vehicle bike = VehicleFactory.getVehicle(VehicleType.BIKE);
		bike.move();
		
		Vehicle car = VehicleFactory.getVehicle(VehicleType.CAR);
		car.move();
		
		//2. builder
		//with builder, create complex objects step by step.
		//allows immutable objects, as builder is only allowed to set properties. hence thread safe.
		Phone iphone = new PhoneBuilder().setStorage(256).setBrand("apple").getPhone();
		iphone.getConfigurations();
		//3. adaptor
		//AudioPlayer is already existing class implementing MediaPlayer.
		//Add support of VideoPlayer which has different method signature.
		AudioPlayer adPlayer = new AudioPlayer();
		adPlayer.play("mp3", "usr/local/song1.mp4");
		adPlayer.play("3gp", "usr/local/song2.3gp");
		
		//Made existing audioPlayer to play video as well. 
		AudioPlayer player = new AudioPlayer();
		player.play("mp4", "usr/local/video.mp4");
	}

}
