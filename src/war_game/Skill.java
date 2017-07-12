package war_game;
import war_game.Hero;

public abstract class Skill {
	
	public Hero owner;
	public double damage;
	public String title;
	public String type;
		
	abstract boolean useSkill(Hero v);
	
	public Hero getOwner(){
		return this.owner;
	}
	
	public String getTitle() {
		return this.title;
	}
	public String getType() {
		return this.type;
	}
}
