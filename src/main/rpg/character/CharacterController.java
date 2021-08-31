package main.rpg.character;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import main.rpg.DatabaseConfig;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CharacterController{

	public Character info;
	
	private static Scanner sc = new Scanner(System.in);

	private static SqlSession getSqlSession() throws Exception {
		String resource = "java-mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSessionFactory.getConfiguration().addMapper(CMapper.class);
		return sqlSessionFactory.openSession();
	}

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
			stat.executeUpdate("insert into characterInfo values(" + accountid + ",'" + name + "'," + 1 + "," + 0 + "," + 1 + ")");
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
		System.out.println(info.toString() + " 로드 완료.");
		return;
	}
	
	public void saveCharacter(int accountid) throws IOException {
		try {
			Connection conn = DatabaseConfig.getConnection();
			PreparedStatement ps = conn.prepareStatement("update characterInfo set name=?, level=?, exp=?, dungeonLevel=?  where AccountId=" + accountid);
			ResultSet rs = ps.executeQuery("SELECT * from characterInfo");
			while (rs.next()) {
				if (accountid != rs.getInt("AccountId")) {
					return;
				}
			}
			ps.setString(1, info.getName()); 
			ps.setInt(2, info.getLevel()); 
			ps.setDouble(3, info.getExp());
			ps.setInt(4, info.getDungeonLevel());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(info.toString() + " 저장 완료.");
	}

	public int checkDungeonLevel(int accountid) throws IOException {
		int level;
		try{
			var conn = DatabaseConfig.getConnection();
			Statement stat = conn.createStatement();
			ResultSet rs = stat.executeQuery("SELECT * from characterInfo");
			while (rs.next()) {
				if (accountid == rs.getInt("AccountId")) {
					level = rs.getInt("dungeonLevel");
					return level;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
