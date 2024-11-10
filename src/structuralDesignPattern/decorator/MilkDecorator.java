package structuralDesignPattern.decorator;

public class MilkDecorator implements Coffee{

	private Coffee coffee;
	
	public MilkDecorator(Coffee coffee) {
		this.coffee = coffee;
	}
	
	@Override
	public double getPrice() {
		return coffee.getPrice() + 15.0;
	}

	@Override
	public String getDescription() {
		return coffee.getDescription() + "with MILK";
	}

	
}
