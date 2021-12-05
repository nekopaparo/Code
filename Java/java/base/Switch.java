package base;

public class Switch {

	public static void main(_String[] args) {

		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("四則運算 2口2, 口=");
		char scnChar = scanner.next().charAt(0);
		scanner.close();
		// 基本switch
		switch (scnChar) {
		case '+': {
			System.out.printf("2 %c 2 = %d", scnChar, 2 + 2);
			break;
		}
		case '-': {
			System.out.printf("2 %c 2 = %d", scnChar, 2 - 2);
			break;
		}
		case '*': {
			System.out.printf("2 %c 2 = %d", scnChar, 2 * 2);
			break;
		}
		case '/': {
			System.out.printf("2 %c 2 = %d", scnChar, 2 / 2);
			break;
		}
		default: {
			System.out.print("error");
			break;
		}
		}
		System.out.println();
		// jdk13以上支援的簡化寫法
		switch (scnChar) {
		case '+' -> System.out.printf("2 %c 2 = %d", scnChar, 2 + 2);
		case '-' -> System.out.printf("2 %c 2 = %d", scnChar, 2 - 2);
		case '*' -> System.out.printf("2 %c 2 = %d", scnChar, 2 * 2);
		case '/' -> System.out.printf("2 %c 2 = %d", scnChar, 2 / 2);
		default -> System.out.print("error");
		}
	}

}
