package main.rpg.character;

public class character {
	private String name;
	private int level;
	private double exp;

	public character(String name, int level, double exp) {
		super();
		this.name = name;
		this.level = level;
		this.exp = exp;
	}

	@Override
	public String toString() {
		return "character [name=" + name + ", level=" + level + ", exp=" + exp + "]";
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
}
