package structuralDesignPattern.bridge;

public class VectorRenderer implements Renderer{

	@Override
	public void render(String shape) {
		System.out.println("Implement incoming shape in vector format."); 
		
	}

}
