package war_game;
import war_game.Hero;

public class NormalState implements State{
	
	Hero hero;
	
	public NormalState(Hero h) {
		this.hero = h;
	}
	
	public void move() {
		//add this after auto skill chooser
		this.hero.setState(this.hero.getMoved());
	}
	
	public void getSpell() {
		System.out.println(this.hero.getName() + " is under a spell ");
		this.hero.setState(this.hero.getSpell());		
	}
	public void takeSpell() {
		System.out.println("Error " + " someone has tried to revoke a spell from " + this.hero.getName());
	}
}
