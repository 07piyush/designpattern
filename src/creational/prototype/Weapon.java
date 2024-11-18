package creational.prototype;

public abstract class Weapon implements Cloneable{

	protected String type;
	protected int damage;
	
	public Weapon clone() throws CloneNotSupportedException{
		return (Weapon) super.clone();
	}
	
	public abstract void attachScope(String strength);
}
