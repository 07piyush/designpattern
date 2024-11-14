package structuralDesignPattern.proxy;

public class ProxyImage implements Image{

	private RealImage realImage;
	private String filePath;
	
	public ProxyImage(String path) {
		filePath = path;
	}
	
	@Override
	public void display() {
		//1. Lazy loading the image, only when display is triggered.
		//2. Single responsibility principle achieved, by abstracting display related details from RealImage.
		//3. can act as gatekeeper, for added control over display api. etc.
		if(realImage == null) {
			realImage = new RealImage(filePath);
		}
		realImage.display();
	}

}
