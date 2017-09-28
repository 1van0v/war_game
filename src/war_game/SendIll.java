package war_game;

public class SendIll extends Skill implements SkillUsage {
	
	public SendIll(Hero o, String Title, double Damage) {
		owner = o;
		damage = Damage;
		title = Title;
		type = "improvement";
	}

	public boolean useSkill(Hero ally) {
		if (!ally.getRace().equals(this.owner.getRace()) && !this.owner.getAllies().contains(ally.getRace())) {
			ally.powerFactor += this.damage;
			//System.out.println(ally.powerFactor);
			ally.getState().getSpell();
			System.out.println(this.owner.getName() + " infected " + ally.getName());
			return true;
		} else {
			//System.out.println(this.owner.getName() + " cannot use " + this.getTitle() + " against " + ally.getName());
			return false;
		}
	}
}

