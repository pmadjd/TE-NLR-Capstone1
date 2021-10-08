package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String SUB_MENU_OPTION_FEED_MONEY = "Feed Money";
	private static final String SUB_MENU_OPTION_SELECT_PRODUCT = "Select Product";
	private static final String SUB_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = {SUB_MENU_OPTION_FEED_MONEY, SUB_MENU_OPTION_SELECT_PRODUCT, SUB_MENU_OPTION_FINISH_TRANSACTION};
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	VendingMachine currentMachine = new VendingMachine();

	private Menu menu;

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {

				handleDisplayVendingItems();

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

				while (true) {

					String nextChoice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
					if (nextChoice.equals(SUB_MENU_OPTION_FEED_MONEY)) {
						System.out.println("How much would you like to deposit? ($1 / $2 / $5 / $10)");
						Scanner input = new Scanner(System.in);
						String userInput = input.nextLine();
						int deposit = Integer.parseInt(userInput);

						currentMachine.feedMoney(deposit);

					} else if (nextChoice.equals(SUB_MENU_OPTION_SELECT_PRODUCT)) {

					} else if (nextChoice.equals(SUB_MENU_OPTION_FINISH_TRANSACTION)) {
						break;

					}
				}
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}
		}
	}

	private void handleDisplayVendingItems(){
		for(String slot : currentMachine.getSlots()){
			System.out.printf("%-5s %s\n", slot, currentMachine.getItem(slot));
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
