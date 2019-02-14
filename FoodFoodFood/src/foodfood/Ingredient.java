package foodfood;

public abstract class Ingredient {

	protected int id;
	protected String name;
	protected double price;
	protected int quantity;
	
	//no argument constructor
	public Ingredient() {
		id = 00;
		name = new String("Empty");
	}
	
	//param constructor
	public Ingredient(int i, String s) {
		id = i;
		name = new String(s);
	}
	
	//copy constructor
	public Ingredient(Ingredient myIng) {
		id = myIng.id;
		name = new String(myIng.name);
	}
	
	public int getID() {
		return id;
	}
	
	public String getName() {
		return new String(name);
	}
	
	public double getPrice() {
		return price;
	}
}