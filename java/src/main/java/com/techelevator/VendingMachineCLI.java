package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				File inputFile = new File("InitialInventory.txt");
				try {
					Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile());
					inputScanner.useDelimiter("\\|");

					String name;
					String stock;

					while(inputScanner.hasNext()){
						name = inputScanner.next();
						stock = inputScanner.next();
						System.out.println(name + " " + stock);
					}

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();

		File inputFile = new File("vendingmachine.csv");
		try {
			Scanner inputScanner = new Scanner(inputFile.getAbsoluteFile());
			inputScanner.useDelimiter(",");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
