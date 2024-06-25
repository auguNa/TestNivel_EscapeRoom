package Application;

import GameManagement.*;

import java.util.Scanner;

import static GameManagement.Inventory.findClue;
import static GameManagement.Inventory.findDecoration;

public class EscapeRoomApp {
    private static Scanner sc = new Scanner(System.in);
    private static Inventory inventory = new Inventory();

    static void createRoom() {
        System.out.print("Enter room name: ");
        String name = sc.nextLine();
        System.out.print("Enter difficulty (EASY, MEDIUM, HARD): ");
        Difficulty difficulty = Difficulty.valueOf(sc.nextLine().toUpperCase());
        Room room = new Room(name, difficulty);
        try {
            inventory.addRoom(room);
            System.out.println("Room added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void addClue() {
        System.out.print("Enter room ID to add clue to: ");
        int roomId = sc.nextInt();
        sc.nextLine();
        Room room = inventory.findRoom(roomId);
        if (room != null) {
            System.out.print("Enter clue name: ");
            String name = sc.nextLine();
            System.out.print("Enter clue price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter estimated time to solve (minutes): ");
            double estimatedTime = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter clue theme: ");
            String theme = sc.nextLine();
            IntriguingClue clue = new IntriguingClue(name, price, estimatedTime, theme);
            try {
                inventory.addClue(clue);
                room.addClue(clue);
                System.out.println("Clue added successfully: " + room.getName() +".");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("No room found with this id.");
        }
    }

    static void addDecoration() {
        System.out.print("Enter room id you want to use: ");
        int roomId = sc.nextInt();
        sc.nextLine();
        Room room = inventory.findRoom(roomId);
        if (room != null) {
            System.out.print("Enter decoration name: ");
            String name = sc.nextLine();
            System.out.print("Enter decoration price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.print("Enter decoration description: ");
            String description = sc.nextLine();
            System.out.print("Enter material type (WOOD, METAL, PLASTIC, GLASS): ");
            MaterialType materialType = MaterialType.valueOf(sc.nextLine().toUpperCase());
            DecorationObject decorationObject = new DecorationObject(name, price, description, materialType);
            try {
                inventory.addDecoration(decorationObject);
                room.addDecoration(decorationObject);
                System.out.println("Decoration added successfully to the room: " + room.getName() +".");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("No room found with this id.");
        }
    }

    static void listInventory() {
        System.out.println("All Clues:");
        inventory.getAllClues().forEach(System.out::println);
        System.out.println("All Decorations:");
        inventory.getAllDecorations().forEach(System.out::println);
        System.out.println("Total Inventory Value: " + inventory.getTotalInventoryValue());
    }

    static void deleteInventoryItem() {
        System.out.println("Enter room ID to remove item from: ");
        int roomId = sc.nextInt();
        Room room = inventory.findRoom(roomId);
        if (room != null) {
            System.out.println("Enter the type of item to be removed: 1. Clue || 2. Decoration");
            int itemType = sc.nextInt();
            sc.nextLine();
            System.out.println(("Enter item id: "));
            int itemId = sc.nextInt();
            switch (itemType) {
                case 1:
                    IntriguingClue clue = findClue(itemId);
                    if (clue != null) {
                        room.removeClue(clue.getId());
                        inventory.removeClue(clue.getId());
                        System.out.println("Clue successfully removed.");
                    } else {
                        System.out.println("No clue found with this id.");
                    }
                    break;
                case 2:
                    DecorationObject decorationObject = findDecoration(itemId);
                    if (decorationObject != null) {
                        room.removeDecoration(decorationObject.getId());
                        inventory.removeDecoration(decorationObject.getId());
                        System.out.println("Decoration successfully removed.");
                    } else {
                        System.out.println("No decoration found with this id.");
                    }
                    break;
                default:
                    System.out.println("Invalid option...");
            }
        } else {
            System.out.println("No room found with this id.");
        }
    }

    static void listRooms() {
        if (inventory.getAllRooms().isEmpty()) {
            System.out.println("No rooms found.");
        } else {
            inventory.getAllRooms().forEach(System.out::println);
        }
    }
}


