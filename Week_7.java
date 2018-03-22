import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*

Microsoft Interview Coaching Pilot 2018 (MICP 2018)
Author: Aishna Gupta
Language: JAVA

************WEEK 6************

Problem description: Design a vending machine.
Clarify: No more restrictions, just design a general vending machine we are familiar with.
*/

public class Week_7 {
	
	
	public class Item{
		private String Item_Id;
		private String Item_Name;
		private int Item_Quantity;
		private int Item_Price;
		
		Item(String id, String name, int quantity,int price){
			Item_Id = id;
			Item_Name = name;
			Item_Quantity = quantity;
			Item_Price = price;
		}
		
		public int getPrice(){
			return Item_Price;
		}
		
		public void setPrice(int price){
			 Item_Price = price;
		}
		
		public int getQuantity(){
			return Item_Quantity;
		}
		
		public void setQuantity(int quantity){
			 Item_Quantity = quantity;
		}
		
		public String getName(){
			return Item_Name;
		}
		
		public void setName(String name){
			 Item_Name = name;
		}

		public String getId(){
			return Item_Id;
		}
		
		public void setId(String Id){
			 Item_Id = Id;
		}
		
		
	}
	
	public class Change{
		Item item;
		int change;
	}
	
	public enum CASH{
		ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), HUNDRED(100), TWO_HUNDRED(200), FIVE_HUNDRED(500);
		private int value; 
		
		private CASH(int value) 
			{ 
				this.value = value; 
			}
	}
	
	public class VendingMachine{
		int shelves, row, column, totalSales;
		Item items[][][] = new Item[shelves][row][column];
		ArrayList<Item> itemsList = new ArrayList<>();
		int totalCurrency;
		HashMap<CASH,Integer> currency = new HashMap<>();
		public Item vend(Item item) throws Exception{
			if(item.Item_Quantity <= 0 ){
				System.out.println("SORRY, PRODUCT SOLD OUT.");
				return null;
			}
			else{
				System.out.println("PLEASE INSERT MONEY");
				HashMap<CASH,Integer> cashReceived = new HashMap<>();
				if(acceptPayment(cashReceived, item)!=null)
					return item;
				else{
					return null;
				}
			}
		}
		
		public int itemPrice(Item item){
			return item.getPrice();
		}
		
		public Change acceptPayment(HashMap<CASH,Integer> cash, Item item) throws Exception{
			int amountReceived = getTotal(cash);
			while(item.Item_Price > amountReceived){
				Exception e = new Exception("INSUFFICIENT MONEY");
				throw e;	
			}
			if((amountReceived - item.getPrice()) < totalCurrency){
				Exception e = new Exception("OUT OF CHANGE");
				throw e;	
			}
			else{
				int change = amountReceived - item.getPrice();
				Change c = new Change();
				c.change = change;
				c.item = item;
				totalCurrency -= change;
				deductItem(item);
				return c;
			}
		}
		
		public int getTotal(HashMap<CASH,Integer> cash){
			int total = 0;
			Iterator<Map.Entry<CASH, Integer>> itr = cash.entrySet().iterator();
			while(itr.hasNext())
	        {
	             Map.Entry<CASH, Integer> entry = itr.next();
	             total += entry.getKey().values() * entry.getValue();
	        }
			return total;
		}
		
		public void addItem(Item item, int shelf, int r, int col) throws Exception{
			if(shelf>shelves || r>row || col>column && items[shelf][row][col]!=null){
				Exception e = new Exception("INSUFFICIENT SPACE");
				throw e;	
			}
			else{
				items[shelf][row][col] = item;
			}
		}
		
		public void deductItem(Item item){
			for(int i=0;i<shelves;i++){
				for(int j=0;j<row;j++){
					for(int k=0;k<column;k++){
						if(items[i][j][k] == item){
							items[i][j][k] = null;
						}
					}
				}
			}
		}	
	}

	
}
