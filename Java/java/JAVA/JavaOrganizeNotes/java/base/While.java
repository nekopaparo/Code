package base;

public class While {

	public static void main(String[] args) {
		int count = 0;
		// 基本while,條件達成才做{}
		while (count < 3) {
			count++;
			System.out.print(count + "\s");
		}
		System.out.println();
		// do...while，先做do{}在判斷while(條件)
		do {
			count--;
			System.out.print(count + "\s");
		} while (count > 0);
	}
}
