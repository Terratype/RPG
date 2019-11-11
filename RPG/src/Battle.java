import java.util.*;

public class Battle {
	private int dodge = 0;
	Scanner input = new Scanner(System.in);
	public Battle(Player player, monsterGen monster) {
		System.out.println("You encounter a level " + monster.lvl + " " + monster.name + "!");
		player.hp = player.maxHp;
		
		if (player.spd > monster.spd) {
			while (player.hp > 0 && monster.hp > 0) {
				pTurn(player, monster);
				System.out.println("\n");
				input.nextLine();
				if (monster.hp <= 0)
					continue;
				eTurn(player, monster);
				System.out.println("\n");
				input.nextLine();
				if (player.hp <= 0)
					continue;
			}
		}
		if (player.spd < monster.spd) {
			while (player.hp > 0 && monster.hp > 0) {
				eTurn(player, monster);
				System.out.println("\n");
				input.nextLine();
				if (player.hp <= 0)
					continue;
				pTurn(player, monster);
				System.out.println("\n");
				input.nextLine();
				if (monster.hp <= 0)
					continue;
			}
		}
		if (player.hp <= 0) {
			System.out.println("You lost!");
		}
		if (monster.hp <= 0) {
			int loot = monster.lvl;
			System.out.println("You win!");
			System.out.println("You gained " + loot + " coins!");
			player.coins += loot;
			System.out.println("Your chains wear down a bit...");
			player.xp--;
		}
	}

	public void pTurn(Player player, monsterGen monster) {
		
		player.def = 1;

		System.out.println("Your HP: " + player.hp);
		System.out.println("Would you like to Attack (A), Defend (S), Dodge (D), or Check (C)");
		String in = input.nextLine();
		
		if (in.equalsIgnoreCase("a")) {
			System.out.println("You attack!");
			Random rand = new Random();
			int range = player.lvl/10;
			int dmgMod = rand.nextInt(range*2);
			int damage = ((player.dmg / 2) - range) + dmgMod;
			if (damage < 1)
				damage = 1;
			if (dodge == 3) {
				damage = damage * 3;
				dodge = 0;
			}
			monster.hp -= damage;
			System.out.println("You delt " + damage + " damage!");
		} 
		else if (in.equalsIgnoreCase("s")) {
			System.out.println("You defend!");
			player.def = 3;
		} 
		else if (in.equalsIgnoreCase("c")) {
			player.def = 2;
			System.out.println("You analyze the monster...");
			System.out.println("It's a level " + monster.lvl + " " + monster.name + ".");
			System.out.println("It has " + monster.dmg + " Dmg, and " + monster.spd + " Spd.");
			
			
		} else if (in.equalsIgnoreCase("d")) {
			Random rand = new Random();
			System.out.println("You attampt a dodge!");
			double spdCheck = (player.spd)*1.5;
			double randDouble = rand.nextInt(player.lvl*3);
			if (spdCheck > randDouble) {
				dodge = 1;
			} else {
				System.out.println("You tripped!");
				player.hp--;
				dodge = 0;
			}
		}
		else if (in.equalsIgnoreCase("w")) {
			monster.hp = 0;
		} 
		else
			System.out.println("stupid");
	}
	public void eTurn(Player player, monsterGen monster) {
		System.out.println("The monster's HP: " + monster.hp);
		System.out.println("The " + monster.name + " attacks!");
		if (dodge == 0) {
			Random rand = new Random();
			int range = monster.lvl/10;
			int dmgMod = rand.nextInt(range);
			int damage = (((monster.dmg / 3) - range) + dmgMod) / player.def;
			player.hp -= damage;
			System.out.println("The " + monster.name + " delt " + damage + " damage!");
		}
		else if (dodge == 1) {
			System.out.println("You dodged!");
			dodge = 3;
		}
	}
}
