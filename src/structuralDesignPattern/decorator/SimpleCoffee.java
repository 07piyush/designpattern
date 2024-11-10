package structuralDesignPattern.decorator;

public class SimpleCoffee implements Coffee{
	
	@Override
	public double getPrice() {
		return 50.00;
	}

	@Override
	public String getDescription() {
		String desc = "simple coffee";
		return desc;
	}

}
