package creationalDesignPattern.abstractFactory;

public class SnowWeapon implements Weapon{

	@Override
	public void load() {
		System.out.println("Loaded snow machine gun");
	}

	@Override
	public void shoot() {
		System.out.println("Triggered snow machine gun");
		
	}

}
