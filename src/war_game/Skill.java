package war_game;
//import war_game.Hero;
import war_game.NormalState;

public abstract class Skill {
	
	State normal;
	State enchanted;
	public Hero owner;
	public double damage;
	public String title;
	State state;
	
	public Skill() {
		normal = new NormalState(this);
		enchanted = new 
	}
	
	abstract boolean useSkill(Hero v);
	
	public Hero getOwner(){
		return this.owner;
	}
	
	public String getTitle() {
		return this.getTitle();
	}
}
