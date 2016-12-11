import java.util.*;
public class PasswordMeter{
		static int len = 0;
		PasswordMeter(String s){
			len = 0;
			numOfChar(s);
			upperCaseLet(s);
			lowerCaseLet(s);
			numOnly(s);
			letterOnly(s);
			symOnly(s);
			numbers(s);
			Findrepeter(s);	
			consecUpper(s);
			consecLower(s);
			consecNumber(s);
			seqChar(s);
			if(len > 100){
				len = (len*50)/100;
			}
		}
		static void numOfChar(String s){
		int i=0,t=0;
		for(i=0;i<s.length();i++){
			if((s.charAt(i)>='A' && s.charAt(i)<='Z')||(s.charAt(i) >='a' &&s.charAt(i)<='z')){
				t++;
			}
		}
		len += t*4;
		}
		static void upperCaseLet(String s){
			int i=0,t=0;
			for(i=0;i<s.length();i++){
				if(s.charAt(i) >='A' && s.charAt(i)<='Z'){
					t++;
				}
			}
			len += ((s.length()-t)*2);
		}
		static void lowerCaseLet(String s){
			int i=0,t=0;
			for(i=0;i<s.length();i++){
				if(s.charAt(i) >= 'a' && s.charAt(i)<='z'){
					t++;
				}
			}
			len += ((s.length()-t)*2);
		}
		static void numOnly(String s){
			int i=0,t=0;
			for(i=0;i<s.length();i++){
				if(s.charAt(i) >='0' && s.charAt(i)<='9'){
					t++;
				}
			}
			len += t*4;
		}
		static void symOnly(String s){
			int i=0,t=0;
			for(i=0;i<s.length();i++){
				if((!(s.charAt(i) >='0' && s.charAt(i)<='9'))&&(!(s.charAt(i) >='A' && s.charAt(i)<='Z'))
					&&(!(s.charAt(i) >='a' && s.charAt(i)<='z'))){
					t++;
				}  
			}
			len += t*6;
		}
		static void letterOnly(String s){
			int i=0,t=0;
		for(i=0;i<s.length();i++){
			if((s.charAt(i)>='A' && s.charAt(i)<='Z')||(s.charAt(i) >='a' &&s.charAt(i)<='z')){
				t++;
			}
		 }
		  len -= t;
		}
		static void numbers(String s){
			int i=0,t=0;
			for(i=0;i<s.length();i++){
				if(s.charAt(i) >='0' && s.charAt(i)<='9'){
					t++;
				}
			}
			len -= t;
		}
		static void Findrepeter(String s){
			int i,j,t=1;
			boolean flag = false;
			for(i=0;i<s.length();i++){
				for(j=i+1;j<s.length();j++){
					if(s.charAt(i) == s.charAt(j)){
						t++;
						flag = true;
					}
				}
			}
			len -= t;
		}
		static void consecUpper(String s){
		    int i,j,t=1;
			boolean flag = false;	
			for(i=0;i<s.length()-1;i++){
				if(s.charAt(i) >= 'A' && s.charAt(i) <='Z'){
					if(s.charAt(i) == s.charAt(i+1)){
						t++;
						flag = true;
					}		
				}
			}
			if(!flag)
				t=0;
			len -= (t*2);
		}
		static void consecLower(String s){
		    int i,j,t=1;
			boolean flag = false;	
			for(i=0;i<s.length()-1;i++){
				if(s.charAt(i) >= 'a' && s.charAt(i) <='z'){
					if(s.charAt(i) == s.charAt(i+1)){
						t++;
						flag = true;
					}		
				}
			}
			if(!flag)
				t=0;
			len -= (t*2);
		}
		static void consecNumber(String s){
		    int i,j,t=1;
			boolean flag = false;	
			for(i=0;i<s.length()-1;i++){
				if(s.charAt(i) >= '0' && s.charAt(i) <='9'){
					if(s.charAt(i) == s.charAt(i+1)){
						t++;
						flag = true;
					}		
				}
			}
			if(!flag)
				t=0;
			len -= (t*2);
		}
		static void seqChar(String s){
			int i,j,t=0;
			boolean flag = false;	
			for(i=0;i<s.length()-1;i++){
					int c = s.charAt(i) +1 ,d = s.charAt(i+1);
					if(c == d){
						t++;
						flag = true;
					}
			}			
			len -= (t*3);
		}
		public static void main(String args[]){
		Scanner input =new Scanner(System.in);
		String s = input.nextLine();
		PasswordMeter ob = new PasswordMeter(s);
		System.out.println("Strength of your password " + ob.len);
		new PasswordMeter("hi,this is my **** password");
		System.out.println("Strength of your password " + ob.len); // result as 73
		new PasswordMeter("a 1 ! @ ! ) ( ^ * % $ # X| ");
		System.out.println("Strength of your password " + ob.len); // result as 85
	}
}
