package Week6;
import static org.testng.Assert.assertEquals;
import org.junit.Test;

public class TreeMatching {

	public boolean matchTree(TreeNode root1, TreeNode root2){
		if(root1==null && root2==null){
			return true;
		}
		
		if(root1.data!=root2.data){
			return false;
		}
		if(root1==null || root2==null){
			return false;
		}
		return matchTree(root1.left, root2.left) && matchTree(root1.right, root2.right);
	}
	
	
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
	
}
