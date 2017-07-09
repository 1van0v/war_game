package war_game;
import war_game.Race;
import war_game.Hero;
import java.util.ArrayList;
public class Game {

	String[] racesNames;
	ArrayList<Race> RacesList;
	Game game1;
	
	public static void main(String[] args) {
		
		 Game newGame = new Game({"elves", "human", "orcs", "spirits"});
	}

	public Game(String[] names) {
		this.racesNames = names;
		ArrayList<Race> Races = new ArrayList<Race>();
		for (String name: racesNames) {
			Races.add(new Race(name));
		}
		this.RacesList=Races;
		
	}
	
}
