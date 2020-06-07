package GunRecommendation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BestGun {	
	public static int numberOfRecommendations;
	public static List<Gun> guns= new ArrayList();
	public static void main(String[] args) throws IOException {
		System.out.println("Files=> ShotGun-1 Asault-2 Sniper-3 LMG-4 SMG-5");
		System.out.println("Order of skills required=> Damage, accuracy, range, Fire rate, mobility");
		numberOfRecommendations= 3;
		getRecommendations(125, "1 3 0 0 2", "short Range");
		getRecommendations(234, "1 2 3 4 0", "Long Range");
		getRecommendations(12345, "1 3 5 2 4", "Hybrid gun");
	}

	private static void getRecommendations(int GunsInc, String skillRank, String group) {
		while(GunsInc>0) {
			switch(GunsInc%10) {
			case 1:
				generateGunData("C:\\Users\\swaravi\\eclipse-workspace\\distro\\resources\\ShotGun.txt");
				break;
			case 2:
				generateGunData("C:\\Users\\swaravi\\eclipse-workspace\\distro\\resources\\Asault.txt");
				break;
			case 3:
				generateGunData("C:\\Users\\swaravi\\eclipse-workspace\\distro\\resources\\Sniper.txt");
				break;
			case 4:
				generateGunData("C:\\Users\\swaravi\\eclipse-workspace\\distro\\resources\\LMG.txt");
				break;
			case 5:
				generateGunData("C:\\Users\\swaravi\\eclipse-workspace\\distro\\resources\\SMG.txt");
				break;
			default:
				System.out.println("Unreserved digit encountered while adding section of guns! Please validate");
				break;
			}
			GunsInc/= 10;
		}
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] inpArr= skillRank.split(" ");
		int[] inpRank= new int[inpArr.length];
		for(int i=0; i<inpArr.length; i++)
			inpRank[i]= Integer.parseInt(inpArr[i]);
		int[] inpScore= translateToScore(inpRank);
//		System.out.println("inpScore is "+inpScore[0]+" "+ inpScore[1]+" "+ inpScore[2]+" "+ inpScore[3] +" "+inpScore[4]);
		List<GunPair> recommendation= new ArrayList<GunPair>();
		for(Gun currGun: guns) {
//			System.out.println(currGun.toString());
			int score= inpScore[0]*currGun.getDamage()+ inpScore[1]*currGun.getAccuracy()+ inpScore[2]*currGun.getRange()+ inpScore[3]*currGun.getFireRate()+ inpScore[4]*currGun.getMobility();
			GunPair currPair= new GunPair(currGun.getName(), score); 
//			System.out.println(currPair.toString());
			recommendation.add(currPair);
		}
		Collections.sort(recommendation);
		System.out.println("\nRecommended guns for "+group+" are: ");
		for(int i=0; i<numberOfRecommendations; i++)
			System.out.println(recommendation.get(i).name+": score= "+ recommendation.get(i).score);
		guns.clear();
	}

	public static int[] translateToScore(int[] inpRank) {
		int[] scoreRes= new int[inpRank.length];
		for(int i=0; i<inpRank.length; i++) {
			if(inpRank[i]== 0)
				scoreRes[i]= 0;
			else
				scoreRes[i]= inpRank.length- inpRank[i] +1;
		}
		return scoreRes;
	}

	public static void generateGunData(String filePath){
		File gunsFile= new File(filePath);
		Scanner sc = null;
		try {
			sc = new Scanner(gunsFile);
			while(sc.hasNextLine()) {
				String data= sc.nextLine();
				String[] dataArr= data.split(" ");
				guns.add(new Gun(dataArr[0], Integer.parseInt(dataArr[1]), Integer.parseInt(dataArr[2]), Integer.parseInt(dataArr[3]), Integer.parseInt(dataArr[4]), Integer.parseInt(dataArr[5])) );
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();	
		}
	}
}
