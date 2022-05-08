package data0609;

import java.util.Scanner;

public class P98 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("請輸入公司料號:");
		String input = scn.next();
		if(input.matches("\\d[A-Z]-\\d{5}-\\d[A-Z]-[A-Z]\\d{2}"))
			System.out.print("正確");
		else
			System.out.print("錯誤");
		scn.close();
	}

}
