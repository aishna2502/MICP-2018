package WEEK1;

import static org.testng.Assert.assertEquals;

//import java.util.Scanner;

import org.junit.Test;

public class Palindrome {
	static int length = 0;
	
	public static boolean is_palindrome(Node first, Node second){
		Node temp_f = first;
		Node temp_s = second;
		
		while(temp_f!=null && temp_f.next!=second){
			if(temp_f.data == temp_s.data){
				temp_f = temp_f.next;
				temp_s = temp_s.next;
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	public static Node reverse(Node start){
		Node current = start;
		Node prev = null;
		Node next;
		while(current!=null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		
		start = prev;
		return start;
	}
	
	public static boolean palindrome(Node start){
		if(start==null){
			return true;
		}
		
		Node temp = start;
		int n = (length/2);
		int l = 1;
		while(l<n){
			l++;
			temp = temp.next;
		}
		Node second = reverse(temp);
		boolean result =  is_palindrome(start,second);
		return result;
	}
	

	@Test
	public void emptyPali(){
		Node n = null;
		assertEquals(true, palindrome(n));
	}
	
	@Test
	public void oddPaliRight(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(1);
		n1.next = n2;
		n2.next = n3;
		assertEquals(true, palindrome(n1));
	}
	
	@Test
	public void oddPaliWrong(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.next = n2;
		n2.next = n3;
		assertEquals(false, palindrome(n1));
	}
	
	@Test
	public void evenPaliRight(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(2);
		Node n4 = new Node(1);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		assertEquals(true, palindrome(n1));
	}
	
	@Test
	public void evenPaliWrong(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		assertEquals(false, palindrome(n1));
	}
	
	

}
