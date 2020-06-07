package GunRecommendation;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesBestGun {

	@Test
	public void testGenerateGunData() {
		BestGun.generateGunData("C:\\Users\\swaravi\\eclipse-workspace\\distro\\resources\\SMG.txt");
		Gun firstGun= new Gun("PDW", 90, 40, 25, 50, 75);
		assertEquals(BestGun.guns.get(0).toString(), firstGun.toString());
	}

	@Test
	public void testTranslateToScore() {
		BestGun instance= new BestGun();
		int[] testRank= {1, 0, 0, 0, 2};
		int[] scoreToBe= {5, 0, 0, 0, 4};
		assertArrayEquals(scoreToBe, BestGun.translateToScore(testRank) );
	}

}
