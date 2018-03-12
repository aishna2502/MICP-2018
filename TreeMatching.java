package Week6;
import static org.testng.Assert.assertEquals;
import org.junit.Test;

/*
Microsoft Interview Coaching Pilot 2018 (MICP 2018)
Author: Aishna Gupta
Language: JAVA

************WEEK 6************

THREE SUM

1. TALK

Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. 

INPUT FORMAT:
Root node of two trees

OUTPUT FORMAT:
Boolean

SAMPLE INPUT: Root1 = 1, Root2 = 3 
		 1
		/ \
 	   2   3	, 	 3
	  / \ / \		/ \
	 4  5 6  7	   4   5
SAMPLE OUTPUT:

True

*/

/*

SOLUTION
	 
	 MatchTree(Node root1, Node root2):
	 	if(root1==null && root2==null):
	 		return true;
	 	
	 	if(root1==null || root2==null)
	 		return false;
	 	
	 	if(root1.data==root2.data && MatchTree(root1.left,root2.left) && MatchTree(root1.right,root2.right)):
	 		return true;
	 	
	 	return MatchTree(root1.left,root2) || MatchTree(root1.right,root2);
*/


public class TreeMatching {

	public boolean matchTree(TreeNode root1, TreeNode root2){
		if(root1==null && root2==null){
			return true;
		}
		
		if(root1==null || root2==null){
			return false;
		}
		if(root1.data==root2.data && matchTree(root1.left, root2.left) && matchTree(root1.right, root2.right)){
			return true;
		}
		return matchTree(root1.left, root2) || matchTree(root1.right, root2);
	}
	
//	TEST CASES
	
	@Test
	public void NullTest(){
		TreeNode root1 = null;
		TreeNode root2 = null;	
		assertEquals(true, matchTree(root1, root2));
	}
	
	@Test
	public void FalseTest(){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.right = new TreeNode(4);
		root1.left.left = new TreeNode(5);
		assertEquals(false, matchTree(root1, root));
	}
	
	@Test
	public void EqualTest(){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.right = new TreeNode(5);
		root1.left.left = new TreeNode(4);
		assertEquals(true, matchTree(root1, root));
	}
	
	@Test
	public void EqualOneNodeTest(){
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(1);
		assertEquals(true, matchTree(root1, root));
	}
	
	@Test
	public void FalseOneNodeTest(){
		TreeNode root = new TreeNode(1);
		TreeNode root1 = new TreeNode(7);
		assertEquals(false, matchTree(root1, root));
	}
	
	@Test
	public void FalseSubTreeTest(){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		TreeNode root1 = new TreeNode(3);
		root1.left = new TreeNode(6);
		root1.right = new TreeNode(7);
		assertEquals(true, matchTree(root, root1));
	}
	
	@Test
	public void TrueSubTreeTest(){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		TreeNode root1 = new TreeNode(2);
		root1.left = new TreeNode(6);
		root1.right = new TreeNode(7);
		assertEquals(false, matchTree(root, root1));
	}
	
	
}
