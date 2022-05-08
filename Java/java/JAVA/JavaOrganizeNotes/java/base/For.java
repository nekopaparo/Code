package base;
//迴圈for
public class For {
	public static void main(String[] args) {
		//基本for
		int count = 3;
		for (int i = 0; i < count; i++) {
			System.out.print(i + "\s");
		}
		System.out.println();
		//基本foreach
		char[] array = { 'a', 'b', 'c' };
		for (char i : array) {
			System.out.print(i + "\s");
		}
		System.out.println();
		
		ForFor.main(args);
	}
}
//巢狀迴圈for
class ForFor {
	public static void main(String[] args) {
		//巢狀for
		int count = 3;
		int forRunCount = 0;
		for (int i = 0; i < count; i++) {
			for (int ii = 0; ii < count; ii++) {
				forRunCount++;
			}
		}
		System.out.println("RunCount -> " + forRunCount);
		//巢狀foreach
		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int[] i : array) {
			for (int ii : i)
				System.out.print(ii + "\s");
		}
	}
}