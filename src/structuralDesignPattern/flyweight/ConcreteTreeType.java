package structuralDesignPattern.flyweight;

public class ConcreteTreeType implements TreeType{
	//concrete flyweight with intrinsic data.
	private String name;
	private String color;
	private String texture;
	
	public ConcreteTreeType(String name, String color, String texture) {
		this.name = name;
		this.color = color;
		this.texture = texture;
	}

	@Override
	public void display(int x, int y) {
		System.out.println("rendering" + name + "tree at (" +x+ ", " + y + ")" + "color:" + color + " texture:" + texture);
	}
}
