package data0609;

import java.util.Scanner;

public class P99 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("身分證字號:");
		String member = scn.next();
		if(member.toUpperCase().matches("[A-Z](1|2)\\d{8}"))
			System.out.print("格式正確");
		else
			System.out.print("格式錯誤");
		scn.close();
	}
}
