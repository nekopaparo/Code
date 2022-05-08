package base;

import java.util.Arrays;

public class CharString {

	public static void main(String[] args) {
		// 清空暫存
		String[] strArray = new String[10];
		Arrays.fill(strArray, null);
		
		String str = "abCDe FghIabc";
		str.charAt(3); //取出字串第3的字元 = D
		str.substring(5, 5); //取出字串<第1(包含)~第5(包含)>之間的字串 = bCDe
		str.toUpperCase(); //轉成大寫
		str.toLowerCase(); //轉成小寫
		str.matches("[a-zA-Z]*"); //字串是否符合要求格式(正規表示法)
		str.split("\\s"); //切割字串 從空白(\s)的地方切
		String[] words = str.split("\\s");
		for(String w:words)
			System.out.println(w);
		
		StringBuffer strbuf = new StringBuffer(str);//轉成StringBuffer型態
		strbuf.reverse();//反轉
		System.out.println(strbuf);
		
		StringBuilder strbui = new StringBuilder(str);//StringBuffer相同方法，較不常用
		strbui.reverse();
		System.out.println(strbui);
		
		String str1 = "asdxzde";
		String str2 = "zcsdags";
		str1.equals(str2); //比較2個字串是否相同(true/false) = false
		
		
		System.out.println( str1.replace("asd", "123") ); //replace取代
		
		
		String strInteger = "123456";
		Integer.parseInt(strInteger); //字串轉成整數
		
		
		
		System.out.println(str.matches(".*abc$"));
		
		//另一種String宣告
		CharSequence str3 = "123";
		System.out.println(str3);
		
		
		
	}

}
/*<正規表示法>
 *. 任一字元
 *[a-zA-Z0-9] 符合英文和數字
 *[^a-zA-Z] 符合英文外
 *a? a出現一次或完全沒有
 *a* a出現零次或多次
 *a+ a出現一次或多次  
 *a{n} 	a出現n次
 *a{n,} a出現至少n次
 *a{n,m} a出現至少n次，但不超過m次
*/
