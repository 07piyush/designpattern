package creational.abstractFactory;

public class DesertFactory implements RegionFactory{

	@Override
	public Weapon createWeapon() {
		return new DesertWeapon();
	}

	@Override
	public Vehicle createVehicle() {
		return new DesertVehicle();
		
	}

}
