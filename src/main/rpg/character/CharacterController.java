package main.rpg.character;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import main.rpg.DatabaseConfig;

public class CharacterController {
	
	public Character info;
	
	private static Scanner sc = new Scanner(System.in);

	public void checkCharacter(int accountid) throws IOException {
		try {
			Connection conn = DatabaseConfig.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * from characterInfo");
			System.out.println("캐릭터 데이터 체크중...");
			while (rs.next()) {
				if (accountid == rs.getInt("AccountId")) {
					loadCharacter(accountid);
					return;
				}
			}
			System.out.println("캐릭터 정보를 불러올수 없습니다. 캐릭터를 생성해주세요.");
			System.out.print("캐릭터 이름을 입력해주세요 : ");
			String name = sc.next();	
			stat.executeUpdate("insert into characterInfo values(" + accountid + ",'" + name + "'," + 1 + "," + 0 + ")");
			System.out.println("캐릭터 생성완료.");
			loadCharacter(accountid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void loadCharacter(int accountid) throws IOException {
		try {
			Connection conn = DatabaseConfig.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * from characterInfo");
			while (rs.next()) {
				if (accountid == rs.getInt("AccountId")) {
					info = new Character(rs.getString("name"), rs.getInt("level"), rs.getDouble("exp"), rs.getInt("dungeonLevel"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(info.toString() + "로드 완료.");
		return;
	}
}
