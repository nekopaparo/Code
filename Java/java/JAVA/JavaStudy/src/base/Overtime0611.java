package base;

public class Overtime0611 {
	static double wage = 100;
	static double tatalPay = 0;
	static double tatalOvertimePay = 0;
	static double count1_13 = 1.34;
	static double count1_23 = 1.67;
	public static void main(String[] args) {
		/*作業:
		 *A先生的月薪$24000(時薪$100元),
		 *本周7天, 周一是國定假日,周一週六週日都去加班(做滿12小時),
		 *A先生本週領多少加班費?
		 *https://laws010.com/blog/labor-dispute/work-overtime/work-overtime-02*/
		int hour = 12;
		
		
		day(hour);
		day(hour);
		System.out.println( day(hour) );
		
		System.out.println( offDay(hour) );
		System.out.println( nationalHoliday(hour) );
		
		System.out.println( holiDay( hour) );
		
		System.out.println( count1_13 );
		System.out.print( tatalOvertimePay );
		
	}
	//平日
	static double day( int hour ){
		double pay = 0;
		double overtimePay = 0;
		if( hour > 8 ) {
			pay += 8 * wage;
			if( hour > 10 ) {
				overtimePay += 2 *  count1_13 * wage ;
				overtimePay += (hour - 10) * count1_23 * wage ;
			}
			else
				overtimePay += (hour - 8) * count1_13 * wage;
		}
		else
			pay += hour * wage;
		
		tatalPay += pay;
		tatalOvertimePay += overtimePay;
		return overtimePay;
	}
	//休息日
	static double offDay(int hour) {
		double overtimePay = 0;
			if( hour > 2 ) {
				overtimePay += 2 * count1_13 * wage ;
				if( hour > 8 ) {
					overtimePay += 6 *  count1_23 * wage;
					overtimePay += ( hour - 8 ) * 2 * wage ;
				}
				else
					overtimePay += ( hour - 2 ) * count1_23 * wage ;
			}
			else
				overtimePay += hour *  count1_13 * wage ;
			tatalOvertimePay += overtimePay;
			return overtimePay;
		}
	//例假日
	static double holiDay(int hour){
		double overtimePay = 8 * wage;
		if( hour > 8 ) 
			overtimePay += (hour - 8) *  2 * wage ;
		tatalOvertimePay += overtimePay;
		return overtimePay;
	}
	//國定假日
	static double nationalHoliday(int hour){
		double overtimePay = 8 * wage ;
		if( hour > 8 ) {
			overtimePay += ( hour - 8 ) * wage;
			if( hour > 10 ) {
				overtimePay += 2 * count1_23 * wage ;
				overtimePay += (hour - 10) * count1_13 * wage;
			}
			else
				overtimePay += (hour - 8) * count1_13 * wage;
			
			tatalOvertimePay += overtimePay;
		}
		return overtimePay;
	}
}
