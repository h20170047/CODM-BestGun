package GunRecommendation;

public class GunPair implements Comparable{
	String name;
	int score;
	public GunPair(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	@Override
	public int compareTo(Object o) {
		return ( (GunPair)o).score- this.score;
	}
	@Override
	public String toString() {
		return "GunPair [name=" + name + ", score=" + score + "]";
	}

}