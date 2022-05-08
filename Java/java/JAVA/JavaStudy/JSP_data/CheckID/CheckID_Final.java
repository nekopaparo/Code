//施弘泰 11000143700002
package CheckID;

import java.io.*;
import java.util.Scanner;

public class CheckID_Final
{
	public static void main(String[] args) throws IOException
	{
       	int total=0,c1=0;
       	String chkid = "0123456789ABCDEFGHJKLMNPQRSTUVXYWZIO"; 
       	
       	//Console keyin = System.console();
        //String id = keyin.readLine("請輸入身分證字號: ");
        
       	Scanner scn = new Scanner(System.in);
       	System.out.print("請輸入身分證字號: ");
       	String id = scn.next();
       	scn.close();
	   	id=id.toUpperCase();
	   	
       	//以正則表示式檢查字串             
        if(!id.matches("^[A-Z][12][0-9]{8}"))
	    {
       		System.err.println("身分證字號格式有誤");
         	System.exit(0);
       	}
    
        //首字字元的加權值
        c1 = chkid.indexOf(id.charAt(0));    //首字字元的索引值
        
        total=c1/10+(c1%10)*9; 
      
        //total=total+其他字元的加權值
        for(int i=1; i<9; i++) {
			total += chkid.indexOf( id.charAt(i))*(9-i);
		}
		total += chkid.indexOf( id.charAt(9));	


        if(total % 10 == 0)
            System.out.println("是身分證字號");
        else
            System.out.println("不是身分證字號");
    }
}
