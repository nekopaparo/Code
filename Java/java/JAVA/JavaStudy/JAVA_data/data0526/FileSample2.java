package data0526;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileSample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("請輸入檔案路徑:");
		Scanner scn = new Scanner(System.in);
		String fpath = scn.next();
		char buffer[] = new char[100];
		FileReader fin = null;
		try {
			fin = new FileReader(fpath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fin.read(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(buffer);
		scn.close();
	}

}
