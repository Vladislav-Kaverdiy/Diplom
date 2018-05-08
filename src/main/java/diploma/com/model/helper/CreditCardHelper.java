package diploma.com.model.helper;

public class CreditCardHelper {
	public long generateBillForCard(long creditCardNumber) {
	      long tempnumber = creditCardNumber;
	      long reverse = 0;	 
	      while( tempnumber != 0 )
	      {
	          reverse = reverse * 10;
	          reverse = reverse + tempnumber%10;
	          tempnumber = tempnumber/10;
	      }
		return reverse;
	}
}
