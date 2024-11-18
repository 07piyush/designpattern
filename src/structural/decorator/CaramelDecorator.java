package structural.decorator;

public class CaramelDecorator implements Coffee{

	private Coffee coffee;
	
	public CaramelDecorator(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public double getPrice() {
		return coffee.getPrice() + 17.00;
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + " with CARAMEL";
	}
	
	
}
