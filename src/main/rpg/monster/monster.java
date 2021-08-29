package main.rpg.monster;

import java.util.Objects;

public class monster {
	private String name;
	private int level;
	private int hp;
	private int mp;
	private double dropexp;

	public monster(String name, int level, int hp, int mp, double dropexp) {
		super();
		this.name = name;
		this.level = level;
		this.hp = hp;
		this.mp = mp;
		this.dropexp = dropexp;
	}

	@Override
	public String toString() {
		return "monster [name=" + name + ", level=" + level + ", hp=" + hp + ", mp=" + mp + ", dropexp=" + dropexp
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
