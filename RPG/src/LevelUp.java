import java.util.*;

public class LevelUp {
	public LevelUp(Player player) {
		int hpUp = 0;
		int dmgUp = 0;
		int spdUp = 0;
		boolean choosing = true;
		Scanner input = new Scanner(System.in);
		System.out.println("A chain breaks!");
		
		while (choosing) {
			System.out.println("You have 3 points to spend on stat upgrades.");
			System.out.println(" Hp: \n Dmg: \n Spd:");
			hpUp = input.nextInt();
			input.nextLine();
			dmgUp = input.nextInt();
			input.nextLine();
			spdUp = input.nextInt();
			input.nextLine();
			player.hp = player.maxHp;
			if ((hpUp + dmgUp + spdUp) == 3) {
				System.out.println("Are you sure? (Y/N)");
				String stringIn = input.nextLine();
				if (stringIn.equalsIgnoreCase("y")) {
					choosing = false;
					continue;
				}
				if (stringIn.equalsIgnoreCase("n"))
					continue;
			} else {
				if ((player.hp + player.dmg + player.spd) > 3) {
					System.out.println("Total too high!");
				} else {
					System.out.println("Total too low!");
				}
			}
		}

		player.maxHp += hpUp;
		player.dmg += dmgUp;
		player.spd += spdUp;

		Random rand = new Random();
		int range = 3;
		int xpMod = rand.nextInt(range * 2);
		player.xp = (7 - range) + xpMod;
	}
}
