package CheckID;

import java.util.*;

public class Basic {

	public static void main(String[] args) {
        int ch;
		int total=0,n=0;
        
        Scanner keyin = new Scanner(System.in);
        //Console keyin = System.console();
        System.out.print("請輸入身分證字號:");
        String id = keyin.nextLine();
        keyin.close();
        //String id = keyin.readLine("請輸入身分證字號:");
        
        //BufferedReader keyin = new BufferedReader(new InputStream(System.in));
        
        
        
        /* 檢查身分證字號長度 */
        if(id.length() != 10)
        {
            System.err.println("長度不正確");
            System.exit(0);
        }
        /* 檢查首字字元 */ 
        id=id.toUpperCase();
        String chkid = "0123456789ABCDEFGHJKLMNPQRSTUVXYWZIO";
        ch = chkid.indexOf( id.charAt(0) );
        if( ch < 10){
        	System.out.println("首字字元不正確");
        	System.exit(0);
        }
        /* 檢查身分證字號性別欄 */ 
        ch = chkid.indexOf( id.charAt(1) );
        if( ch!=1 && ch!=2){
        	System.out.println("性別欄不正確");
        	System.exit(0);
        }
        /* 檢查第3~第10個字元    
         * Character類別方法 isDigit() */
        for(int i=2; i<10; i++) {
        	ch = chkid.indexOf( id.charAt(i) );
        	if(ch < 0 || ch > 9) {
        		System.out.println("第"+i+"個字元不正確");
            	System.exit(0);
        	}
        }

 
        //total=首字字元的加權值 
        n = chkid.indexOf( id.charAt(0) );
        total=n/10+(n%10)*9; 
        
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
