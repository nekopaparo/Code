package data0526;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		String filePath = "D:\\HelloJava.txt";
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		System.out.println(bufferedReader.readLine());
		bufferedReader.close();
	}
	

}
