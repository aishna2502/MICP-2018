package WEEK1;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.Arrays;
import java.util.HashSet;

/*
Microsoft Interview Coaching Pilot 2018 (MICP 2018)
Author: Aishna Gupta
Language: JAVA

************WEEK 4************

WORD BREAK

1. TALK
Given an input string and a dictionary of words, find out if the input string can be segmented into a space-separated sequence of dictionary words.

INPUT FORMAT:
Dictionary of String, String

OUTPUT FORMAT: 
Boolean - True/False

SAMPLE INPUT: Dictionary: { pear, salmon, foot, prints, footprints, leave, you, sun, girl, enjoy }, 
I/P - youenjoy
O/P - TRUE

2. EXAMPLES:
 	2.1 VALID INPUTS
 		
 		a. {"i","am","at","work"}, "iiiii" -> TRUE
 		b. {"he","heart", "cat"}, "heartcat" -> TRUE
 		c. Dictionary -> !emtpy, "" -> TRUE
 		d. 
 		
 	2.2 INVALID INPUTS
		a. Dictionary -> !empty/empty, string -> null --> EXCEPTION
		b. Dictionary -> NULL, string -> any --> EXCEPTION
		
*/


public class WordBreak {

	public static boolean wordBreak(String str, HashSet<String> set) throws Exception{
		
		if(set==null||str==null){
			Exception e = new Exception("INVALID ARGUMENT");
			throw e;
		}
		
		if(set.size()==0){
			return false;
		}
		if(str==""){
			return true;
		}
		int n = str.length();
		boolean[] found = new boolean[n+1];
		
		for(int i=0;i<n;i++){
			if(!found[i] && set.contains(str.substring(0, i+1))){
				found[i] = true;
			}
			if(found[i]){
				if(i==(n-1)){
					return true;
				}
				for(int j=i+1;j<n;j++){
					if(!found[j] && set.contains(str.substring(i+1,j+1))){
						found[j] = true;
					}
					if(j==(n-1) && found[j]){
						return true;
					}
				}
			}
		}
		return false;
	}

	//3. TEST
	
	@Test(enabled = true)
	public void checkValidTrue() throws Exception{
		HashSet<String> set = new HashSet<>(Arrays.asList("he","heart","cat"));
		AssertJUnit.assertEquals(true, wordBreak("heartcat",set));
	}
	
	@Test(enabled = true)
	public void checkValidFalse() throws Exception{
		HashSet<String> set = new HashSet<>(Arrays.asList("i","am","student"));
		AssertJUnit.assertEquals(false, wordBreak("stu",set));
	}

	@Test(enabled = true)
	public void checkEmptySet() throws Exception{
		HashSet<String> set = new HashSet<>(Arrays.asList(""));
		AssertJUnit.assertEquals(false, wordBreak("stu",set));
	}
	
	@Test(enabled = true)
	public void checkEmptyString() throws Exception{
		HashSet<String> set = new HashSet<>(Arrays.asList("i","am","student"));
		AssertJUnit.assertEquals(true, wordBreak("",set));
	}
	
	@Test(expectedExceptions = {Exception.class})
	public void checkNullSet() throws Exception{
		HashSet<String> set = null;
		AssertJUnit.assertEquals(false, wordBreak("stu",set));
	}
	
	@Test(enabled = true)
	public void checkRepeat() throws Exception{
		HashSet<String> set = new HashSet<>(Arrays.asList("i","am","student"));
		AssertJUnit.assertEquals(true, wordBreak("iiamstudentii",set));
	}
	
	@Test(enabled = true)
	public void checkAll() throws Exception{
		HashSet<String> set = new HashSet<>(Arrays.asList("i","am","student"));
		AssertJUnit.assertEquals(true, wordBreak("iamstudent",set));
	}
	
	@Test(expectedExceptions = {Exception.class})
	public void checkNullString() throws Exception{
		HashSet<String> set = null;
		AssertJUnit.assertEquals(false, wordBreak("stu",set));
	}
	
}
