package main.rpg;

import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("all")
public class main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("start console Test");
		try {
			new LoginSystem();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
