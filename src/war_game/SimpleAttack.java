package war_game;
import war_game.Hero;

public class SimpleAttack extends Skill implements SkillUsage{
	
	public SimpleAttack(Hero o, String Title, int Damage) {
		owner = o;
		damage = Damage;
		title = Title;

	}
	
	public boolean useSkill(Hero victim) {
		if (!victim.getRace().equals(this.owner.getRace()) || !this.owner.getAllies().contains(victim.getRace())) {
			victim.health -= this.damage * this.owner.getPF();
			System.out.print(this.owner.getType() + " attacked " + victim.getType() + " and ");
			System.out.println(this.damage + " health was taken" );
			if (victim.health <= 0) {
				System.out.println(victim.getType() + " was killed by "+ this.owner.getType());
			}
			return true;
		} else {
			System.out.println(this.owner + " cannot use " + this.getTitle() + " against " + victim.getName());
			return false;
		}
	}
}
