package mariam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class TicketingSystem {
    private Map<String, Category> categories;
    private List<Ticket> tickets;

    public TicketingSystem() {
        categories = new HashMap<>();
        tickets = new ArrayList<>();
    }

    public void loadCategories(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length > 0) {
                String categoryName = parts[0].trim();
                Category category = new Category(categoryName);
                for (int i = 1; i < parts.length; i++) {
                    category.addIssue(parts[i].trim());
                }
                categories.put(categoryName, category);
            }
        }
        reader.close();
    }

    public void createTicket() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select Category:");
        int i = 1;
        for (String categoryName : categories.keySet()) {
            System.out.println(i + ". " + categoryName);
            i++;
        }
        int categoryChoice = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        String selectedCategory = (String) categories.keySet().toArray()[categoryChoice - 1];
        Category category = categories.get(selectedCategory);

        System.out.println("Select Issue:");
        i = 1;
        for (String issue : category.getIssues()) {
            System.out.println(i + ". " + issue);
            i++;
        }
        int issueChoice = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        String selectedIssue = category.getIssues().get(issueChoice - 1);

        System.out.println("Enter Description:");
        String description = scanner.nextLine();

        Ticket ticket = new Ticket(selectedCategory, selectedIssue, description);
        tickets.add(ticket);

        System.out.println("Ticket Created Successfully!");
        System.out.println(ticket);
    }

    public void showTickets() {
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
            System.out.println("--------------");
        }
    }

    public static void main(String[] args) {
        TicketingSystem system = new TicketingSystem();
        try {
            system.loadCategories("categories.txt");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Create Ticket");
                System.out.println("2. Show Tickets");
                System.out.println("3. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline

                switch (choice) {
                    case 1:
                        system.createTicket();
                        break;
                    case 2:
                        system.showTickets();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice. Try again.");
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to load categories: " + e.getMessage());
        }
    }
}
