package data0520;

public class P77 {

	public static void main(String[] args) {
		try {
			// 資料指定為String
			Object[] error_1 = new String[1];
//			Object[] error_1 = new Integer[1];
			// 輸入Integer資料
			error_1[0] = 123456;
			System.out.println(error_1[0]);
		}
		catch (ArrayStoreException error_1) {
			System.out.println(error_1 + ":陣列型別與指定給陣列的資料型別不相容");
		}
		try {
			// 指定class為Float class
			Object test = new Float[1];
			// class無法從Float轉成Integer
			Integer[] error_2 = (Integer[]) test;
			System.out.println(error_2);
		} 
		catch (ClassCastException error_2) {
			System.out.println(error_2 + ":無效的轉換");
		}
		try {
			// 建立一個array大小為-1
			Object error_3 = new int[-1];
			System.out.println(error_3);
		} 
		catch (NegativeArraySizeException error_3) {
			System.out.println(error_3 + ":建立陣列的大小是負數");
		}
	}
}
