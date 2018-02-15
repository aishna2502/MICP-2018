package WEEK1;
/*
 Microsoft Interview Coaching Pilot 2018 (MICP 2018)
 Author: Aishna Gupta
 Language: JAVA
 
 ************ WEEK 1 ************

CAESAR CIPHER

1. TALK

 The code you will write is based on the “Caesar Cipher” where each letter is shifted a certain number of places left or right through the alphabet. The alphabet is treated as being circular so that the first letter follows after the last letter, and the last letter precedes the first letter.  These ideas will be applied separately to uppercase letters, lower case letters, and digits.
 
 INPUT FORMAT:
 Your function will take an input string that begins with a number representing the shift. The number will be in the range -1000000000 to 1000000000 (negative 1 billion to 1 billion). The number is followed by a colon (‘:’). The rest of the line consists of a string of 1 to 200 arbitrary characters and represents a fragment of the text to be encrypted.

 OUTPUT FORMAT:
 Output will be the corresponding encrypted text fragment

 SAMPLE INPUT:
 1:some text
 
 SAMPLE OUTPUT:
 tpnf ufyu
*/

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/*
 2. EXAMPLES:
 	2.1 Valid Input:
 	
	 	a. 1:aC4 -> bD5
	 	b. 2:Zy9 -> Ba1
	 	c. -2:Ba0 -> Zy8
	 	d. 1:b# -> c#
	  	e. 27:a0 -> b7
	  	f. 0:ab27 -> ab27
	 
	  2.2 Invalid Input:
	  
	  	a. :abc
	  	b. 2a
	  	c. 3:
	  	d. 1000000001:abc
	  	e. abc:abc
	  	
 3. BRUTE FORCE:
 	 caesarCipher(string):
 	 	
 	 	String str[] = split(":");
 	 	int shift = Integer.parseInt(str[0])
 	  	
 	  	for c in str[1]
 	  		if !digit || !alphabet:
 	  			continue;
 	  		
 	  		else:
 	  			circular shift c by digit
 	  	
 4. OPTIMIZATION
	 caesarCipher(str):
	 	
	 	String str[] = split(":");
 	 	int shift = Integer.parseInt(str[0])
 	 	
	 	for c in str:
	 		if !digit || !alphabet
	 			continue:
	 		else if alphabet:
	 			shift by % 26
	 		else if digit:
	 			shift by % 10	 			 	  	
*/

// IMPLEMENTATION

public class CaesarCipher {

	public static String caesarCipher(String str){
		
		String ans = "";
		
		if(str.equals(null)){
			return null;
		}
		
		String[] dig = str.split(":");
		
		String string;
		int digit;
		
		try{
			string = dig[1];
			digit = Integer.parseInt(dig[0]);
		}
		catch(Exception e){
			return e.getMessage();
		}
		
		for(int i = 0; i < string.length() ; i ++ ){
			if( Character.isAlphabetic(string.charAt(i)) || Character.isDigit(string.charAt(i)) ){
				ans += shiftAlphabetDigit(string.charAt(i), digit);
			}
			else{
				ans += string.charAt(i);
			}
		}
		return ans;
	}
	
	public static char shiftAlphabetDigit(char c, int shift){

		if(c >= 'a' && c <= 'z'){
			
//			SHIFTING FOR SMALL CASE
			
			char temp = (char)(c + shiftBy(shift, 26));
			if(temp < 'a' || temp > 'z'){
				temp = (char)((temp - 'a')%26 + 'a');
			}
			return temp;
		}
		else if(c >= 'A' && c <= 'Z'){
			
//			SHIFTING FOR LARGE CASE

			char temp = (char)(c + shiftBy(shift, 26));
			if(temp < 'A' || temp > 'Z'){
				temp = (char)((temp - 'A')%26 + 'A');
			}

			return temp;
		}
		else if(c >= '0' && c <= '9'){

//			SHIFTING FOR NUMBERS

			char temp = (char)(c + shiftBy(shift, 10));
			if(temp < '0' || temp > '9'){
				temp = (char)((temp - '0')%10 + '0');
			}

			return temp;
		}
	return ' ';
	}
	
	public static int shiftBy(int shift, int by){
		while(shift < 0){
			shift = shift + by;
		}
		return (shift%by);
	}

	
	@Test
	public void test() { //all passed
		assertEquals("bD5", caesarCipher("1:aC4"));
		assertEquals("Ba1", caesarCipher("2:Zy9"));
		assertEquals("Zy8", caesarCipher("-2:Ba0"));
		assertEquals("b7", caesarCipher("27:a0"));
		assertEquals("c#", caesarCipher("1:b#"));
		assertEquals("ab27", caesarCipher("0:ab27"));
		assertEquals("st,r20 de;1", caesarCipher("-89:de,c19 op;0"));
		
		
	}
	
	/*
	 5. TEST CASES
	 */
	
	@Test
	public void testException() throws Exception{ //all passed
		caesarCipher(":");
		caesarCipher(":abc");
		caesarCipher("2a:");
		caesarCipher("3:");
		caesarCipher("1000000001:abc");
		caesarCipher("abc:abc");
		
	}
}
