package base;

import java.util.ArrayList;
import java.util.Arrays;

public class Array {
	public static void main(String[] args) {
		
		String[] strArray = new String[10];
		Arrays.fill(strArray, null); // 清空內容
		
		//可疊加的array <Integer>, <Double>, ...
		ArrayList<String>name = new ArrayList<String>();
		name.add("hachama"); // 新增
		name.add("coco");
		name.add(1,"gura"); // 插入新增 
		name.set(2, "Coco"); // 修改
		name.size(); // -> 3
		name.toArray(); // 轉成陣列 -> {hachama, gura, Coco}
		name.remove(0); // 刪除，後面的會往前遞補
		name.get(0); // 取值 -> gura
		name.clear(); // 清空
	}
}
