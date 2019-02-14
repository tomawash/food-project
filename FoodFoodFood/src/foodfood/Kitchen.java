package foodfood;
import java.util.ArrayList;

public class Kitchen {

	private ArrayList<Ingredient> pantry = new ArrayList<Ingredient>();
	private String name;
	private Double funds;
	private final int maxID = 100;
	private final int maxAmount = 100;
	private int[] inventory = new int[maxID];
	
	//no argument constructor
	public Kitchen() {
		name = new String("My Kitchen");
		funds = 0.00;
		
		for(int i = 0; i < maxID; i++) {
			inventory[i] = 0;
		}
	}
	
	//param constructors
	public Kitchen(String s) {
		name = new String(s);
	}
	
	public Kitchen(Double d) {
		name = new String("My Kitchen");
		funds = d;
	}
	
	public Kitchen(String s, Double d) {
		name = new String(s);
		funds = d;
	}
	
	//to string
	public String toString() {
		String myString = new String();
		myString = String.format("%s %d", name, pantry.size());
		return myString;
	}
	
	public void sortPantry() {
		
		for(int a = 0; a < (pantry.size() - 1); a++) {
			for(int b = (a + 1); b < pantry.size(); b++) {
				if(pantry.get(a).getID() > pantry.get(b).getID()) {
					Ingredient temp = pantry.get(a);
					pantry.set(a, pantry.get(b));
					pantry.set(b, temp);
				}
			}
		}
	}
	
	public void updateInventory() {
		 
		for(int i = 0; i < maxID; i++) {
			
		int count = 0;
		
			for(int j = 0; j < pantry.size(); j++) {
				
				Ingredient temp = pantry.get(j);
				
				if(temp.getID() == i) {
					count ++;
				}
			}
			
		inventory[i] = count;
		}
	}
	
	public Double getPantryWorth() {
		
		Double x = 0.00;
		
		for(int i = 0; i < pantry.size(); i++) {
			
			x = x + pantry.get(i).getPrice();
		}
		
		return x;
	}
	
	public void addFood(Ingredient i) {
		pantry.add(i);
		sortPantry();
		updateInventory();
	}
	
	public String getName() {
		return name;
	}
	
	public int getPantrySize() {
		return pantry.size();
	}
	
	public Ingredient getIngredient(int i) {
		return pantry.get(i);
	}
	
	public int getMaxID() {
		return maxID;
	}
	
	public int getMaxAmount() {
		return maxAmount;
	}
	
	public int getAmount(int id) {
		return inventory[id];
	}
	
	public Double getFunds() {
		return funds;
	}
}