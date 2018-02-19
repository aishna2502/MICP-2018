package WEEK1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;


/*
Microsoft Interview Coaching Pilot 2018 (MICP 2018)
Author: Aishna Gupta
Language: JAVA

************WEEK 3************

THREE SUM

1. TALK

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

INPUT FORMAT:
Array of length n, target

OUTPUT FORMAT:
Solution set containing triplets

SAMPLE INPUT:
[-1, 0, 1, 2, -1, -4]
 
SAMPLE OUTPUT:

[   [-1, 0, 1],    [-1, -1, 2]   ]

*/

/*
2. EXAMPLES:
	2.1 Valid Input:
	
	 	a. [2, 1, 0, -1] -> [ [-1, 0, 1] ]
	 	b. [0, 0, 0, 0] -> [[0, 0, 0], [0, 0, 0]]
	 	
	2.2 Invalid Input:
	  
	  	a. [] -> null
	  	b. Null ->  null
	  	c. [10] -> null
	  	d. [10, 10, 10] -> null
	  	e. [2, 7, 11, -1] -> null
	  	
3. BRUTE FORCE:
	 threeSum(int[] arr, int target):
	 	result[]
	 	for i=1 to n:
	 		for j=i+1 to n:
	 			for k=j+1 to n:
	 				if(arr[i]+aarr[j]+arr[k]==target):
	 					ans[].add(i,j,k)
	 					result.add(ans)
	 	return result
	 	
4. OPTIMIZATION
	 threeSum(int[] arr, int target):
	 	n = arr.length
	 	sort(arr)
	 	for i=1 to n:
	 		left = i+1
	 		right = n-1
	 		while(left<right):
	 			if(arr[i]+arr[left]+arr[right]==target):
	 				ans[].add(i,left,right)
	 				result.add(ans)
	 			else if(arr[i]+arr[left]+arr[right]<target):
	 				left++
	 			else if(arr[i]+arr[left]+arr[right]>target):
	 				right--
	 	
	 	return result
*/

public class sum3 {

	private static List<List<Integer>> ThreeSum(int[] arr){
		
		boolean found=false;
		Arrays.sort(arr);
		List<List<Integer>> result = new ArrayList<>();
		int n = arr.length;
		
		if(n<3){
			System.out.println("null");
			return null;
		}
		
		for(int i=0;i<n-1;i++){
			int left = i+1;
			int right = n-1;
			while(left<right){
//				System.out.println("*");
				if(arr[i] + arr[left] + arr[right]==0){
					List<Integer> ans = new ArrayList<>();
					ans.add(arr[i]);
					ans.add(arr[left]);
					ans.add(arr[right]);
					found=true;
					result.add(ans);
					break;
				}
				else if(arr[i] + arr[left] + arr[right]<0){
					left++;
				}
				else if(arr[i] + arr[left] + arr[right]>0){
					right--;
				}
			}
		}
		
		if(!found){
//			System.out.println("&&");
			return null;
		}
		
		return result;
	}

	@Test(enabled = true)
	public void test(){
			
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> ans1 = new ArrayList<>();
			List<Integer> ans2 = new ArrayList<>();
			ans2.add(-1);
			ans2.add(-1);
			ans2.add(2);
			ans1.add(-1);
			ans1.add(0);
			ans1.add(1);
			result.add(ans2);
			result.add(ans1);
			assertEquals(result, ThreeSum(new int[]{-1, 0, 1, 2, -1, -4}));	
	}
	
	@Test(enabled = true)
	public void testMultipleAnswer(){
			
			List<List<Integer>> result = new ArrayList<>();
			List<Integer> ans1 = new ArrayList<>();
			List<Integer> ans2 = new ArrayList<>();
			List<Integer> ans3 = new ArrayList<>();
			List<Integer> ans4 = new ArrayList<>();
			
			ans1.add(0);
			ans1.add(0);
			ans1.add(0);
			
			ans2.add(0);
			ans2.add(0);
			ans2.add(0);

			result.add(ans1);
			result.add(ans2);
			
			assertEquals(result, ThreeSum(new int[]{0,0,0,0}));	
	}
	
	@Test(enabled=true)
    public static void testNull()
    {
		int arr[] = new int[]{};
        assertEquals(null,ThreeSum(arr));
    }
    
	@Test(enabled=true)
    public static void testNoAnswer()
    {
		int arr[] = new int[]{-1,1,2,-2};
        assertEquals(null,ThreeSum(arr));
    }
	
}
