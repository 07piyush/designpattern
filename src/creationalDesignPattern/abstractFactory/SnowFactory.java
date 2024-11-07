package creationalDesignPattern.abstractFactory;

public class SnowFactory implements RegionFactory{

	@Override
	public Weapon createWeapon() {
		return new SnowWeapon();
	}

	@Override
	public Vehicle createVehicle() {
		return new SnowVehicle();
	}

}
