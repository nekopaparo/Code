/* Java Beans 簡稱 Beans

   1.Beans 是 class 檔
   2.屬性的存取權限必須設成"private"
   3.提供"public"成員方法來存取屬性值
   4.成員方法命名方式:get/set屬性名稱()
   5.必須指定套件路徑
   6.Implement java.io.Serializable
   
*/
package data0705;

import java.io.*;

public class AmountBean implements Serializable {
	
	private int price, quantity, total;
	
	public void setPrice( int price ){
		this.price=price;   //屬性 = 參數
	}
	public int getPrice(){
		return this.price;
	}
	
	public void setQuantity( int quantity ){
		this.quantity = quantity;
	}
	public int getQuantity(){
		return this.quantity;
	}
	
	public int getTotal(){
		this.total = this.getPrice()*this.getQuantity();
		return this.total;
	}
 
}
