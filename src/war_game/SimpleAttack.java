package war_game;
import war_game.Hero;

public class SimpleAttack extends Skill{

	private Hero owner;
	private double damage;
	
	public SimpleAttack(Hero owner, double damage) {
		super(owner, damage);
		
	}
	
	public Race getAim() {
		return this.owner.getRace();
	}
	
	
}
