package com.main.ui;

import java.util.Scanner;

public interface Menu {
	public Menu advance();
	
	public void display();
	
	public Menu previousMenu();
	
	public Scanner getScanner();
	
	public void setScanner(Scanner scan);

	public void setWelcome(Menu welcome);
}
