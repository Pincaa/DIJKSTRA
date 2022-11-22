import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in); //object to scan input from user
        Graph hello = new Graph(); //object to perform input output and sorting
        ArrayList<Graph.Node> nodes = new ArrayList<>(); //where the nodes stored
        ArrayList<Graph.Connection> connections = new ArrayList<>(); //where the connections stored
        ArrayList<Graph.Node> sorted = new ArrayList<>(); //where the sorted nodes stored

        //INTRO---
        System.out.println("Welcome to my Dijkstra's Algorithm Project!");
        System.out.println("Let's make the graph by inserting nodes!");
        System.out.println("First, how many nodes will be there?");
        int n = scan.nextInt(); //number of nodes

        System.out.println("The first node inputted will automatically become the root!");
        System.out.println("Let's start storing input");
        hello.inputNode(n, nodes);
        System.out.println("Now, we need to make the connections!");
        System.out.println("Write the connection from both side for undirected graph!");
        hello.connect(nodes,connections);
        hello.DijkstraSort(nodes,connections,sorted);
        System.out.println("Here is the result!");
        hello.printResult(sorted);
    }
}