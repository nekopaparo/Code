package data0519;

import java.time.LocalDate;
import java.time.chrono.MinguoDate;
import java.time.temporal.ChronoUnit;


public class P73 {

	public static void main(String[] args) {
		try {
			double number1 = Double.parseDouble("null");
		}catch(NumberFormatException e) {
			System.out.println("eer");
		}
		
		
		final LocalDate myBirthDay = LocalDate.of(1998, 2, 21);
		MinguoDate myMinguoBirthDay = MinguoDate.of(myBirthDay.getYear()-1911, myBirthDay.getMonthValue(), myBirthDay.getDayOfMonth());
		
		//用年計算
		ChronoUnit chronoUnit = ChronoUnit.YEARS;
		long age = chronoUnit.between(myMinguoBirthDay,  MinguoDate.now());
			
		System.out.println(myMinguoBirthDay);
		System.out.print(age);
		
		

	}

}
