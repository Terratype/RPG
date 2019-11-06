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
		String name;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter your name");
		name = input.nextLine();

		System.out.println("Greetings " + name + "!");
		player.choose();
		for (; room < 50;) {
			if (player.hp > 0) {
				System.out.println("Press enter to go to the next room");
				in = input.nextLine();

				room++;
				System.out.println("Room " + room);
				if (room % 5 == 0) {
					shop(player.coins, player.inv);
				} else if (((room - 1) % 10 == 0) && room > 1) {
					boss();
				} else {
					monsterGen monster = new monsterGen(player.lvl);
					Battle battle = new Battle(player, monster);
				}
			}
		}
	}

	public static void shop(int coins, int[] inv) {
		System.out.println("Welcome to the shop!");
		System.out.println("You have " + coins + " coins.");
		System.out.println("You can buy a...");
		System.out.println("1. Health potion (20 coins)");
		System.out.println("2. Health charm (50 coins)");
		System.out.println("3. Damage charm (50 coins)");
		System.out.println("4. Speed charm (50 coins)");
		System.out.println("Note: You're only allowed to have 2 charms.");
		System.out.println("5. Exit");
		Scanner input = new Scanner(System.in);
		int in = input.nextInt();
		input.nextLine();
		if (in == 1)
			inv[0] ++;
		if (in == 2)
			inv[1] ++;
		if (in == 3)
			inv[2] ++;
		if (in == 4)
			inv[3] ++;
	}

	public static void boss() {
		System.out.println("A boss appears!");
	}
}