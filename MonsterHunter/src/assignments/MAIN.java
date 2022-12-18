package assignments;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MAIN {
	Scanner scan  = new Scanner(System.in);
	Random rand = new Random ();
	ArrayList<Monsters> monsterData = new ArrayList<>();
	
	
	String genDrop () {
		String drop = "";
		int temp = rand.nextInt(99) - 1;
		if (temp % 11 == 0) drop = "Helmet";
		else if (temp % 3 == 0) drop = "Torso";
		else if (temp % 7 == 0) drop = "Legs";
		else if (temp % 5 == 0) drop = "Weapon";
		else if (temp % 13 == 0) drop = "Hands";
		return drop;
	}
	
	public void attack () {
		
	}
	public void Add () {
		String name, type, element, area, lowWeakness = "", highWeakness = "";
		double multiplier = 0;
		
		do {
			System.out.print("Monster Name [> 5] : ");
			name = scan.nextLine();
		} while (name.length() < 5);
		
		// validasi untuk type yang bisa amphibian, reptile, avian, atau mammal;
		do {
			System.out.print("Monster Type [Mammal || Amphibian || Avian] : ");
			type = scan.nextLine();
		} while (!(type.equals("Mammal") || type.equals("Amphibian") || type.equals("Avian")));
		//validasi area yang hanya bisa Forest, Desert, Prairie, Mountains;
		
		do {
			System.out.print("Monster Type [Forrest || Plains || Mountains] : ");
			area = scan.nextLine();
		} while (!(area.equals("Forrest") || area.equals("Plains") || area.equals("Mountains")));
		
		//validasi element yang hanya bisa fire, electro, poison, earth, water;
		do {
			System.out.print("Monster Type [Fire || Water|| Poison || Electro || Earth] : ");
			element = scan.nextLine();
		} while (!(element.equals("Fire") || element.equals("Water") || element.equals("Poison") || element.equals("Electro") || element.equals("Earth")));
		
		// set weakness berdasarkan element type;
		if (type.equals("Fire")) {
			lowWeakness = "Earth";
			highWeakness = "Water" ;
		}
		
		else if (type.equals("Water")){
			lowWeakness = "Fire";
			highWeakness = "Earth" ;
		}
		
		else if (type.equals("Poison")) {
			lowWeakness = "Earth";
			highWeakness = "Electro";
		
		}
		
		else if (type.equals("Electro")) {
			lowWeakness = "Poison";
			highWeakness = "Earth";
		}
		
		else if (type.equals("Earth")) {
			lowWeakness = "Poison";
			highWeakness = "Electro";
		}
		
		monsterData.add(new ElementedMonster(name, type, element, area, lowWeakness, highWeakness, multiplier));
		System.out.println("Monster Successfully Added");
	}
	
	//TODO
	public void View () {
		if (monsterData.isEmpty()) {
			System.out.println("Data is Empty");
		}
		
		else {
			//print monster dengan memanggil function yang ada di interface
			System.out.printf("|%-4s | %-16s | %-10s | %-8s | %-8s |\n", "No.", "Name", "Type", "Element", "Area");
			for (Monsters show : monsterData) {
				System.out.printf("|%-4s ", monsterData.indexOf(show) + 1);
				if (show instanceof ElementedMonster) {
					((ElementedMonster)show).showData();
				}
			}
			System.out.println("Press Enter To Continue ..."); scan.nextLine();
			
		}
		System.out.println();
		
			
	}
	
	void fightMenu () {
		System.out.println("1. Attack");
		System.out.println("2. Potion");
		System.out.println("3. Shield");
		System.out.println("4. Capture");
		System.out.println("5. Cancel");
		System.out.printf(">> ");
	}
	public void Fight () {
		if (monsterData.isEmpty()) {
			View();
		}
		
		else {
			View();
			int idxToFind;
			String weaponElement;
			double weaponMultiplier =  0.0;
			int weaponDamage;
			int monsterDamage;
			int sumdamage = 0;
			
			do {
				// scan id sesuai dengan size arraylist
				System.out.print("Monster To Fight : ");
				idxToFind = scan.nextInt(); scan.nextLine();
			} while (idxToFind < 1 || idxToFind > monsterData.size());
			
			Monsters attackedMonster = monsterData.get(idxToFind-1);
			String drop = genDrop();
			do {
				System.out.print("What is Your Weapon Element : ");
				weaponElement = scan.nextLine();
			} while (!(weaponElement.equals("Fire") || weaponElement.equals("Water") || weaponElement.equals("Poison") || weaponElement.equals("Electro") || weaponElement.equals("Earth")));
			
			
			weapon mainWeapon = new weapon(weaponElement, weaponMultiplier);
			
			
			int monHealth = 150;
			int hunHealth  = 70;
			
			int c = 0,caught = 0;
			// kondisi ketika ingin melawan monsternya
			 while (monHealth > 0 || hunHealth > 0 || caught == 1 || c != 5) {
				System.out.println("Your Health : " + hunHealth);
				System.out.println("Monster Health : " + monHealth);
				fightMenu();
				c = scan.nextInt();scan.nextLine();
				
				switch (c) {
				case 1:
					// sesuaikan weapon elemnt dengan weakness punya monster
					if (mainWeapon.getWeaponElement().equals(((ElementedMonster)attackedMonster).getHighWeakness())) {
						//weapon dan monster damage yang di randomize
						weaponDamage = rand.nextInt(41)-1;
						monsterDamage = rand.nextInt (31)-1;
						
						((weapon)mainWeapon).setWeaponMultiplier(2.0);
						weaponDamage = ((weapon)mainWeapon).genDamage(weaponDamage);
						sumdamage = sumdamage + weaponDamage;
						
						System.out.println("You Dealt " + weaponDamage + " Damage To the Monster!");
						monHealth = monHealth - weaponDamage;
						
						((ElementedMonster)attackedMonster).setMultiplier(0.5);
						monsterDamage = ((ElementedMonster)attackedMonster).genDamage(monsterDamage);
						System.out.println("Monster Dealt " + monsterDamage + " Damage To You!");
						hunHealth = hunHealth - monsterDamage;
					}
					
					else if (mainWeapon.getWeaponElement().equals(((ElementedMonster)attackedMonster).getLowWeakness())){
						weaponDamage = rand.nextInt(41)-1;
						monsterDamage = rand.nextInt (31)-1;
						
						((weapon)mainWeapon).setWeaponMultiplier(0.7);
						weaponDamage = ((weapon)mainWeapon).genDamage(weaponDamage);
						sumdamage = sumdamage + weaponDamage;
						
						System.out.println("You Dealt " + weaponDamage + " Damage To the Monster!");
						monHealth = monHealth - weaponDamage;
						
						((ElementedMonster)attackedMonster).setMultiplier(1.1);
						monsterDamage = ((ElementedMonster)attackedMonster).genDamage(monsterDamage);
						System.out.println("Monster Dealt " + monsterDamage + " Damage To You!");
						hunHealth = hunHealth - monsterDamage;
					}
					
					else {
						weaponDamage = rand.nextInt(41)-1;
						monsterDamage = rand.nextInt (31)-1;
						
						((weapon)mainWeapon).setWeaponMultiplier(1.0);
						weaponDamage = ((weapon)mainWeapon).genDamage(weaponDamage);
						sumdamage = sumdamage + weaponDamage;
						
						System.out.println("You Dealt " + weaponDamage + " Damage To the Monster!");
						monHealth = monHealth - weaponDamage;
						
						((ElementedMonster)attackedMonster).setMultiplier(1.0);
						monsterDamage = ((ElementedMonster)attackedMonster).genDamage(monsterDamage);
						System.out.println("Monster Dealt " + monsterDamage + " Damage To You!");
						hunHealth = hunHealth - monsterDamage;
					}
					break;

				case 2:
					if (hunHealth  == 70) {
						System.out.println("Health is Still Full!");
						break;
					}
					else {
						// object potion yang menambahkan health
						int  healthAdded = rand.nextInt(16)+1;
						Potion Entry = new Potion(healthAdded);
						int temp = hunHealth;
						hunHealth = temp + Entry.getHealthAdded();
						
						System.out.println("Potion Healed " + Entry.getHealthAdded() + " Health");
					}
					break;
					
				case 3:
					//shield yang menghalang damage
					int damageTaken = rand.nextInt(36) + 1;
					Shield block = new Shield(weaponElement, weaponMultiplier, damageTaken);
					if (block.getWeaponElement().equals(((ElementedMonster)attackedMonster).getHighWeakness())) {
						monsterDamage = rand.nextInt (31)-1;
						
						((ElementedMonster)attackedMonster).setMultiplier(0.5);
						// mengurangi monster damage dengan damagetaken oleh shield
						monsterDamage = ((ElementedMonster)attackedMonster).genDamage(monsterDamage) - damageTaken;
						System.out.println("Shield Blocked " + ((Shield)block).getDamageTaken());
						
						System.out.println("Monster Dealt " + monsterDamage + " Damage To You!");
						
						hunHealth = hunHealth - monsterDamage;
					}
					
					else if (mainWeapon.getWeaponElement().equals(((ElementedMonster)attackedMonster).getLowWeakness())){
						monsterDamage = rand.nextInt (31)-1;
						
						((ElementedMonster)attackedMonster).setMultiplier(1.1);
						monsterDamage = ((ElementedMonster)attackedMonster).genDamage(monsterDamage) - damageTaken;
						System.out.println("Shield Blocked " + ((Shield)block).getDamageTaken());
						
						System.out.println("Monster Dealt " + monsterDamage + " Damage To You!");
						
						hunHealth = hunHealth - monsterDamage;
					}
					
					else {
						monsterDamage = rand.nextInt (31)-1;
						
						((ElementedMonster)attackedMonster).setMultiplier(1.1);
						monsterDamage = ((ElementedMonster)attackedMonster).genDamage(monsterDamage) - damageTaken;
						System.out.println("Shield Blocked " + ((Shield)block).getDamageTaken());
						
						System.out.println("Monster Dealt " + monsterDamage + " Damage To You!");
						
						hunHealth = hunHealth - monsterDamage;
					}
					break;
					
				case 4 : 
					int chance = rand.nextInt(6)+1;
					Net capture = new Net(chance);
					caught = capture.genChance();
					if (caught == 0){
						System.out.println("Failed To Capture The Monster");
					}
					break;
			}
			//check apakah hunter atau monster yang menang
			if (monHealth < 0 ) {
				System.out.println("You Defeated " + attackedMonster.getName() + " at the " + attackedMonster.getArea());
				System.out.println("The Monster Dropped " + attackedMonster.getType()  + " " + drop + " and you dealt "  + sumdamage + " Damage");	
				monsterData.remove(idxToFind-1);
				break;
			}
			else if (hunHealth < 0) {
				System.out.println("You Have Been Defeated By "  + attackedMonster.getName() + " at the " + attackedMonster.getArea());
				break;
			}
		}
			System.out.println("Press Enter To Continue ...");
		}
		
	}
	public void showmenu () {
		System.out.println("1. Add Monster Data");
		System.out.println("2. View Monster List");
		System.out.println("3. Fight The Monster");
		System.out.println("4. Close Program");
		System.out.printf(">> ");
	}
	
	public MAIN() {
		int c; 
		do {
			showmenu();
			c = scan.nextInt(); scan.nextLine();
			
			switch (c) {
			case 1:
				Add ();
				break;
			case 2:
				View ();
				break;
			case 3: 
				Fight ();
				break;
			case 4:
				scan.close();
				System.exit(0);
				break;
			}
		} while (c != 6);
	}
	
	public static void main(String[] args) {
		new MAIN ();
	}

}
