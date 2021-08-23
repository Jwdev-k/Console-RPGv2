package main.rpg;

import java.io.IOException;
import java.util.Scanner;

import main.rpg.character.CharacterController;

public class RPG {
	
	private int accountid;

	private static Scanner sc = new Scanner(System.in);
	private static CharacterController cc = new CharacterController();

	public RPG(int accountid) throws IOException {
		super();
		this.accountid = accountid;
		var sb = new StringBuilder();
		sb.append("*******************************************\n");
		sb.append("Console RPGv2에 오신걸 환영합니다.");
		sb.append("\n해당 프로그램은 콘솔에 입력한 명령어로만 작동되는 게임 입니다.");
		sb.append("\n*******************************************");
		System.out.println(sb);
		cc.checkCharacter(accountid);
		inGameMenu();
	}

	private void inGameMenu() {
		while (true) {
			System.out.println("원햐시는 메뉴를 선택해 주세요.");
			System.out.println("1.던전입장, 2.상점, 3.게임종료 4.저장");
			var select = sc.nextInt();
			if (select == 1) {
				enterDungeon();
			}
			if (select == 2) {
				shop();
			}
			if (select == 3) {
				System.exit(0);
			}
			if (select == 4) {
				cc.info.setLevel(2);
				save();
			}
		}
	}

	private void save() {
		try {
			cc.saveCharacter(accountid);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void enterDungeon() {
		System.out.println("시작");

	}

	private void shop() {
		System.out.println("아이템 목록");

	}
}
