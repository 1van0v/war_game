package war_game;
import war_game.Hero;

public class Enchanted implements State {
	
	Hero hero;
	
	public Enchanted(Hero h) {
		this.hero = h;
	}
	
	public void move() {
		//add this after auto skill chooser
		this.hero.setPF(1);
		this.hero.setState(this.hero.getMoved());
	}
	
	public void getSpell() {
		System.out.println("Error " + this.hero.getName() + " is applied the second spell");		
	}
	public void takeSpell() {
		System.out.println("A spell was removed from " + this.hero.getName());
		this.hero.setState(this.hero.getNormalState());
	}
}
