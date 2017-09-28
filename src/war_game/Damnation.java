package war_game;

public class Damnation extends Skill implements SkillUsage {

	public Damnation(Hero o, String Title, double Damage) {
		owner = o;
		damage = Damage;
		title = Title;
		type = "damnation";
	}

	public boolean useSkill(Hero victim) {
		if (!victim.getRace().equals(this.owner.getRace()) && !this.owner.getAllies().contains(victim.getRace())) {
			victim.powerFactor += this.damage;
			victim.getState().takeSpell();
			owner.getState().move();
			System.out.print(this.owner.getName() + " revoke improvement from " + victim.getName());
			return true;
		} else {
			System.out.println(this.owner.getName() + " cannot use " + this.getTitle() + " against " + victim.getName());
			return false;
		}
	}
}
