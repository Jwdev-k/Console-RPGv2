package main.rpg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("all")
public class main {

	private static Logger log = LoggerFactory.getLogger(main.class);
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		log.warn("start console Test");
		try {
			new LoginSystem();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
