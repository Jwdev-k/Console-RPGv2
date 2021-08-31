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

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp -= hp;
		if (this.hp < 0) {
			this.hp = 0;
		}
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public double getDropexp() {
		return dropexp;
	}

	public void setDropexp(double dropexp) {
		this.dropexp = dropexp;
	}
}
