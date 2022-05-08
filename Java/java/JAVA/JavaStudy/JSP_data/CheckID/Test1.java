package CheckID;

import java.io.Console;

public class Test1 {

	public static void main(String[] args) {
		System.out.print("請輸入名稱：");

        Console console = System.console();
        String name = console.readLine();

        System.out.println("您輸入的名稱…" + name);

	}

}
