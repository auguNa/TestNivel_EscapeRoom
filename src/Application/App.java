package Application;

import java.util.Scanner;

import static Application.EscapeRoomApp.*;

public class App {
    public void start() {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("ESCAPE ROOM");
            System.out.println("1.- Create Room");
            System.out.println("2.- Add Intriguing Clue");
            System.out.println("3.- Add Decoration Room's");
            System.out.println("4.- List Inventory");
            System.out.println("5.- Delete Inventory Item");
            System.out.println("0.- End of Application");
            System.out.println("Enter your option: ");

            option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    createRoom();
                    break;
                case 2:
                    addClue();
                    break;
                case 3:
                    addDecoration();
                    break;
                case 4:
                    listInventory();
                    break;
                case 5:
                    deleteInventoryItem();
                    break;
                case 0:
                    System.out.println("Application ended.. ");
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        } while (option != 0);
    }
}