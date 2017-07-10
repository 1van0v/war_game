package war_game;
import war_game.Hero;

public abstract class Skill {

	private Hero victim;
	private Hero owner;
	private double damage;
	
	public Skill(Hero h, double damage) {
		this.damage = damage;
		this.owner = h;
	}
	
	public Skill(Hero owner) {
		this.owner = owner;
	}
	public void useSkill(Hero v) {
		victim = v;
		victim.health -= this.damage;
		System.out.print(this.owner.getType() + " attacked " + victim.getType() + " and ");
		System.out.println(this.damage + " health was taken" );
		if (victim.health <= 0) {
			System.out.println(victim.getType() + " was killed by "+ this.owner.getType());
		}
	}
	public Hero getOwner(){
		return this.owner;
	}
}
