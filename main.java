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