package war_game;
import war_game.Race;
import war_game.SimpleAttack;
import java.util.ArrayList;

public class Hero {
	private Race race;
	private String type;
	public double health;
	public ArrayList<Skill> myskill;

	public Hero(Race race, String type) {
		this.race = race;
		this.type = type;
		this.health = 100;
		this.myskill = new ArrayList<Skill>();
	}
	
	public double getHealth() {
		return this.health;
	}
	
	public String getType() {
		return this.type;
	}
	
	public ArrayList<Race> getAllies() {
		return this.race.getAlly();
	}
	
	public Race getRace() {
		return this.race;
	}
	
	public void addSkill(Skill s) {
		this.myskill.add(s);
	}
	
	public void useSkillByID(int n, Hero aim) {
		Skill currentSkill = this.myskill.get(n);
		currentSkill.useSkill(aim);
	}
	
}
