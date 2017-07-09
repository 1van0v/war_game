package war_game;
import war_game.Race;
import war_game.Skill;
import java.util.ArrayList;

public abstract class Hero {
	private Race race;
	private String type;
	public double health;

	public Hero(Race race, String type) {
		this.race = race;
		this.type = type;
		this.health = 100;
	}
	
	private double getHealth() {
		return this.health;
	}
	
	private ArrayList<Race> getAllies() {
		return this.race.getAlly();
	}
	
	private Race getRace() {
		return this.race;
	}
}
