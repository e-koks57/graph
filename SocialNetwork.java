import java.util.*;

public class SocialNetwork {

    static class Graph {
        private Map<String, List<String>> adjList = new HashMap<>();

        void addUser(String user) {
            if (!adjList.containsKey(user)) {
                adjList.put(user, new ArrayList<String>());
            }
        }

        void addConnection(String user1, String user2) {
            if (adjList.containsKey(user1)) {
                adjList.get(user1).add(user2);
            }
            if (adjList.containsKey(user2)) {
                adjList.get(user2).add(user1);
            }
        }

        List<String> getConnections(String user) {
            if (adjList.containsKey(user)) {
                return adjList.get(user);
            } else {
                return new ArrayList<String>();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph socialGraph = new Graph();

        while (true) {
            System.out.println("1. Add User");
            System.out.println("2. Add Connection");
            System.out.println("3. View Connections");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 4) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String user = scanner.nextLine();
                    socialGraph.addUser(user);
                    System.out.println("User added.");
                    break;
                case 2:
                    System.out.print("Enter first username: ");
                    String user1 = scanner.nextLine();
                    System.out.print("Enter second username: ");
                    String user2 = scanner.nextLine();
                    socialGraph.addConnection(user1, user2);
                    System.out.println("Connection added.");
                    break;
                case 3:
                    System.out.print("Enter username: ");
                    String userToView = scanner.nextLine();
                    System.out.println("Connections: " + socialGraph.getConnections(userToView));
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
