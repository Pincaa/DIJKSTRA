import java.util.*;

public class Graph {
    Scanner scan = new Scanner(System.in); //scanner object to take input

    public class Node{
        //making a new class to store the node
        String key; //the name of the node later
        int weight = 999; //setting initial distance as infinity for all nodes

        public void setKey(String input) {
            //making a method to store the input into the node key
            this.key = input;
        }
    }

    public class Connection{
        //making a new class to store connection between each node
        Node node1; //first node
        Node node2; //second node
        int distance; //direct distance between them
    }

    public void inputNode(int n, ArrayList<Node> graph) {
        //method to take n number of input as a node inside the arrayList
        for (int i = 0; i < n; i++) {
            Node node = new Node(); //making new node
            System.out.println("Give the name!"); //command to request input to the user
            node.key = scan.next(); //set the key or node name by the taken input
            graph.add(node); //adding the node into the array
        }
    }

    Node getNode(String input, ArrayList<Node> sourceNode) {
        //used inside the next method
        Node notFound = new Node();
        notFound.key = "Node not found"; //in case there is user error at input
        //EXCEPTIONS IS EXPECTED IF I ALREADY LEARNED IT PERFECTLY!!!!!!!!
        //method to take the input as string and match the input with the index of node inside array
        for(Node element : sourceNode) {
            //loop that will go through all the element of array and return the node which has same key
            if (element.key.equalsIgnoreCase(input)) {
                return element;
            }
        }
        return notFound;
    }

    public void connect(ArrayList<Node> sourceNode, ArrayList<Connection> connections) {
        for(Node element : sourceNode) {
            //loop that will go through all element and store the connection inside connection array
            System.out.println("How many connections does node " + element.key + " has?");

            int n = scan.nextInt(); //take input to know how many connection will it have

            for (int i = 0; i<n; i++) {
                Connection connection = new Connection();
                //loop that will take n number of connection as input and save it in array
                connection.node1 = element;
                System.out.print("Name of connected node: ");
                connection.node2 = getNode(scan.next(), sourceNode);
                System.out.print("Number of distance between those nodes: ");
                connection.distance = scan.nextInt();
                connections.add(connection);
            }
        }
    }

    public void printNode(ArrayList<Node> sourceNode, ArrayList<Connection> connections) {
        //method to print all the element inside the array of nodes
        int n=1;
        for (Connection element : connections) {
            //loop that goes through all node inside the "connections" array
            System.out.println(n + ". " + element.node1.key + " - " + element.node2.key + ": " + element.distance);
            n++;
        }
    }

    public void DijkstraSort(ArrayList<Node> sourceNode, ArrayList<Connection> connections, ArrayList<Node> visited) {
        Node root = sourceNode.get(0);//setting the first node as root
        root.weight = 0;
        Node smallest = new Node();

        for (int i = 0; i < sourceNode.size(); ) {
            visited.add(root);
            sourceNode.remove(root);

            //loop that goes through all nodes
            for (Connection connection : connections) {
                if (connection.node1.equals(root)) {
                    if (connection.node2.weight > (connection.distance + root.weight)) {
                        connection.node2.weight = (connection.distance + root.weight);
                    }
                }
                    }

            if(!sourceNode.isEmpty()) {
                smallest = sourceNode.get(0); //random pick to be compared
            }

            for (Node element : sourceNode) {
                //finding node with the smallest weight to be next root
                if(element.weight < smallest.weight) {
                    smallest = element;
                }
            }

            root = smallest;

        }

    }

    public void printResult(ArrayList<Node> sourceNode) {
        System.out.println("Root: " + sourceNode.get(0).key);
        sourceNode.remove(0);
        System.out.println("The closest distance from:");

        for (Node element : sourceNode) {
            System.out.println("Node " + element.key + " is " + element.weight);
        }
    }
}
