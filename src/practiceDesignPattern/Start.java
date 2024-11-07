package practiceDesignPattern;

import creationalDesignPattern.abstractFactory.DesertFactory;
import creationalDesignPattern.abstractFactory.DesertVehicle;
import creationalDesignPattern.abstractFactory.RegionFactory;
import creationalDesignPattern.abstractFactory.SnowFactory;
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
		
		//2. builder : Creational
		//with builder, create complex objects step by step.
		//allows immutable objects, as builder is only allowed to set properties. hence thread safe.
		Phone iphone = new PhoneBuilder().setStorage(256).setBrand("apple").getPhone();
		iphone.getConfigurations();
		
		//3. Abstract factory
		/*
		 * Provides interface for creating families of related/dependent objects 
		 * without specifying their concrete classes.
		 * 
		 * E.g pubg game can have different entities like weapons and vehicle.
		 * there may be different regions/environments like dessert, snow, forest etc.
		 * depending on region there can be different type of entities with different behavior.
		 * like a dessertWeapon are snipper category, snowWeapns are machineGuns etc
		 * and a dessertVehicle are suv category, snowVehicle are roller etc
		 * 
		 * so depending on region weapon, vehicle etc entities are related.
		 * 
		 * 1. create abstract products. (entity's general behavior)
		 * 2. create concrete products. (exact entity class : dessertWeapn, snowWeapon etc)
		 * 3. create abstract factory. (based on region will give exact factory for that region)
		 * 4. create concrete factories. (exact factories for each region)
		 * 5. client code : create game environment. environment has weapon, vehicle, etc.
		 * 					client will ask for weapon for dessert or vehicle for dessert etc.
		 * 
		 * */
		
		RegionFactory desertFactory = new DesertFactory();
        RegionFactory snowFactory = new SnowFactory();
        //using above factories create objects of entities and supply to individual game environments.
        //there can be multple rooms, of different regions with different set of players in parallel.
		DesertVehicle suv = (DesertVehicle) desertFactory.createVehicle();
		suv.start();
        suv.move();
		
		//3. adaptor : structural
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
