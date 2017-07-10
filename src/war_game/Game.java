package war_game;
import war_game.Race;
import war_game.Hero;
import java.util.ArrayList;
import java.util.Random;

public class Game {

	String[] racesNames;
	ArrayList<Race> RacesList;
	ArrayList<Race> enemyRace;
	Game game1;
	ArrayList<Hero> troops;
	int racecount;
	
	public static void main(String[] args) {
		String[] races = {"elves", "human", "orcs", "spirits"};
		Game newGame = new Game(races);
		newGame.setAlly();
		newGame.chooseRaces();
		newGame.createTroops();
		newGame.randFight();
	}

	public Game(String[] names) {
		this.racesNames = names;
		ArrayList<Race> Races = new ArrayList<Race>();
		for (String name: this.racesNames) {
			Races.add(new Race(name));
		}
		this.RacesList=Races;
		this.troops = new ArrayList<Hero>();
	}
	
	public void setAlly() {
		for (Race i: this.RacesList) {
			for (Race b: this.RacesList) {
				if (i.getName().equals("elves") && b.getName().equals("human")){
					i.setAlly(b);
					b.setAlly(i);
				} else if (i.getName().equals("orcs") && b.getName().equals("spirits")) {
					i.setAlly(b);
					b.setAlly(i);
				}
			}
		}
	}
	
	public void chooseRaces() {
		int raceCount = this.RacesList.size();
		Random rand = new Random();
		int firstIndex = rand.nextInt(raceCount);
		this.enemyRace = new ArrayList<Race>();
		Race firstRace = this.RacesList.get(firstIndex);
		this.enemyRace.add(firstRace);
		System.out.println(firstRace.getName() + " was added to enemy list");
		ArrayList<Race> restRaces = new ArrayList<Race>();
		for (Race a: this.RacesList) {
			if (!a.equals(firstRace) && !firstRace.getAlly().contains(a)) {
				System.out.println(a.getName() + " was added to temp storage");
				restRaces.add(a);
			}
		}
		int nextRaceCount = restRaces.size();
		int secondRace = rand.nextInt(nextRaceCount);
		this.enemyRace.add(restRaces.get(secondRace));
		this.racecount=enemyRace.size();
	}
	
	public void createTroops() {
		int counter = 0;
		for (Race r: this.enemyRace) {
			for (int i=1; i < 3; i++) {
				counter++;
				String warriorName = "unit";
				warriorName += Integer.toString(counter);
				Hero unit = new Hero(r, warriorName);
				System.out.println(unit.getType() + " was created ");
				Skill sk = new SimpleAttack(unit, 35);
				System.out.println("skil was created for " + sk.getOwner().getType());
				unit.addSkill(sk);
				this.troops.add(unit);
			}
		}
	}
	
	public void randFight() {
		int attackers = 0;
		int defenders = 1;
		int movecounter = 1;
		while (true){
			Race currentMove = enemyRace.get(attackers);
			System.out.println(" -  - - - - - - - - - - - - - - - - - - - - - - - - - ");
			System.out.println(movecounter + " in progress");
			System.out.print(currentMove.getName() + " is attacking ");
			System.out.println(enemyRace.get(defenders).getName() + " is defencing");
			int curTeam = 0;
			int rival = 0;
			for (int i = 0; i < troops.size(); i++) {
				Hero h = troops.get(i);
				System.out.println("Potentioal attackers " + h.getType() + " belongs to " + h.getRace().getName());
				if (h.getRace().equals(currentMove)) {
					System.out.println("attackers " + h.getType() + " belongs to " + h.getRace().getName());
					curTeam++;
					for (int j = 0; j < troops.size(); j++) {
						Hero v = troops.get(j);
						System.out.println("potencial victim " + v.getType() + " belongs to " + v.getRace().getName());
						if (!v.getRace().equals(h.getRace()) && !h.getAllies().contains(v.getRace())){
							rival++;
							System.out.println("victim " + v.getType() + " belongs to " + v.getRace().getName());
							h.useSkillByID(0, v);
							System.out.println(v.getType() + " has " + v.getHealth() + " HP left");
							if (v.getHealth()<= 0) {
								troops.remove(j);
								System.out.println(v.getType() + " with " + v.getHealth() + " was removed");
							}
							break;
						}
					}
					if (rival <= 0) {
						System.out.println("rival check");
						System.out.println("There are no alive members in " + enemyRace.get(defenders).getName() + " squad");
						break;
					}
				}
			}
				if (curTeam <= 0) {
					System.out.println("attackers");
					System.out.println("Currently no active members of " + currentMove.getName() + " squad");
					break;
					}
			if (movecounter >= 10) {
				System.out.println("infinity loop detected on " + movecounter + "move");
				break;
			}
			int tmp = attackers;
			attackers = defenders;
			defenders = tmp;
			movecounter++;
		}
	}
}
