package structuralDesignPattern.composite;

public class Square implements Shape{

	@Override
	public void draw() {
		System.out.println("Drawing a SQUARE");
	}

	@Override
	public void move(int x, int y) {
		 System.out.println("Moving the SQUARE to coordinates (" + x + ", " + y + ")");
	}

	@Override
	public void resize(int scale) {
		System.out.println("Resizing the SQUARE by scale: " + scale);		
	}

}
