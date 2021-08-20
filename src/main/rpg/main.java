package main.rpg;

import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@SuppressWarnings("unused")
public class main {
	
	private static Log log = LogFactory.getLog(main.class);
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		log.warn("start console Test");
		new LoginSystem();
	}
}
