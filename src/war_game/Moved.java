package war_game;

public class Moved implements State {
	
	Hero hero;
	
	public Moved(Hero h) {
		this.hero = h;
	}
	
	public void move() {
		//add this after auto skill chooser
		System.out.println("Error " + this.hero.getName() + " has already used a move in this round");
	}
	
	public void getSpell() {
		System.out.println("Error " + this.hero.getName() + " is put a spell before reset counters");		
	}
	
	public void takeSpell() {
		System.out.println("Error " + " someone has tried to revoke a spell from " + this.hero.getName());
	}
}
