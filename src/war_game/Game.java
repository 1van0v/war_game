package war_game;
import war_game.Race;
import war_game.Hero;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.Collections;

public class Game {

	String[] racesNames;
	ArrayList<Race> RacesList;
	ArrayList<Race> enemyRace;
	Game game1;
	ArrayList<Hero> troops;
	int racecount;
	HashMap<String, Integer> squadMap;
	int skn;
	
	public static void main(String[] args) {
		String[] races = {"elves", "human", "orcs", "spirits"};
		Game newGame = new Game(races);
		newGame.setAlly();
		newGame.chooseRaces();
		newGame.setSquadMap();
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
		this.squadMap = new HashMap<String, Integer>();
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
		//System.out.println(firstRace.getName() + " was added to enemy list");
		ArrayList<Race> restRaces = new ArrayList<Race>();
		for (Race a: this.RacesList) {
			if (!a.equals(firstRace) && !firstRace.getAlly().contains(a)) {
				//System.out.println(a.getName() + " was added to temp storage");
				restRaces.add(a);
			}
		}
		int nextRaceCount = restRaces.size();
		int secondRace = rand.nextInt(nextRaceCount);
		Race sr = restRaces.get(secondRace);
		this.enemyRace.add(sr);
		this.racecount=enemyRace.size();
		System.out.println(firstRace.getName() + " plays against " + sr.getName());
	}
	
	public void setSquadMap() {
		this.squadMap.put("wizard", 1);
		this.squadMap.put("archer", 3);
		this.squadMap.put("warrior", 4);
	}
	
	public void createTroops() {
		HeroFactory hf = new HeroFactory();
		
		for (Race r: enemyRace) {
			for (String key: this.squadMap.keySet()) {
				for (int i = 1; i <= squadMap.get(key); i++) {
					Hero h = hf.createHero(r, key);
					String name = h.getRace().getName().substring(0,3) + "_" + h.getType() + Integer.toString(i);
					h.setName(name);
					System.out.println("unit " + h.getName() + " was created");
					this.troops.add(h);
				}
			}
		}
	}
	
	public void autoMove(Hero owner) {
		Random rand = new Random();
		if (owner.getSkillCount()>=2) {
			skn = rand.nextInt(owner.getSkillCount());
		} else {
			skn = 0;
		}
		Skill csk = owner.getSkill(skn);
		//ArrayList<Hero> targetList = new ArrayList<Hero>();
		//Collections.copy(troops, targetList);
		
		for (Hero target: this.troops) {
			if (owner.useSkillByID(skn, target)) {
				if (target.getHealth() <= 0) {
					this.troops.remove(target);
					//System.out.println(target.getName() + " was killed");
				}
				break;
			}
		}
	}
	
	public void randFight() {
		int attackers = 0;
		int defenders = 1;
		int movecounter = 1;
		boolean gameState = true;
		while (gameState){
			Race currentMove = enemyRace.get(attackers);
			System.out.println(" -  - - - - - - - - - - - - - - - - - - - - - - - - - ");
			System.out.println(movecounter + " in progress");
			System.out.print(currentMove.getName() + " is attacking ");
			System.out.println(enemyRace.get(defenders).getName() + " is defencing");
			int curTeam = 0;
			int rival = 0;
			for (int i = 0; i < troops.size(); i++) {
				Hero h = troops.get(i);
				//System.out.println("Potential attackers " + h.getType() + " belongs to " + h.getRace().getName());
				if (h.getRace().getName().equals(currentMove.getName())) {
					//System.out.println("attackers " + h.getType() + " belongs to " + h.getRace().getName());
					curTeam++;					
					autoMove(troops.get(i));
					rival++;
					if (rival <= 0) {
						//System.out.println("rival check");
						//System.out.println("There are no alive members in " + enemyRace.get(defenders).getName() + " squad");
						gameState = false;
						break;
					}
				}
			}
				if (curTeam <= 0) {
					//System.out.println("attackers");
					System.out.println("Currently no active members of " + currentMove.getName() + " squad");
					System.out.println(enemyRace.get(defenders).getName() + " has won the game");
					gameState = false;
					break;
				}
			if (movecounter >= 100) {
				System.out.println("infinity loop detected on " + movecounter + "move");
				break;
			}
			Collections.shuffle(this.troops);
			int tmp = attackers;
			attackers = defenders;
			defenders = tmp;
			movecounter++;
		}
	}
}
