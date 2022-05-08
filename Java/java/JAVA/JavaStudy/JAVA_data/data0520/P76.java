package data0520;

import java.util.Scanner;

public class P76 {

	public static void main(String[] args) {
		
		try {
			Scanner scn = new Scanner(System.in);
			System.out.print("姓名: ");
			String name = scn.next();
			System.out.print("薪資: ");
			int salary = scn.nextInt();
			scn.close();
			//薪資範圍20000至40000之間時儲存資料
			if(salary >=20000 && salary <= 40000)
				new Jab().showSalary(name, salary);
			//不在範圍拋出IllegalArgumentException例外
			else
				throw new IllegalArgumentException();
		}
		//接收到IllegalArgumentException例外時顯示"薪資引數錯誤"
		catch(IllegalArgumentException e) {
			System.out.println("薪資引數錯誤");
		}
	}
	
}
class Jab{
	private String name;
	private int salary;
	void showSalary(String name, int salary){
		name = this.name;
		salary = this.salary;
	}
}
