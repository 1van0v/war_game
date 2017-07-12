package war_game;
import war_game.Race;
import war_game.SimpleAttack;
import java.util.ArrayList;
import war_game.NormalState;
import war_game.Enchanted;
import war_game.Moved;

public class Hero {
	private Race race;
	private String type;
	public double health;
	private String name;
	public ArrayList<Skill> myskill;
	private double powerFactor;
	private State normal;
	private State enchanted;
	private State moved;
	private State state;

	public Hero(Race race, String type) {
		this.race = race;
		this.type = type;
		this.health = 100;
		this.myskill = new ArrayList<Skill>();
		this.powerFactor = 1.0;
		normal = new NormalState(this);
		enchanted = new Enchanted(this);
		moved = new Moved(this);
		this.state = normal;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
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
	
	public double getPF() {
		return this.powerFactor;
	}
	
	public void setPF(double pf) {
		this.powerFactor = pf;
	}
	
	public State getNormalState() {
		return normal;
	}
	
	public State getSpell() {
		return enchanted;
	}
	
	public State getState() {
		return state;
	}
	
	public State getMoved() {
		return moved;
	}
	
	public void setState(State st) {
		this.state = st;
	}
}
