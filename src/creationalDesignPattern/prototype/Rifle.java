package creationalDesignPattern.prototype;

public class Rifle extends Weapon{

	public Rifle(){
		type = "SNIPER_RIFLE";
		damage = 60;
	}
	
	@Override
	public void attachScope(String strength) {
		System.out.println("Attacehed scope to rifle : " + strength);
		
	}

}
