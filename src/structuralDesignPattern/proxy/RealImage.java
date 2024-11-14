package structuralDesignPattern.proxy;

public class RealImage implements Image{
	
	private String filePath;
	
	public RealImage(String path) {
		filePath = path;
		loadFromStore();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
	private void loadFromStore() {
		System.out.println("Loading file " +filePath+" from the database.");
	}

}
