package structural.bridge;

public class Rectangle extends Shape{

	public Rectangle(Renderer renderer) {
		super(renderer);
	}

	@Override
	public void draw() {
		renderer.render("Rectangle");
	}

}
