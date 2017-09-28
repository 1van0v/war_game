package war_game;

public class SkillFactory {

	Skill sk;
	
	public void createSkill(Hero owner, String title, double damage) {
		if (title.equals("improvement")) {
			sk = new Improvement(owner, title, damage);
			owner.addSkill(sk);
		} else if (title.equals("damnation")) {
			sk = new Damnation(owner, title, damage);
			owner.addSkill(sk);
		} else if (title.equals("disease")) {
			sk = new SendIll(owner, title, damage);
		} else {
			sk = new SimpleAttack(owner, title, damage);
			owner.addSkill(sk);
		} 
	}
}
