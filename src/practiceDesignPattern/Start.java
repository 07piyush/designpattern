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
import structuralDesignPattern.bridge.Circle;
import structuralDesignPattern.bridge.RasterRenderer;
import structuralDesignPattern.bridge.Rectangle;
import structuralDesignPattern.bridge.VectorRenderer;

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
        //there can be multiple rooms, of different regions with different set of players in parallel.
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
		
        //STRCUTURAL
		//1. adapter : structural
		//AudioPlayer is already existing class implementing MediaPlayer.
		//Add support of VideoPlayer which has different method signature.
        /*
         * E.g 2: adding support of payment gateway.
         * we might want to have support of PhonePe, GPay, paytm etc.
         * each payment platform have their own api for a transaction related tasks.
         * Eg. : PhonePe have : makePayment(long amount)
         * 		 Gpay have : initiatePayment(long amount) and 
         * 		 Paytm may have : startPayment(long amount).
         * 
         * to create maintainable and simple system there must be one interface to interact with
         * all payment platforms. To achieve this, we create an adapter class for each platform.
         * PhonePeAdapter, GpayAdapter, PaytmAdapter. these classes should implement an interface,
         * that contains methods required for payment related operations in our system.
         * 
         * */
		AudioPlayer adPlayer = new AudioPlayer();
		adPlayer.play("mp3", "usr/local/song1.mp4");
		adPlayer.play("3gp", "usr/local/song2.3gp");
		
		//Made existing audioPlayer to play video as well. 
		AudioPlayer player = new AudioPlayer();
		player.play("mp4", "usr/local/video.mp4");
		
		//2. Bridge 
		/*
		 * It separates the abstraction from its implementation.
		 * abstraction : a high level layer, that defines what something does.
		 * implementation : a low level layer, that defines how it does.
		 * 
		 * In a shape drawing system, which can draw different shapes using vector or raster rendering type.
		 * vector (for high-quality scalable graphics) and raster (for pixel-based graphics).
		 * we might create an interface Shape, that will define what it does. draw(), refresh() etc
		 * and shapes circle, rectangle, etc 'is-a' child of Shape.
		 * so each shape must implement its own logic of shape along with how it draws.
		 * to achieve this, it will require to have separate classes :
		 * CircleVector, CircleRaster, RectangleVector, RectangleRaster.
		 * 
		 * Problem : with increase in number of supported shapes and rendering type, we will need to create
		 * more and more classes, hence increased management. 
		 * 
		 * Solution :
		 * Shape is the abstraction because it defines what shapes do but not how they’re rendered
		 * Renderer is the implementation as it defines how the shapes are drawn (vector, raster, etc.).
		 * 
		 * we must have a separate interface for Rendering, allowing to plug-in new renderer in future.
		 * 
		 * 2. create Implementation : Renderer. (one end of bridge)
		 * 4. create abstraction. : Shape 'has-a' Renderer. (Bridge)
		 * 1. create concrete abstraction : Circle : Shape, Rectangle : Shape etc. (another end of bridge)
		 * 3. create concrete implementations : VectorRenderer : Renderer, RasterRenderer : Renderer.
		 * 
		 * */
		RasterRenderer rasterDisplay = new RasterRenderer();
		VectorRenderer vectorDisplay = new VectorRenderer();
		
		Circle vectorCircle = new Circle(vectorDisplay);
		vectorCircle.draw();
		Circle rasterCircle = new Circle(rasterDisplay);
		rasterCircle.draw();
		
		Rectangle vectorRectangle = new Rectangle(vectorDisplay);
		vectorRectangle.draw();
		Rectangle rasterRectangle = new Rectangle(rasterDisplay);
		rasterRectangle.draw();
	}

}
