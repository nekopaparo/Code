package data0520;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class P75 {

	public static void main(String[] args) {
		
		//錯誤檢查
		try {
			Scanner scn = new Scanner(System.in);
			System.out.print("身高(公尺):");
			BigDecimal height = new BigDecimal(scn.next());
			System.out.print("體重(公斤):");
			BigDecimal weight = new BigDecimal(scn.next());
			scn.close();
			
			System.out.println("BMI = " + BMI(height, weight));
		}
		//try內有相關錯誤會被以下抓到
		catch (NumberFormatException error_1) {
			System.out.println("只能輸入數字");
		}
		catch (ArithmeticException error_2) {
			System.out.println("身高(除數)不可為0");
		}
		//不管try有無錯誤一定會執行
		finally {
			System.out.print("系統結束");
		}
	}

	static BigDecimal BMI(BigDecimal height, BigDecimal weight) {
		
		//公分轉公尺用
		BigDecimal ck = new BigDecimal("100");
		// setScale(3, RoundingMode.FLOOR) -> 第3位後無條件捨去
		if (height.setScale(3, RoundingMode.FLOOR).compareTo(ck) == 1) {
			height = height.divide(ck);
			System.out.println("公分公尺傻傻分不清楚:" + height);
		}
		// num_1.divide( num_2, 1, RoundingMode.HALF_UP ) -> num_1除num_2，算到小數第1位，4捨5入
		return weight.divide(height.multiply(height), 1, RoundingMode.HALF_UP);
	}
}
