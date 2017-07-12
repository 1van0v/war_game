package war_game;
import war_game.Hero;

public class SimpleAttack extends Skill implements SkillUsage{
			
	public SimpleAttack(Hero o, String Title, double Damage) {
		owner = o;
		damage = Damage;
		title = Title;
		type = "attack";
	}
	
	public boolean useSkill(Hero victim) {
		if (!victim.getRace().equals(this.owner.getRace()) && !this.owner.getAllies().contains(victim.getRace())) {
			victim.health -= this.damage * this.owner.getPF();
			System.out.print(this.owner.getName() + " attacked " + victim.getName() + " and ");
			System.out.println(this.damage + " health was taken" );
			if (victim.health <= 0) {
				System.out.println(victim.getName() + " was killed by "+ this.owner.getName());
			}
			return true;
		} else {
			System.out.println(this.owner.getName() + " cannot use " + this.getTitle() + " against " + victim.getName());
			return false;
		}
	}
}
