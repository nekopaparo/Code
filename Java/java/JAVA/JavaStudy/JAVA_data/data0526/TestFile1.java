package data0526;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestFile1 {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		String data, username/*, pwd*/;
		Scanner scn = new Scanner(System.in);
		System.out.print("username:");
		username = scn.next();
		String fpath = "E:\\程式\\JavaEE\\eclipse-workspace\\username.txt";
		FileReader f = new FileReader(fpath);
		BufferedReader bf = new BufferedReader(f);
		do {
			data = bf.readLine();
			if(data.equals(username)) {
				System.out.print("Bingo");
				break;
			}
		}while(true);
		bf.close();
		scn.close();
		
	}
}
