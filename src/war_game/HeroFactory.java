package war_game;
import java.util.ArrayList;
import war_game.Hero;
import war_game.Race;
import war_game.Skill;

public class HeroFactory {

	Hero hero;
	SkillFactory sf;
	ArrayList<Skill> skills;
	
	public Hero createHero(Race r, String type) {
		
		Hero hero = choseHero(r, type);
		choseSkill(hero);
		return hero;
	}
	
	public void choseSkill(Hero h) {
		sf = new SkillFactory();
		if (h.getRace().getName().equals("elves")) {
			if (hero.getType().equals("wizard")) {
				sf.createSkill(hero, "magic", 10);
				sf.createSkill(hero, "improvement", 0.5);
			} else if (hero.getType().equals("archer")) {
				sf.createSkill(hero, "bow", 7);
				sf.createSkill(hero, "knife", 3);
			} else if (hero.getType().equals("warrior")) {
				sf.createSkill(hero, "sword" , 15);
			}
		} else if (h.getRace().getName().equals("human")) {
			if (hero.getType().equals("wizard")){
				sf.createSkill(hero, "magic", 4);
				sf.createSkill(hero, "improvement", 0.5);
			} else if (hero.getType().equals("archer")) {
				sf.createSkill(hero, "crossbow", 5);
				sf.createSkill(hero, "knife", 3);
			} else if (hero.getType().equals("warrior")) {
				sf.createSkill(hero, "sword" , 18);
			}
		} else if (h.getRace().getName().equals("orcs")) {
			if (hero.getType().equals("shaman")){
				sf.createSkill(hero, "damnation", -0.5);
				sf.createSkill(hero, "improvement", 0.5);
			} else if (hero.getType().equals("archer")) {
				sf.createSkill(hero, "bow", 3);
				sf.createSkill(hero, "blade", 2);
			} else if (hero.getType().equals("goblin")) {
				sf.createSkill(hero, "bludgeon" , 20);
			}
		} else if (h.getRace().getName().equals("spirits")) {
			if (hero.getType().equals("necromancer")){
				sf.createSkill(hero, "disease", -0.5);
				sf.createSkill(hero, "something", 5);
			} else if (hero.getType().equals("hunter")) {
				sf.createSkill(hero, "bow", 4);
				sf.createSkill(hero, "blade", 2);
			} else if (hero.getType().equals("zombie")) {
				sf.createSkill(hero, "spear" , 18);
			}
		}
	}
	
	public Hero choseHero (Race r, String type) {
		//System.out.println(type + " of race " + r.getName() + " is creating" );
		if (r.getName().equals("elves")) {
			if (type.equals("wizard")) {
				hero = new Hero(r, type);
			} else if (type.equals("archer")) {
				hero = new Hero(r, type);
			} else if (type.equals("warrior")) {
				hero = new Hero(r, type);
			}
		} else if (r.getName().equals("human")) {
			if (type.equals("wizard")) {
				hero = new Hero(r, type);
			} else if (type.equals("archer")) {
				hero = new Hero(r, "archer");
			} else if (type.equals("warrior")) {
				hero = new Hero(r, type);
			}
		} else if (r.getName().equals("orcs")) {
			if (type.equals("wizard")) {
				hero = new Hero(r, "shaman");
			} else if (type.equals("archer")) {
				hero = new Hero(r, type);
			} else if (type.equals("warrior")) {
				hero = new Hero(r, "goblin");
			}
		} else if (r.getName().equals("spirits")) {
			if (type.equals("wizard")) {
				hero = new Hero(r, "necromancer");
			} else if (type.equals("archer")) {
				hero = new Hero(r, "hunter");
			} else if (type.equals("warrior")) {
				hero = new Hero(r, "zombie");
			}
		}
		return hero;
	}
}
