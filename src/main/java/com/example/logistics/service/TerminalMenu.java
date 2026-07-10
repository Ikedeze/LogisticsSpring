package com.example.logistics.service;


//import org.springframework.boot.CommandLineRunner;
//
//import java.util.Scanner;
//
//public class TerminalMenu implements CommandLineRunner {
//
//    // Inject your existing ShipmentService here
//    // private final ShipmentService shipmentService;
//
//    // For now, we use a basic constructor.
//    // Un-comment and add you service when you connect it!
//    public TerminalMenu() {
//        // this.shipmentService = shipmentService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Let the application boot logs finish printing before showing menu
//        new Thread(() -> {
//            try {
//                Thread.sleep(7000); // Wait for startup logs to settle
//                selectRunningMode();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }).start();
//    }
//
//    private void selectRunningMode() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("\n=================================================");
//        System.out.println("          SELECT APPLICATION RUNNING MODE        ");
//        System.out.println("=================================================");
//        System.out.println("1. Web Mode Only (Standard Server)");
//        System.out.println("2. Interactive Terminal Mode + Web Mode");
//        System.out.print("Choose mode (1-2): ");
//
//        String mode = scanner.nextLine();
//
//        if("2".equals(mode)){
//            System.out.println("\n--> Launching Logistics Management" +
//                    " Terminal...");
//            displayMenu(scanner);
//        } else {
//            System.out.println("\n--> Running in Web Mode Only. " +
//                    "Terminal loop skipped.");
//        }
//    }
//
//    private void displayMenu(Scanner scanner) {
//        boolean running = true;
//
//        while(running) {
//            System.out.println("\n========= LOGISTICS MANAGEMENT TERMINAL =========");
//            System.out.println("1. Create New Shipment");
//            System.out.println("2. Read / View Shipment Details");
//            System.out.println("3. Update Shipment Status");
//            System.out.println("4. Delete a Shipment");
//            System.out.println("5. Admin Search (Secure)");
//            System.out.println("6. Exit Terminal Mode");
//            System.out.print("Choose an option (1-6): ");
//
//            String choice = scanner.nextLine();
//
//            switch (choice) {
//                case "1" -> System.out.println("\n[EXEC] Creating a new shipment...");
//                case "2" -> System.out.println("\n[EXEC] Reading shipment details...");
//                case "3" -> System.out.println("\n[EXEC] Updating data...");
//                case "4" -> System.out.println("\n[EXEC] Deleting data...");
//                case "5" -> {
//                    System.out.println("\n========= ADMIN SEARCH =========");
//                    System.out.print("Enter Admin Username: ");
//                    String adminUser = scanner.nextLine();
//                    System.out.print("Enter Admin Password: ");
//                    String adminPass = scanner.nextLine();
//
//                    System.out.println("\\n[EXEC] Verifying admin " +
//                            "credentials in MongoDB Atlas...");
//                }
//                case "6" -> {
//                    System.out.println("\nExiting Terminal " +
//                            "Menu. Web Server remains " +
//                            "active.");
//                    running = false;
//                }
//                default -> System.out.println("\n" +
//                        "Invalid choice! Please select a" +
//                        " valid number (1-6).");
//            }
//        }
//    }
//}
