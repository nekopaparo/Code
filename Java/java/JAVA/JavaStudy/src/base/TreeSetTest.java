package base;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet<Integer> binGo = new TreeSet<Integer>();
		
		for(int i=0; i<10; ) {
			//binGo.add重複內容會回傳false
			if(binGo.add( (int)( Math.random()*10+1) ) ) {
				i++;
			}
		}
		
		System.out.println( binGo.size() ); //大小
		System.out.println( binGo );	//內容
		System.out.println( binGo.first() );	//第一個
		System.out.println( binGo.last() );	//最後一個
		System.out.println( binGo.subSet(3, 6) );// 3<= n < 6 的數
		System.out.println( binGo.tailSet(3) );	// >= n的數
		System.out.println( binGo.headSet(6) );	// < n的數
		System.out.print( binGo.toArray()[5] ); //變成陣列
		
	}
}
