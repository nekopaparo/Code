package data0526;

import java.io.File;
import java.util.Scanner;

public class FileSample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String fname, fpath, message;
		System.out.print("輸入檔名:");
		fpath = scn.next();
		File fin = new File(fpath);
		fname = fin.getName();
		long len = fin.length();
		message = "檔案名稱:" + fname;
		System.out.println(message);
		if(fin.isFile())
			System.out.println("這是一個檔案");
		else if(fin.isDirectory())
			System.out.println("這是一個資料夾");
		else
			System.out.println("沒有檔案及目錄");
		
		scn.close();
		System.out.println("檔案長度:" + String.valueOf(len));
	}

}
