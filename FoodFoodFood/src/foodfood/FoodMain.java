package foodfood;

import java.io.*;
import java.util.Scanner;

public class FoodMain {

	public static void main(String[] args) throws FileNotFoundException {
		
		//File fileFoodID = new File("c:\\Users\\Tomasz\\eclipse-workspace\\FoodFoodFood\\src\\foodfood\\food_ID");
		File fileFoodID = new File("food_ID");
		Scanner inputFoodID = new Scanner(fileFoodID);
		
		//File fileFoodInventory = new File("c:\\Users\\Tomasz\\eclipse-workspace\\FoodFoodFood\\src\\foodfood\\food_inventory");
		File fileFoodInventory = new File("food_inventory");
		Scanner inputFoodInventory = new Scanner(fileFoodInventory);
		
		Kitchen kitchen = new Kitchen(20.00);
		
		String[] foodID = new String[kitchen.getMaxID()];
		foodID = readFoodID(inputFoodID, kitchen.getMaxID());
		
		readPantry(kitchen, inputFoodInventory);
		
		printPantry(kitchen, foodID);
		
		
	}
	
	public static String[] readFoodID(Scanner input, int max) {
		
		String[] foodID = new String[max];
		int x;
		
		while(input.hasNextLine()) {
			x = input.nextInt();
			foodID[x] = input.next();
		}
		
		return foodID;
	}
	
	public static void readPantry(Kitchen kitchen, Scanner input) {
		
		int id;
		int amount;
		
		while(input.hasNextLine()) {
			
			id = input.nextInt();
			amount = input.nextInt(); 
			
			switch(id) {
			
				case 00:
					break;
				
				case 01:
					for(int i = 0; i < amount; i++) {
						Egg myEgg = new Egg();
						kitchen.addFood(myEgg);
					}
					break;
					
				case 02:
					for(int i = 0; i < amount; i++) {
						Milk myMilk = new Milk();
						kitchen.addFood(myMilk);
					}
					break;
					
				case 03:
					for(int i = 0; i < amount; i++) {
						Butter myButter = new Butter();
						kitchen.addFood(myButter);
					}
					break;
					
				case 04:
					for(int i = 0; i < amount; i++) {
						Flour myFlour = new Flour();
						kitchen.addFood(myFlour);
					}
					break;
				
				default:
					break;	
			}
		}
	}
	
	public static void printPantry(Kitchen kitchen, String[] id) {
		
		System.out.println(kitchen.getName());
		System.out.println("-----------");
		System.out.printf("Funds:\t$%.2f", kitchen.getFunds());
		//System.out.println("Money: " + kitchen.getFunds());
		System.out.println();
		System.out.println();
		
		for(int i = 0; i < kitchen.getMaxID(); i++) {
			if(kitchen.getAmount(i) > 0) {
				System.out.printf("%s\tx%d", id[i], kitchen.getAmount(i));
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.printf("Pantry Worth:\t$%.2f", kitchen.getPantryWorth());
		System.out.println();
		System.out.printf("Net Worth:\t$%.2f", (kitchen.getFunds() + kitchen.getPantryWorth()));
		System.out.println();
		System.out.println();
	}
}