package base;

public class Abstract {

	public static void main(String[] args) {
		

	}

}
/*介面與抽象類別。
 *1. 資料成員方法成員的不同。
 *抽象類別(抽象方法+一般的方法)。
 *介面不可以有任何一般方法，方法均為abstract。
 *介面內所宣告方法，在編譯的時候會變成public及abstract型態，
 *因此類別實作介面的方法時候，必須將實作方法宣告為public型態。
 *介面內所定義的變數在編譯的時候會變成public及final型態，介面的變數為常數型態。
 *
 *2. 實作與繼承有無不同。
 *子類別只可以繼承自一個父類別，但是一個類別都可以實作(implements)字很多的介面。
 *
 *3. 階層關係的不同。
 * 不管什麼類別，都可以實作同一類別。
 * 
 *4. 效率的不同。
 *介面屬於執行期間的動態查詢，效率較差。
 * 大量使用介面的話，注意效率。
 */
