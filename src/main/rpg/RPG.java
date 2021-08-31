package main.rpg;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import main.rpg.character.Character;
import main.rpg.character.CharacterController;
import main.rpg.monster.monster;

public class RPG {
	
	private int accountid;

	private static Scanner sc = new Scanner(System.in);
	private static CharacterController cc = new CharacterController();

	public RPG(int accountid) throws IOException, InterruptedException {
		super();
		this.accountid = accountid;
		var sb = new StringBuilder();
		sb.append("*******************************************\n");
		sb.append("Console RPGv2에 오신걸 환영합니다.");
		sb.append("\n해당 프로그램은 콘솔에 입력한 명령어로만 작동되는 게임 입니다.");
		sb.append("\n*******************************************");
		System.out.println(sb.toString());
		cc.checkCharacter(accountid);
		inGameMenu();
	}

	private void inGameMenu() throws IOException, InterruptedException {
		while (true) {
			System.out.println("원햐시는 메뉴를 선택해 주세요.");
			System.out.println("1.던전입장, 2.상점, 3.내정보 4.게임종료 5.저장");
			var select = sc.nextInt();
			if (select == 1) {
				enterDungeon();
			}
			if (select == 2) {
				shop();
			}
			if (select == 3) {
				try {
					System.out.println(cc.getCharacterData().toString());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (select == 4) {
				System.exit(0);
			}
			if (select == 5) {
				save();
			}
		}
	}

	private void save() throws IOException {
		cc.saveCharacter(accountid);
	}

	private void enterDungeon() throws IOException, InterruptedException {
		switch (cc.checkDungeonLevel(accountid)) {
			case 1:
				var mob = new monster("슬라임",  1, 5, 0, 10);
				System.out.println(mob.getName() + " 이/가 등장 했다!");
				while (mob.getHp() > 0) {
					System.out.println("1.공격");
					int select = sc.nextInt();
					if (select == 1) {
						var damage = (int) (Math.random() * 10);
						System.out.println(mob.getName() + "에게 공격을 했다.!");
						Thread.sleep(1000);
						System.out.println(damage + "데미지를 받았다.");
						mob.setHp(damage);
						Thread.sleep(1000);
						if (mob.getHp() != 0) {
							System.out.println(mob.getName() + "의 HP가" + mob.getHp() + "이 되었다.");
						} else {
							System.out.println(mob.getName() + "이/가 죽었다.");
							Thread.sleep(1000);
							System.out.println("경험치가" + mob.getDropexp() + "만큼 올랐다!");
							cc.info.setExp(mob.getDropexp());
							Thread.sleep(1000);
							System.out.println("클리어! 던전 레벨이 올랐다.");
							cc.info.setDungeonLevel(2);
							System.out.println("현재레벨: " + cc.info.getDungeonLevel());
							save();
							return;
						}
						Thread.sleep(1000);
						System.out.println(mob.getName() + "이/가 공격을했다.");
						Thread.sleep(1000);
						System.out.println(damage + "를 받았다!");
					}
				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
		}
	}

	private void shop() {
		System.out.println("아이템 목록");
	}
}
