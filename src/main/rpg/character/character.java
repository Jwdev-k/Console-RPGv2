package main.rpg.character;

public class Character {
	private int AccountId;
	private String name;
	private int level;
	private double exp;
	private int dungeonLevel;


	public Character(int Accountid, String name, int level, double exp, int dungeonLevel) {
		super();
		this.AccountId = Accountid;
		this.name = name;
		this.level = level;
		this.exp = exp;
		this.dungeonLevel = dungeonLevel;
	}

	@Override
	public String toString() {
		return "캐릭터 정보 [이름= " + name + ", 레벨= " + level + ", 경험치= " + exp + "]";
	}

	public int getAccountId() {
		return AccountId;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public double getExp() {
		return exp;
	}

	public int getDungeonLevel() {
		return dungeonLevel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setExp(double exp) {
		this.exp = exp;
	}

	public void setDungeonLevel(int dungeonLevel) {
		this.dungeonLevel = dungeonLevel;
	}
}
