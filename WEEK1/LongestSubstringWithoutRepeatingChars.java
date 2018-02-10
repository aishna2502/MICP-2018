package WEEK1;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

/*
 Microsoft Interview Coaching Pilot 2018 (MICP 2018)
 Author: Aishna Gupta
 Language: JAVA
 
 ************WEEK 1************
 
Longest Substring Without Repeating Characters
1. TALK

 Given a string, find the length of the longest substring without repeating characters.

 INPUT FORMAT: String
 abcabcbb

 OUTPUT FORMAT: Length 
 3
  	
2. EXAMPLE

 2.1 VALID INPUT
 	a. abcabcbb -> 3
 	b. "" -> Invalid String
 	c. djddf@#$093u4 -> 10 
	d. Bbbbb -> 2
	e. pwwkew -> 3
	f. jhhhAahdh -> 4
	
 2.2 INVALID INPUT
 	a. jsld dkjf 
 	

3. BRUTE FORCE
	string longestSubstringWithoutRepeat(str):
		ans = 0
		n = str.length()
		for i=0 to n
			for j = (i+1) to n
				if(Valid(str,i,j))
					ans = max(ans,(j-i+1))

	boolean Valid(str, int start, int end):
		n = str.length()
		create set
		for i = charAt(start) to charAt(end):
			if(map.contains(i)):
				return false
			else:
				map.put(i)

4. OPTIMIZATION

	longestSubstringWithoutRepeat(str):
		create set
		i=0, j=0, maxlen=-1
		while i<n && j<n
		if(set.contains(charAt(j)):
			set.remove(charAt(i++))
		else:
			set.put(charAt(j++))
			maxlen = Max(maxlen, j-i)
	return maxlen
 */
public class LongestSubstringWithoutRepeatingChars {

	public static String longestDistinctSubstring(String str){
		if(str.length()<=0 || (str.contains(" "))){
			return "Invalid String";
		}
		int len = findMaxString(str);
		if(len==-1){
			return "Invalid String";
		}
			return len+"";
		
	}
	
	public static int findMaxString(String str){
		int i=0, j=0, maxlen = -1;
		HashSet<Character> set = new HashSet<>();
		while(i<str.length() && j<str.length()){
			if(set.contains(str.charAt(j))){
				set.remove(str.charAt(i));
				i++;
			}
			else{
				set.add(str.charAt(j));
				maxlen = Math.max(maxlen, (j-i+1));
				j++;
			}
		}
		return maxlen;
	}
	
	//
	
	@Test
	public void test() { //all passed
		assertEquals("5", longestDistinctSubstring("1:aC4"));
		assertEquals("3", longestDistinctSubstring("abcabcbb"));
		assertEquals("Invalid String", longestDistinctSubstring(""));
		assertEquals("3", longestDistinctSubstring("abc"));
		assertEquals("1", longestDistinctSubstring("bbbbbb"));
		assertEquals("4", longestDistinctSubstring("*@&##sss^$"));
		assertEquals("Invalid String", longestDistinctSubstring("pwwkew hhdfh"));
		assertEquals("10", longestDistinctSubstring("djddf@#$093u4"));
	}

}
