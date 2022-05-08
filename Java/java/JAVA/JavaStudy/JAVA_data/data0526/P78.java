package data0526;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class P78 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//寫入
		String filePath = "D:\\HelloJava.txt";
		String writeFile = "Hello Java";
		FileWriter fileWriter = new FileWriter(filePath);
		fileWriter.write(writeFile);
		fileWriter.close();
		
		//讀取
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		System.out.println(bufferedReader.readLine());
		bufferedReader.close();
	}

}
