package main.rpg.character;

public class Character {
	private String name;
	private int level;
	private double exp;
	private int dungeonLevel;

	public Character(String name, int level, double exp, int dungeonLevel) {
		super();
		this.name = name;
		this.level = level;
		this.exp = exp;
		this.setDungeonLevel(dungeonLevel);
	}

	@Override
	public String toString() {
		return "캐릭터 정보 [이름= " + name + ", 레벨= " + level + ", 경험치= " + exp + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getExp() {
		return exp;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}

	public int getDungeonLevel() {
		return dungeonLevel;
	}

	public void setDungeonLevel(int dungeonLevel) {
		this.dungeonLevel = dungeonLevel;
	}
}