package data0602;

import java.util.ArrayList;

public class P95 {

	public static void main(String[] args) {
		ArrayList<String> trip = new ArrayList<String>();
		String[] place = {"宜蘭","花蓮","天祥","台東"};
		for(String str:place)
			trip.add(str);
		trip.add(3,"花蓮");
		trip.add("知本");
		System.out.println(trip);
		System.out.println(trip.indexOf("知本"));
	}

}
