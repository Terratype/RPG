import java.util.Random;

public class monsterGen {
	int lvl;
	int hp;
	int spd;
	int dmg;
	String name;
	Random rand = new Random();
	static String[] adjectives = {"stupid", "angry", "bumbling", "fierce looking", "rabid", "smelly", "suspicious", "rotting", "omnipitant", "idiot"};
	static String[] type = {"goblin", "ghoul", "ghost", "orc", "wolf", "falco", "pizza", "worm on a string", "skeleton", "sans"};
	public monsterGen(int lvl) {
		int lvlMod = rand.nextInt(6);
		boolean flip = rand.nextBoolean();
		if (flip) {
			this.lvl = lvl + lvlMod;
		} else {
			this.lvl = lvl - lvlMod;
		}
		hp = this.lvl;
		dmg = this.lvl;
		spd = this.lvl;
		int giveTake;
		for (int x = 10; x > 0; x--) {
			giveTake = rand.nextInt(2);
			if (giveTake == 0)
				hp--;
			if (giveTake == 1)
				dmg--;
			if (giveTake == 3)
				spd--;
			giveTake = rand.nextInt(2);
			if (giveTake == 0)
				hp++;
			if (giveTake == 1)
				dmg++;
			if (giveTake == 3)
				spd++;
		}
		int namRand = rand.nextInt(10);
		int namRand2 = rand.nextInt(10);
		this.name = adjectives[namRand] + " " + type[namRand2];
	}
}
