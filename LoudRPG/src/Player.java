import java.util.*;

public class Player {
	int lvl = 20;
	int hp;
	int maxHp;
	int dmg;
	int spd;
	int[] inv = {0, 0, 0, 0};
	int def = 1;
	int charms = 0;
	int xp = 100;
	int coins = 10;
	static Scanner input = new Scanner(System.in);
	boolean choosing = true;

	public void choose() {
		while (choosing) {
			System.out.println("Please enter your stats. (Max " + (lvl * 3) + ")");
			System.out.println(" Hp: \n Dmg: \n Spd:");
			this.maxHp = input.nextInt();
			input.nextLine();
			this.dmg = input.nextInt();
			input.nextLine();
			this.spd = input.nextInt();
			input.nextLine();
			this.hp = this.maxHp;
			if ((this.hp + this.dmg + this.spd) <= (lvl*3) && (this.hp + this.dmg + this.spd) >= (3))
				choosing = false;
			else {
				if ((hp + dmg + spd) > (lvl*3)) {
					System.out.println("Total too high!");
				} else {
					System.out.println("Total too low!");
				}
			}
		}
	}
	public int coins() {
		return this.coins;
	}
}
