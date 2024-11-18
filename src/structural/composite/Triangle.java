package structural.composite;

public class Triangle implements Shape{
	
	@Override
	public void draw() {
		System.out.println("Drawing a RECTANGLE");
	}

	@Override
	public void move(int x, int y) {
		 System.out.println("Moving the RECTANGLE to coordinates (" + x + ", " + y + ")");
	}

	@Override
	public void resize(int scale) {
		System.out.println("Resizing the RECTANGLE by scale: " + scale);		
	}
}
