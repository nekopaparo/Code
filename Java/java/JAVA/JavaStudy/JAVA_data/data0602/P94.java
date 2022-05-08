package data0602;

import java.util.TreeSet;

public class P94 {

	public static void main(String[] args) {
		TreeSet<Integer> number = new TreeSet<Integer>();
		for(int i=0; i<10; ) {
			if(number.add((int)(Math.random()*100+1))) {
				i++;
			}
		}
		System.out.println( "data:" + number );
		System.out.println("30-70:" + number.subSet(30+1,70));
	
		System.out.println( number.size() ); //大小
		System.out.println( number.first() );	//第一個
		System.out.println( number.last() );	//最後一個
		System.out.println( number.tailSet(3) );	// >= n的數
		System.out.println( number.headSet(6) );	// < n的數
		System.out.print( number.toArray()[5] ); //變成陣列
	}

}
