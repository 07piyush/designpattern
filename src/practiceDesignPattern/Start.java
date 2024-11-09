package practiceDesignPattern;

import java.sql.Connection;
import java.sql.SQLException;

/*
 * Creational design patterns are a category of design patterns focused on managing the process of 
 * object creation. Instead of directly instantiating objects, these patterns provide ways to create 
 * objects that are flexible, scalable, and optimized for specific use cases. They aim to abstract the 
 * instantiation process, making systems more adaptable to changing requirements and enhancing object reuse.
 * 
 * Structural Design Pattern, 
 * 
 * 
 * Behavioral Design pattern,
 * 
 * */

import creationalDesignPattern.abstractFactory.DesertFactory;
import creationalDesignPattern.abstractFactory.DesertVehicle;
import creationalDesignPattern.abstractFactory.DesertWeapon;
import creationalDesignPattern.abstractFactory.RegionFactory;
import creationalDesignPattern.abstractFactory.SnowFactory;
import creationalDesignPattern.builder.Phone;
import creationalDesignPattern.builder.PhoneBuilder;
import creationalDesignPattern.factory.Vehicle;
import creationalDesignPattern.factory.VehicleFactory;
import creationalDesignPattern.factory.VehicleType;
import creationalDesignPattern.prototype.Rifle;
import creationalDesignPattern.singleton.ConnectionPoolManager;
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
		
		//3. Abstract factory : Creational
		/*
		 * Provides interface for creating families of related/dependent objects 
		 * without specifying their concrete classes.
		 * 
		 * E.g pubg game can have different entities like weapons and vehicle.
		 * there may be different regions/environments like dessert, snow, forest etc.
		 * depending on region there can be different type of entities with different behavior.
		 * like a dessertWeapon are sniper category, snowWeapns are machineGuns etc
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
		DesertWeapon gun = (DesertWeapon) desertFactory.createWeapon();
		gun.shoot();
		suv.start();
        suv.move();
        
        //4. Prototype : Creational
        /*
         * 1. Allows to create object by cloning existing object. rather than creating from scratch.
         * Advantages : 
         * Reduce object creation time.
         * Simplify customization 
         * 
         * */
        Rifle basicSniper = new Rifle();
        
        try {
        	Rifle intermediateSniper = (Rifle) basicSniper.clone();
        	intermediateSniper.attachScope("4x");
        	
			Rifle advanceSniper = (Rifle) basicSniper.clone();
			advanceSniper.attachScope("8x");
			
		} catch (CloneNotSupportedException e) {
			System.out.println("Rifle could not be cloned" + e);
		}
        
        //5. Singleton Design pattern.
        /*
         * singleton pattern ensures there exists exactly one instance of a class throughout the lifecycle.
         * and also provide global point of access for that instance.
         * This instance can be created only when needed. (lazy initialization.)
         * 
         * Best example of singleton is a connection pool manager, since creating a new
         * connection is a time and resources expensive task, so idea is to have a queue
         * of connections and provide an interface to clients to fetch connections from the pool.
         * 
         * since this pool has to be available to all the clients throughout the lifecycle
         * hence there must be only one instance of manager.
         * */
        ConnectionPoolManager manager = ConnectionPoolManager.getInstance();
        Connection connection = manager.getConnection();
        //do some database querying.
        manager.releaseConnection(connection);
		
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
