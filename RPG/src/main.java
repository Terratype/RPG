import static java.lang.System.*;
import java.util.*;
import java.io.*;

public class main {
	public static void clear() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception e) {
			System.out.println("Whats poppin youtube it's ya boy, " + e);
		}
	}

	public static void main(String[] args) {
		Player player = new Player();

		clear();
		String in = "dumb";
		int room = 0;
		Scanner input = new Scanner(System.in);

		player.choose();
		for (; room < 50;) {
			if (player.hp > 0) {

				if (player.xp < 1) {
					LevelUp lvlUp = new LevelUp(player);
				} else {
					System.out.println("Press enter to go to the next room");
					in = input.nextLine();
				}
				room++;
				System.out.println("Room " + room);
				if (room % 5 == 0) {
					shop(player);
				} else if (((room - 1) % 10 == 0) && room > 1) {
					boss();
				} else {
					monsterGen monster = new monsterGen(player.lvl);
					Battle battle = new Battle(player, monster);
				}
			}
		}
	}

	public static void shop(Player player) {
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the shop!");
		boolean atShop = true;
		while (atShop) {
			System.out.println("Would you like to shop (A), talk to the shopkeep (S), or leave (D)");
			String stringIn = input.nextLine();

			if (stringIn.equalsIgnoreCase("s")) {
				System.out.print("So, " + player.name + " eh? Nice name, fits for a ");
				if (player.maxHp > player.dmg && player.maxHp > player.spd)
					System.out.print("tanky ");
				if (player.dmg > player.maxHp && player.dmg > player.spd)
					System.out.print("fierce ");
				if (player.spd > player.maxHp && player.spd > player.dmg)
					System.out.print("speedy ");
				System.out.println("guy like you.");

				boolean talking = true;
				while (talking) {
					System.out.println("Would you like to keep talking (A), check stats (S), or leave (D)");
					stringIn = input.nextLine();
					if (stringIn.equalsIgnoreCase("a")) {
						System.out.println("no");
						continue;
					}
					if (stringIn.equalsIgnoreCase("s")) {
						System.out.println("HP: " + player.maxHp);
						System.out.println("Dmg: " + player.dmg);
						System.out.println("Spd: " + player.spd);
						System.out.print("Your outermost chains seem ");
						if (player.xp > 6)
							System.out.println("strong.");
						else if (player.xp > 4)
							System.out.println("to be scratched.");
						else if (player.xp > 2)
							System.out.println("well worn.");
						else if (player.xp > 0)
							System.out.println("to be on the verge of breaking.");
						continue;
					}
					if (stringIn.equalsIgnoreCase("d")) {
						talking = false;
						continue;
					}
				}

			}
			if (stringIn.equalsIgnoreCase("a")) {
				boolean shopping = true;
				while (shopping) {
					System.out.println("You have " + player.coins + " coins.");
					System.out.println("You can buy a...");
					System.out.println("1. Health potion (20 coins)");
					if ((player.inv[1] + player.inv[2] + player.inv[3]) < 2) {
						System.out.println("2. Health charm (50 coins)");
						System.out.println("3. Damage charm (50 coins)");
						System.out.println("4. Speed charm (50 coins)");
						System.out.println("Note: You're only allowed to have 2 charms.");
					}
					System.out.println("Or press 0 to exit.");

					int in = input.nextInt();
					input.nextLine();
					if (in == 1) {
						if (player.coins > 20) {
							player.inv[0]++;
							player.coins -= 20;
						} else {
							System.out.println("You dont have enough coins for that!");
							continue;
						}
					}
					if (in == 2) {
						if (player.coins > 50) {
							player.inv[1]++;
							player.maxHp += 10;
							player.coins -= 50;
						} else {
							System.out.println("You dont have enough coins for that!");
							continue;
						}
					}
					if (in == 3) {
						if (player.coins > 50) {
							player.inv[2]++;
							player.dmg += 10;
							player.coins -= 50;
						} else {
							System.out.println("You dont have enough coins for that!");
							continue;
						}
					}
					if (in == 4) {
						if (player.coins > 50) {
							player.inv[3]++;
							player.spd += 10;
							player.coins -= 50;
						} else {
							System.out.println("You dont have enough coins for that!");
							continue;
						}
					}
					if (in == 0) {
						shopping = false;
						continue;
					}
				}
			}
			if (stringIn.equalsIgnoreCase("d")) {
				atShop = false;
				continue;
			}
		}
	}

	public static void boss() {
		System.out.println("A boss appears!");
	}
}