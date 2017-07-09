package war_game;
import java.util.ArrayList;

public class Race {
	private ArrayList<Race> allies;
	private String name;
	
	public Race(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAlly(Race ally) {
		this.allies.add(ally);
	}
	
	public ArrayList<Race> getAlly() {
		return this.allies;
	}

}
