package main.rpg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class LoginSystem {

	private static Scanner sc = new Scanner(System.in);
	private static boolean check = true;

	public LoginSystem() throws IOException {
		super();
		// TODO Auto-generated constructor stub
		if (dbConnect() != null) {
			System.out.println("로그인 시스템 가동.");
			menu();
		}
	}

	private static Connection dbConnect() {
		try {
			Connection conn = DatabaseConfig.getConnection();
			//System.out.println("데이터베이스 접속 완료");
			return conn;
		} catch (SQLException e) {
			System.out.println("데이터베이스를 찾을수 없습니다.");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void menu() throws IOException {
		while (check) {
			var sb = new StringBuilder();
			sb.append("*******************************************\n");
			sb.append("1. 회원가입 , 2. 로그인, 3. 비밀번호 찾기, 4. 종료.");
			sb.append("\n*******************************************");
			System.out.println(sb.toString());
			int select = sc.nextInt();
			if (select == 1) {
				registerAccount();
			}
			if (select == 2) {
				login();
			}
			if (select == 3) {
				getPassword();
			}
			if (select == 4) {
				System.exit(0);
			}
		}
	}

	private static void getPassword() {
		try {
			Statement stat = dbConnect().createStatement();
			ResultSet rs = stat.executeQuery("SELECT * from account");
			System.out.println("비밀번호를 찾으실 계정 ID를 입력해 주세요.");
			String id = sc.next();
			while (rs.next()) {
				if (rs.getString("id").equals(id)) {
					System.out.println("해당 ID의 비밀번호는 " + rs.getString("password").toString() + "입니다.");
					return;
				} else {
					System.out.println("존재 하지 않는 계정입니다.");
					return;
				}
			}
		} catch (SQLException e) {
			System.out.println("데이터베이스를 찾을수 없습니다.");
			e.printStackTrace();
		}
	}
	
	private static void registerAccount() {
		try {
			Statement stat = dbConnect().createStatement();
			ResultSet rs = stat.executeQuery("SELECT * from account");
			System.out.println("사용할 ID를 입력해주세요");
			String id = sc.next();
			while (rs.next()) {
				if (rs.getString("id").equals(id)) {
					System.out.println("이미 사용중인 아이디 입니다.");
					return;
				}
			}
			System.out.println("사용할 패스워드를 입력해주세요");
			String password = sc.next();
			stat.executeUpdate("insert into Account values('"+ 0 + "','" + id + "','" + password + "')");
		} catch (SQLException e) {
			System.out.println("데이터베이스를 찾을수 없습니다.");
			e.printStackTrace();
		}
		System.out.println("회원가입 성공");
	}

	private static void login() throws IOException {
		System.out.println("ID를 입력해주세요");
		String id = sc.next();
		System.out.println("Password를 입력해주세요");
		String password = sc.next();
		int accountId = 0;
		try {
			Statement stat = dbConnect().createStatement();
			ResultSet rs2 = stat.executeQuery("SELECT * from Account");
			while (rs2.next()) {
				if (!rs2.getString("id").equals(id) && rs2.isLast()) {
					System.out.println("아이디를 찾을수 없습니다.");
					return;
				}
				if (!rs2.getString("Password").equals(password) && rs2.isLast()) {
					System.out.println("패스워드가 틀렸습니다.");
					return;
				}
				accountId = rs2.getInt("AccountId");
			}
			rs2.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스를 찾을수 없습니다.");
			e.printStackTrace();
		}
		check = false;
		System.out.println("*로그인 성공*");
		new RPG(accountId);
	}

}
