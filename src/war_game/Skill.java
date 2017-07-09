package war_game;
import war_game.Hero;

public abstract class Skill {

	private Hero victim;
	private Hero owner;
	private double damage;
	
	public Skill(Hero owner) {
		this.owner = owner;
	}
	public void useSkill(Hero v) {
		victim = v;
		victim.health -= this.damage;
		System.out.print(this.owner + " attacked " + victim + " and ");
		System.out.println(this.damage + " health was taken" );
	}
}
