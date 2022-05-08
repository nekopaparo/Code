package base;

import java.util.TreeSet;

// 會自動排除重複值
public class _TreeSet {
	public static void main(String[] args) {

		TreeSet<Integer> ts = new TreeSet<Integer>();

		for (int i = 0; i < 10; i++) {
			// binGo.add重複內容會回傳false
			if (!ts.add((int) (Math.random() * 10 + 1))) {
				System.out.print(".");
			}
		}
		System.out.println();
		System.out.println(ts.size()); // 大小
		System.out.println(ts); // 內容
		System.out.println(ts.first()); // 第一個
		System.out.println(ts.last()); // 最後一個
		System.out.println(ts.subSet(3, 6));// 3<= n < 6 的數
		System.out.println(ts.tailSet(3)); // >= n的數
		System.out.println(ts.headSet(6)); // < n的數
		ts.toArray(); // 轉換成陣列
	}
}
