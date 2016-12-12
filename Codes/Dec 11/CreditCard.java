import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CreditCard{
		//the Pattern referred from stackOverflow;;;
		private static final String MAESTRO = "(5018|5020|5038|5612|5893|6304|6759|6761|6762|6763|0604|6390)\\d{8}|(5018|5020|5038|5612|5893|6304|6759|6761|6762|6763|0604|6390)\\d{9}|(5018|5020|5038|5612|5893|6304|6759|6761|6762|6763|0604|6390)\\d{10}|(5018|5020|5038|5612|5893|6304|6759|6761|6762|6763|0604|6390)\\d{11}|(5018|5020|5038|5612|5893|6304|6759|6761|6762|6763|0604|6390)\\d{12}|(5018|5020|5038|5612|5893|6304|6759|6761|6762|6763|0604|6390)\\d{13}|(5018|5020|5038|5612|5893|6304|6759|6761|6762|6763|0604|6390)\\d{14}|(5018|5020|5038|5612|5893|6304|6759|6761|6762|6763|0604|6390)\\d{15}$";
		private static final String MASTERCARD = "^(?!.*(?:(?:5018|5020|5038\\d{12})))[5][0-5].{14}$";
    	private static final String VISA = "^(?!.*(?:(?:4026|4405|4508|4844|4913|4917)\\d{12}|417500\\d{10}))4\\d{15}$";
		static int cardValidation(String s){
		int len = s.length();
		int i,j,num=0,n=0,esum=0,osum=0;
		for(i=len-2;i>=0;i-=2){
			char c = s.charAt(i);
			num = 0;
			num = c - '0';
			num*=2;
			n = num;
			if(num >=10){
				int rem = 0,temp=0;
				rem = n / 10;
				temp = n % 10;
				esum+=(rem + temp);
			}
			else if(num <10 ){
				esum+=num;
			}
		}
		for(i=len-1;i>=0;i-=2){
			char c = s.charAt(i);
			num = 0;
			num = Character.getNumericValue(c);
			osum+=num;
		}
		int sum = esum+osum;
		if(sum%10 == 0)
			return 1;
		else
			return 0;
	}
	static String cardType(String cardNumber){
            if (isVisa(cardNumber)){
				return "Visa";
			}
            else if (isMasterCard(cardNumber)) {
				return "MasterCard"; 
			}
            else if (isMaestro(cardNumber)) {
				return "Maestro"; 
			}
            else return "";
    }
	static boolean isVisa(String number) {
        Pattern p = Pattern.compile(VISA);
        Matcher m = p.matcher(number);
        return m.matches();
    }
    static boolean isMaestro(String number) {
        Pattern p = Pattern.compile(MAESTRO);
        Matcher m = p.matcher(number);
        return m.matches();
    }	
	static boolean isMasterCard(String number) {
        Pattern p = Pattern.compile(MASTERCARD);
        Matcher m = p.matcher(number);
        return m.matches();
    }
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = cardValidation(s);
		if(n == 1){
			System.out.println("Your Credit card is Valid");
			System.out.println(cardType(s));
		}			
		else if(n == 0)
			System.out.println("Your Credit Card is not Valid");
	}
}
