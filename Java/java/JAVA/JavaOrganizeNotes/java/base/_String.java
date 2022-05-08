package base;

public class _String {

	public static void main(String[] args) {

		String str = "01234567 abcdefg";
		str.charAt(3); // 取出字串第3的字元 = 3
		str.substring(1, 5); // 取出字串<第1(包含)~第5(不包含)>之間的字串 = 1234
		str.replace("0123", "hacha"); // 取代 -> hacha4567 abcdefg
		str.toUpperCase(); // 轉成大寫
		str.toLowerCase(); // 轉成小寫
		str.split("\s"); // 切割字串，從空白(\s)的地方切 -> {"01234567", "abcdefg"}
		str.matches("[0-9a-z\s]*"); // 正規表示法 (字串是否符合要求格式) -> true
		/*
		 * <正規表示法> . 任一字元 [a-zA-Z0-9] 符合英文和數字 [^a-zA-Z] 符合英文外 a? a出現一次或完全沒有 a* a出現零次或多次
		 * a+ a出現一次或多次 a{n} a出現n次 a{n,} a出現至少n次 a{n,m} a出現至少n次，但不超過m次
		 */
		String num = "3";
		// 字串轉數字，有非數字會NumberFormatException
		Integer.parseInt(num); // 整數，非整數會NumberFormatException
		Double.parseDouble(num);

		String str1 = "abcd";
		String str2 = "1234";
		str1.equals(str2); // 比較字串str2是否和str1相同(true/false) = false

		String[] str3 = { "01234567", "abcdefg", "hacha4567" };
		String.join("@@@", str3); // 用@@@作為分號 -> 01234567@@@abcdefg@@@hacha4567gfedcba

		// 轉成StringBuffer型態
		StringBuffer strbuf = new StringBuffer(str);
		strbuf.reverse();// 反轉字串
		System.out.println(strbuf);

		/*
		 * 和StringBuffer相同類別，較不常用 StringBuilder strbui = new StringBuilder(str);
		 * strbui.reverse(); System.out.println(strbui);
		 */

		// 另一種String宣告方法
		CharSequence csq = "123abc";
		System.out.println(csq);

	}
}
