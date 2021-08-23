package main.rpg;

import java.io.IOException;
import java.util.Scanner;

import main.rpg.character.CharacterController;

public class RPG {

	private static Scanner sc = new Scanner(System.in);
	private static CharacterController cc = new CharacterController();

	public RPG(int accountid) throws IOException {
		super();
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
			System.out.println("1.던전입장, 2.상점, 3.게임종료");
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
		}
	}

	private void enterDungeon() {
		System.out.println("시작");

	}
	
	private void shop() {
		// TODO Auto-generated method stub
		
	}
}