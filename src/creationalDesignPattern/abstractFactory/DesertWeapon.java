package creationalDesignPattern.abstractFactory;

public class DesertWeapon implements Weapon{

	@Override
	public void load() {
		System.out.println("loaded dessert snipper.");
	}

	@Override
	public void shoot() {
		System.out.println("Triggered snipper.");
	}

}
