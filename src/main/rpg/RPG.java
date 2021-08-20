package main.rpg;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import main.rpg.character.character;

import java.sql.Connection;

public class RPG {
	private int accountid;
	private character info;

	private static Scanner sc = new Scanner(System.in);

	public RPG(int accountid) throws IOException {
		super();
		this.accountid = accountid;
		var sb = new StringBuilder();
		sb.append("*******************************************\n");
		sb.append("Console RPGv2에 오신걸 환영합니다.");
		sb.append("\n해당 프로그램은 콘솔에 입력한 명령어로만 작동되는 게임 입니다.");
		sb.append("\n*******************************************");
		System.out.println(sb);
		checkCharacter();
	}

	private void checkCharacter() throws IOException {
		try {
			Connection conn = DatabaseConfig.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * from characterInfo");
			System.out.println("캐릭터 데이터 체크중...");
			while (rs.next()) {
				if (accountid == rs.getInt("AccountId")) {
					loadCharacter();
					return;
				}
			}
			System.out.println("캐릭터 정보를 불러올수 없습니다. 캐릭터를 생성해주세요.");
			System.out.print("캐릭터 이름을 입력해주세요 : ");
			String name = sc.next();	
			stat.executeUpdate("insert into characterInfo values(" + accountid + ",'" + name + "'," + 1 + "," + 0 + ")");
			System.out.println("캐릭터 생성완료.");
			loadCharacter();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void loadCharacter() throws IOException {
		try {
			Connection conn = DatabaseConfig.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * from characterInfo");
			while (rs.next()) {
				if (accountid == rs.getInt("AccountId")) {
					info = new character(rs.getString("name"), rs.getInt("level"), rs.getDouble("exp"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(info.toString());
		return;
	}
}
