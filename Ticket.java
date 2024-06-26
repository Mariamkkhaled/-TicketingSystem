package mariam;

    public class Ticket {
        private static int idCounter = 0;
        private int id;
        private String category;
        private String issue;
        private String description;

        public Ticket(String category, String issue, String description) {
            this.id = ++idCounter;
            this.category = category;
            this.issue = issue;
            this.description = description;
        }

        @Override
        public String toString() {
            return "Ticket ID: " + id + "\nCategory: " + category + "\nIssue: " + issue + "\nDescription: " + description;
        }
    }


