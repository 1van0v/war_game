package war_game;

public class Illness extends Skill implements SkillUsage {

	public Illness(Hero o, String Title, double Damage) {
		owner = o;
		damage = Damage;
		title = Title;
		type = "attack";
	}

	public boolean useSkill(Hero victim) {
		if (!victim.getRace().equals(this.owner.getRace()) && !this.owner.getAllies().contains(victim.getRace())) {
			victim.powerFactor += this.damage;
			owner.getState().move();
			System.out.print(this.owner.getName() + " infected " + victim.getName());
			return true;
		} else {
			//System.out.println(this.owner.getName() + " cannot use " + this.getTitle() + " against " + victim.getName());
			return false;
		}
	}
}
