package main.rpg;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("all")
public class main {

	private static Log log = LogFactory.getLog(main.class);
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
