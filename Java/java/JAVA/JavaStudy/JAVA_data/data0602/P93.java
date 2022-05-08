package data0602;

import java.util.Scanner;
import java.util.TreeSet;

public class P93 {

	public static void main(String[] args) {
		TreeSet<Integer> dataSelect = new TreeSet<Integer>();
		Scanner scn = new Scanner(System.in);
		int n;
		for(int i=0; i<6; i++) {
			if( !scn.hasNextInt() ) {
				scn.next();
				continue;
			}
			n = scn.nextInt();
			if(n>=1 && n<=49) dataSelect.add(n);
		}
		scn.close();
		System.out.print( dataSelect );
	}
	
}
