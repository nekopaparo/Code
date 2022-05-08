package data0602;

import java.util.TreeSet;

public class P92 {

	public static void main(String[] args) {
		TreeSet<Integer> binGo = new TreeSet<Integer>();
		
		for(int i=0; i<7; ) {
			if(binGo.add( (int)( Math.random()*49+1) ) ) {
				i++;
			}
		}
		
		System.out.print("中獎號碼:");
		System.out.print( binGo );	//內容
		
	}

}
