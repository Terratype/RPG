import java.util.*;

public class Battle {
	public Battle(Player player, monsterGen monster) {
		System.out.println("You encounter a level " + monster.lvl + " " + monster.name + "!");
		player.hp = player.maxHp;
		if (player.spd > monster.spd) {
			while (player.hp > 0 && monster.hp > 0) {
				pTurn(player, monster);
				System.out.println("\n");
				if (monster.hp <= 0)
					continue;
				eTurn(player, monster);
				System.out.println("\n");
				if (player.hp <= 0)
					continue;
			}
		}
		if (player.spd < monster.spd) {
			while (player.hp > 0 && monster.hp > 0) {
				eTurn(player, monster);
				System.out.println("\n");
				if (player.hp <= 0)
					continue;
				pTurn(player, monster);
				System.out.println("\n");
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
		}
	}

	public void pTurn(Player player, monsterGen monster) {
		Scanner input = new Scanner(System.in);
		player.def = 1;
		System.out.println("Your HP: " + player.hp);
		System.out.println("Would you like to Attack (A), Defend (D), or Check (C)");
		String in = input.nextLine();
		if (in.equalsIgnoreCase("a")) {
			System.out.println("You attack!");
			Random rand = new Random();
			int range = 3;
			int dmgMod = rand.nextInt(range);
			int damage = ((player.dmg / 2) - range) + dmgMod;
			monster.hp -= damage;
			System.out.println("You delt " + damage + " damage!");
		} else if (in.equalsIgnoreCase("d")) {
			System.out.println("You defend!");
			player.def = 3;
		} else if (in.equalsIgnoreCase("c")) {
			player.def = 2;
			System.out.println("You analyze the monster...");
			System.out.println("It's a level " + monster.lvl + " " + monster.name + ".");
			System.out.println("It has " + monster.dmg + " Dmg, and " + monster.spd + " Spd.");
		} else
			System.out.println("stupid");
	}

	public void eTurn(Player player, monsterGen monster) {
		System.out.println("The monster's HP: " + monster.hp);
		System.out.println("The " + monster.name + " attacks!");
		Random rand = new Random();
		int range = 3;
		int dmgMod = rand.nextInt(range);
		int damage = (((monster.dmg / 3) - range) + dmgMod) / player.def;
		player.hp -= damage;
		System.out.println("The " + monster.name + " delt " + damage + " damage!");
	}
}
