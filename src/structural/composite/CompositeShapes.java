package structural.composite;

import java.util.LinkedList;
import java.util.List;

public class CompositeShapes implements Shape{
	
	private List<Shape> groupOfShapes = new LinkedList<>();
	
	public void addShape(Shape shape) {
		groupOfShapes.add(shape);
	}
	
	public void removeShape(Shape shape) {
		groupOfShapes.remove(shape);
	}
	
	@Override
	public void draw() {
		for(Shape shape : groupOfShapes) {
			shape.draw();
		}
	}
	
	@Override
	public void move(int x, int y) {
		for(Shape shape : groupOfShapes) {
			shape.move(x, y);
		}
	}

	@Override
	public void resize(int scale) {
		for(Shape shape : groupOfShapes) {
			shape.resize(scale);
		}
	}
}
