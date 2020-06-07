package GunRecommendation;

public class Gun {
	private String name;
	private int damage;
	private int fireRate;
	private int accuracy;
	private int range;
	private int mobility;
	public Gun(String name, int damage, int accuracy, int range, int fireRate, int mobility) {
		this.name= name;
		this.damage = damage;
		this.fireRate = fireRate;
		this.accuracy = accuracy;
		this.range = range;
		this.mobility = mobility;
	}
	public int getDamage() {
		return damage;
	}
	public int getFireRate() {
		return fireRate;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public int getRange() {
		return range;
	}
	public int getMobility() {
		return mobility;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Gun [name=" + name + ", damage=" + damage + ", fireRate=" + fireRate + ", accuracy=" + accuracy
				+ ", range=" + range + ", mobility=" + mobility + "]";
	}
	
	
}
