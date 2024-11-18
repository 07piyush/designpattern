package practiceDesignPattern;

import java.sql.Connection;
import java.sql.SQLException;

import behavioral.CreditCardPayment;
import behavioral.CryptoPayment;
import behavioral.PaymentProcessor;
import behavioral.PaymentStrategy;

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
import structuralDesignPattern.composite.CompositeShapes;
import structuralDesignPattern.composite.Square;
import structuralDesignPattern.composite.Triangle;
import structuralDesignPattern.decorator.CaramelDecorator;
import structuralDesignPattern.decorator.Coffee;
import structuralDesignPattern.decorator.MilkDecorator;
import structuralDesignPattern.decorator.SimpleCoffee;
import structuralDesignPattern.facade.AuthenticationService;
import structuralDesignPattern.facade.MarketService;
import structuralDesignPattern.facade.NotificationService;
import structuralDesignPattern.facade.OrderService;
import structuralDesignPattern.facade.PurchaseCryptoFacade;
import structuralDesignPattern.facade.WalletService;
import structuralDesignPattern.flyweight.Tree;
import structuralDesignPattern.flyweight.TreeFactory;
import structuralDesignPattern.flyweight.TreeType;
import structuralDesignPattern.proxy.Image;
import structuralDesignPattern.proxy.ProxyImage;

public class Start {

	public static void main(String[] args) {
		
		//1. factory: Creational 
		/*
		 *
		 * Centralized object creation, hence ease of management and debugging.
		 * 
		 * 1. create abstract product : high level behavior of end product.
		 * 2. create concrete products : classes that are implementation of high level product.
		 * 3. create Factory. : class that will return a concrete product. it can be abstract or static.
		 * 
		 * Pros : 
		 * 	Abstraction | Client do not need to worry about how end product is created.
		 * 		S : factory only responsible to create objects.
		 * 		O : new products/classes of product can be easily added without modifying existing code.
		 * 		D : dependency inversion, client does not depend on specifics of Car/Bus/Truck. 	
		 * 			
		 * */
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
         * Reduce object creation time, by avoiding any complex initialization logic execution for each obj.
         * Simplify customization. make creation of base object as abstract and allow client to customize.
         * 
         * 1. create abstract product which is cloneable, and override clone method.
         * 2. create concrete classes. (no specific detail required for cloning)
         * 3. client usage.
         * 
         * 
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
		
		//3. Composite
		/*
		 * It deals with hierarchy. when when individual objects, and group of objects should be treated
		 * uniformly.
		 * 
		 * E.g : Entity : grouping shapes : circles, rectangles, lines. and applying same common change to 
		 * that group.
		 * if not used composite design, applying an operation will be required to be done on individual 
		 * shape manually. Eg. circle1.move(3,4) circle2.move(3,4), rectangle1.move(3,4), rectangle2.move(3,4)
		 * etc.
		 * 
		 * Real world : in a graphic design application, we have entities like circle, rectangle.
		 * at initial level, we might want to have a shape class, and circle, rectangle implement it.
		 * now directly exposing shape to clients will not help the client to create groups of shapes, and
		 * apply some common operations on those shapes efficiently.
		 * 
		 * instead, we can create a composite design, and client will use that composition to apply
		 * required operations on groups he created. 
		 * 
		 * */
		Square square = new Square();
		Triangle triangle = new Triangle();
		
		CompositeShapes groupOne = new CompositeShapes();
		groupOne.addShape(square);
		groupOne.addShape(triangle);
		
		groupOne.move(0, 0);
		groupOne.move(14, 90);
		
		CompositeShapes groupTwo = new CompositeShapes();
		groupTwo.addShape(square);
		groupTwo.addShape(triangle);
		
		groupTwo.move(3, 3);
		groupTwo.move(20, 100);
		
		CompositeShapes nestedGroup = new CompositeShapes();
		nestedGroup.addShape(groupOne);
		nestedGroup.addShape(groupTwo);
		
		nestedGroup.move(40, 40);
		
		//4. Decorator
		/*
		 * Idea is quite simple. when ever an object can have a usecase of upgrade/downgrade of 
		 * at runtime, then rather than having individual classes of each possible upgraded and
		 * downgraded versions of that object, we build up or build it down (decorate/un-decorate)
		 * the object.
		 * 
		 * E.g : Coffee ordering system.
		 * there can be basic coffee, and there may be add-ons available.
		 * to create a coffee order, user will choose a coffee(baisc) and add some add-ons(decorations) like 
		 * whip, choco-chip, sprinkler, sugar etc.
		 * 
		 * without decorator design classes are: BasicCoffee, CoffeeWithSugar, CoffeeWithWhipedCream,
		 * CoffeeWithChocoChip etc. which is very in flexible, difficult to change/add addons.
		 * 
		 * Decorator : create an interface Coffee (behavior:getPrice, getDescription),
		 * now each individual decorators will 'have-a' Coffee relationship with Coffee.
		 * that means, a composition.
		 * 
		 * */
		Coffee coffee = new SimpleCoffee();
		coffee = new MilkDecorator(coffee);
		coffee = new CaramelDecorator(coffee);
		
		System.out.println("Coffee : " + coffee.getDescription()+ "| Price : " + coffee.getPrice());
		
		//5. Facade (meaning : the front wall of a large building that you see from the outside)
		/*
		 * Provides a simplified interface to a complex subsystem.
		 * 
		 * E.g : for a crypto buying platform, from client we wish to buy a crypto, but that will require
		 * to use other prerequisite APIs like check current rate, check available balance, etc.
		 * 
		 * Facade will make other related work to be done by facade class, and not expose it to client directly
		 * making the usage simple readable.
		 *
		 * */
		
		AuthenticationService authService = new AuthenticationService();
        WalletService walletService = new WalletService();
        MarketService marketService = new MarketService();
        OrderService orderService = new OrderService();
        NotificationService notificationService = new NotificationService();

        // Facade
        PurchaseCryptoFacade cryptoBuyFacade = new PurchaseCryptoFacade(authService, walletService, marketService, orderService, notificationService);

        // Buying crypto
        cryptoBuyFacade.purchaseCrypto("user123", "password", "Bitcoin", 0.1);
        
        //6. Flyweight (meaning : light weight)
        /*
         * The aim is to minimize memory usage as much as possible, by sharing data among the objects
         * which is common to them. 
         * E.g : in pubg game, there are thousands of tree, but only limited unique type of trees.
         * so instead of creating new object to render it, we must reuse some info.
         * 
         * there are two types of information in an object : 
         * 1. intrinsic : common/constant to all (core values) 
         * 2. extrinsic : unique to an instance.
         * 
         * NOTE : apply this only when we are sure that certain information is duplicating in each 
         * object. The design is merely for optimization must be used carefully.
         * 
         * Design :
         * Idea is to stop storing the states that rarely changes in actual object, and move that info
         * to separate object and share that object among others.
         * 
         * here, in pubg letsay there are total 1000 trees in cache to be rendered along with other objects.
         * 1000 tree object each tree can be only of a limited type. so let each Tree hold reference to its 
         * type. and a factory should create a pool of flyweight objects of required types.
         * 
         * 1. flyweight : defines the shared interface and intrinsic info.
         * 2. concreteFlyweight : implements the flyweight, holding intrinsic data.
         * 3. flyweightFactory : manages fly. objects, and ensures sharing of objects by reusing.
         * 4. client : user.
         * 
         * 
         * */
        TreeType oakType = TreeFactory.getTreeType("Oak", "Green", "Rough");
        TreeType pineType = TreeFactory.getTreeType("Pine", "Green", "Smooth");

        Tree oakTree1 = new Tree(5, 10, oakType);
        Tree oakTree2 = new Tree(15, 20, oakType);
        Tree pineTree = new Tree(10, 15, pineType);

        oakTree1.display();
        oakTree2.display();
        pineTree.display();
        
        //7. Proxy.
        /*
         * Proxy provides an intermediary between end user and the underlying object.
         * Proxy can do multiple tasks. 1. access control 2. caching 3. lazy loading etc.
         * Based on usecase there are various types of proxy :
         * 
         * Virtual Proxy : Manages creation and access to expensive objects. E.g (thumbnail vs actual image)
         * Protection Proxy : Controls access based on permission.
         * Remote Proxy : Allows local client to use Remote servers as if they are locally available.
         * Cache Proxy : Allows caching results of operations that are expensive, to reduce API calls.
         *   
         * */
        
        Image image = new ProxyImage("/local/images/HighResImage1.jpeg");
        //loads the image from db.
        image.display();
        System.out.println("displaying image..");
        //only display the image, as its has been loaded already.
        image.display();
        System.out.println("displaying image...");
        
        //Behavioral Design Pattern
        /*
         * These patterns focus on how objects interact with each other. To make interaction more flexible 
         * and dynamic by defining clear responsibilities and reducing tight coupling.
         * 
         *  - separate the object and its possible behaviors to choose a behavior dynamically.
         *  - simplify interactions by introducing intermediaries or reusable behavior patterns.
         *  - allows to change how objects behave without modifying the source code of object.
         * 
         * */
        
        //1. Strategy Pattern
        /*
         * Strategy pattern suggests that you take a class that does something in a lot of different ways.
         * and extract all of these algorithms into separate classes called Strategies.
         * 
         * The original class called 'context' should have a reference to a strategy. the 'context' delegates
         * the work to a linked strategy instead of executing on its own.
         * 
         * 'Context' is not responsible to selecting a strategy instead client should select what strategy
         * must be used.
         * 
         * Key components : 
         * 1. Strategy interface : a high level operation that can be done in different ways.
         * 2. Concrete strategy : implementations of different ways.
         * 3. context class : holds reference to one of the strategy, and communicates via strategy interface.
         * 
         * E.g : For a online shopping platform, we need to support multiple types of payment methods.
         * when creating first supported payment method, say credit card, rather than directly using an object
         * that takes amount and process the payment, we will use strategy pattern.
         * 
         * client should decide the payment strategy. 
         * 
         * */
        PaymentProcessor processor = new PaymentProcessor();
        processor.setPaymentStrategy(new CreditCardPayment());
        processor.processPayment(666);
        
        processor.setPaymentStrategy(new CryptoPayment());
        processor.processPayment(12);
        
	}
}
