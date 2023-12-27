package graphPackage;

import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        EdgeListGraph<Integer, Integer> graph = new EdgeListGraph<>();
        String choice = "y", menu_choice;
        do {
            System.out.println("*************************Menu*************************");
            System.out.println("1. Number of Vertices");
            System.out.println("2. Vertices");
            System.out.println("3. Number of Edges");
            System.out.println("4. Edges");
            System.out.println("5. Get Edge");
            System.out.println("6. End Vertices of an edge");
            System.out.println("7. Opposite");
            System.out.println("8. Out Degree");
            System.out.println("9. In Degree");
            System.out.println("10. Outgoing Edges");
            System.out.println("11. Incoming Edges");
            System.out.println("12. Insert Edge");
            System.out.println("13. Insert Vertex");
            System.out.println("14. Remove Edge");
            System.out.println("15. Remove Vertex");
            System.out.println("******************************************************");
            System.out.println("Enter your choice: ");
            menu_choice = scan.nextLine();
            switch (menu_choice) {
                case "1":
                    System.out.println("******************************************************");
                    System.out.println("Number of Vertices: " + graph.numVertices());
                    System.out.println("******************************************************");
                    break;

                case "2":
                    System.out.println("******************************************************");
                    System.out.println("Vertices are: ");
                    for(Vertex<Integer> i : graph.vertices()) {
                        System.out.println(i.getElement());
                    }
                    System.out.println("******************************************************");
                    break;

                case "3":
                    System.out.println("******************************************************");
                    System.out.println("Number of Edges: " + graph.numEdges());
                    System.out.println("******************************************************");
                    break;

                case "4":
                    System.out.println("******************************************************");
                    System.out.println("Edges are: ");
                    for(Edge<Integer> i : graph.edges()) {
                        System.out.println(i.getElement());
                    }
                    System.out.println("******************************************************");
                    break;

                case "5":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter origin: ");
                        int origin = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter destination: ");
                        int dest = Integer.parseInt(scan.nextLine());
                        System.out.println("Edge is: " + graph.getEdge(graph.findVertex(origin), graph.findVertex(dest)).getElement());
                    } catch (Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter origin: ");
                        int origin = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter destination: ");
                        int dest = Integer.parseInt(scan.nextLine());
                        System.out.println("Edge is: " + graph.getEdge(graph.findVertex(origin), graph.findVertex(dest)).getElement());
                    }
                    System.out.println("******************************************************");
                    break;

                case "6":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter edge: ");
                        int edge = Integer.parseInt(scan.nextLine());
                        System.out.println("End points are: " + graph.endVertices(graph.findEdge(edge))[0].getElement() + " - " + graph.endVertices(graph.findEdge(edge))[1].getElement());
                    }
                    catch(Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter edge: ");
                        int edge = Integer.parseInt(scan.nextLine());
                        System.out.println("End points are: " + graph.endVertices(graph.findEdge(edge))[0].getElement() + " - " + graph.endVertices(graph.findEdge(edge))[1].getElement());
                    }
                    System.out.println("******************************************************");
                    break;

                case "7":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter vertex: ");
                        int vert = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter edge: ");
                        int e = Integer.parseInt(scan.nextLine());
                        System.out.println("Opposite vertex is: " + graph.opposite(graph.findVertex(vert), graph.findEdge(e)).getElement());
                    }
                    catch(Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter vertex: ");
                        int vert = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter edge: ");
                        int edge1 = Integer.parseInt(scan.nextLine());
                        System.out.println("Opposite vertex is: " + graph.opposite(graph.findVertex(vert), graph.findEdge(edge1)).getElement());
                    }
                    System.out.println("******************************************************");
                    break;

                case "8":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter vertex: ");
                        int vert1 = Integer.parseInt(scan.nextLine());
                        System.out.println("Out degree of " + vert1 + " is: " + graph.outDegree(graph.findVertex(vert1)));
                    }
                    catch(Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter vertex: ");
                        int vert1 = Integer.parseInt(scan.nextLine());
                        System.out.println("Out degree of " + vert1 + " is: " + graph.outDegree(graph.findVertex(vert1)));
                    }
                    System.out.println("******************************************************");
                    break;
                
                case "9":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter vertex: ");
                        int vert1 = Integer.parseInt(scan.nextLine());
                        System.out.println("In degree of " + vert1 + " is: " + graph.inDegree(graph.findVertex(vert1)));
                    }
                    catch(Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter vertex: ");
                        int vert1 = Integer.parseInt(scan.nextLine());
                        System.out.println("In degree of " + vert1 + " is: " + graph.inDegree(graph.findVertex(vert1)));
                    }
                    System.out.println("******************************************************");
                    break;

                case "10":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter vertex: ");
                        int vert1 = Integer.parseInt(scan.nextLine());
                        System.out.println("Outgoing edges of " + vert1 + " are: ");
                        for(Edge<Integer> edge : graph.outgoingEdges(graph.findVertex(vert1))) {
                            System.out.println(edge.getElement());
                        }
                    }
                    catch(Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter vertex: ");
                        int vert1 = Integer.parseInt(scan.nextLine());
                        System.out.println("Outgoing edges of " + vert1 + " are: ");
                        for(Edge<Integer> edge : graph.outgoingEdges(graph.findVertex(vert1))) {
                            System.out.println(edge.getElement());
                        }
                    }
                    System.out.println("******************************************************");
                    break;
                
                case "11":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter vertex: ");
                        int vert1 = Integer.parseInt(scan.nextLine());
                        System.out.println("Incoming edges of " + vert1 + " are: ");
                        for(Edge<Integer> edge : graph.incomingEdges(graph.findVertex(vert1))) {
                            System.out.println(edge.getElement());
                        }
                    }
                    catch(Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter vertex: ");
                        int vert1 = Integer.parseInt(scan.nextLine());
                        System.out.println("Incoming edges of " + vert1 + " are: ");
                        for(Edge<Integer> edge : graph.incomingEdges(graph.findVertex(vert1))) {
                            System.out.println(edge.getElement());
                        }
                    }
                    System.out.println("******************************************************");
                    break;

                case "12":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter edge element: ");
                        int edge = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter origin vertex: ");
                        Vertex<Integer> origin = graph.findVertex(Integer.parseInt(scan.nextLine()));
                        System.out.println("Enter destination vertex: ");
                        Vertex<Integer> dest = graph.findVertex(Integer.parseInt(scan.nextLine()));
                        System.out.println("Edge created: " + graph.insertEdge(origin, dest, edge));
                    }
                    catch(Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter edge element: ");
                        int edge = Integer.parseInt(scan.nextLine());
                        System.out.println("Enter origin vertex: ");
                        Vertex<Integer> origin = graph.findVertex(Integer.parseInt(scan.nextLine()));
                        System.out.println("Enter destination vertex: ");
                        Vertex<Integer> dest = graph.findVertex(Integer.parseInt(scan.nextLine()));
                        System.out.println("Edge created: " + graph.insertEdge(origin, dest, edge));
                    }
                    System.out.println("******************************************************");
                    break;

                case "13":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter vertex element: ");
                        int vert1 = Integer.parseInt(scan.nextLine());
                        System.out.println("Vertex created: " + graph.insertVertex(vert1));
                    }
                    catch(Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter vertex element: ");
                        int vert1 = Integer.parseInt(scan.nextLine());
                        System.out.println("Vertex created: " + graph.insertVertex(vert1));
                    }
                    System.out.println("******************************************************");
                    break;

                case "14":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter the edge to remove: ");
                        int edge = Integer.parseInt(scan.nextLine());
                        graph.removeEdge(graph.findEdge(edge));
                        System.out.println("Edge removed.");
                    }
                    catch(Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter the edge to remove: ");
                        int edge = Integer.parseInt(scan.nextLine());
                        graph.removeEdge(graph.findEdge(edge));
                        System.out.println("Edge removed.");
                    }
                    System.out.println("******************************************************");
                    break;

                case "15":
                    System.out.println("******************************************************");
                    try {
                        System.out.println("Enter the vertex to remove: ");
                        int vert = Integer.parseInt(scan.nextLine());
                        graph.removeVertex(graph.findVertex(vert));
                        System.out.println("Vertex removed.");
                    }
                    catch(Exception e) {
                        System.out.println("Error occurred: " + e);
                        System.out.println("Try again!!");
                        System.out.println("Enter the vertex to remove: ");
                        int vert = Integer.parseInt(scan.nextLine());
                        graph.removeVertex(graph.findVertex(vert));
                        System.out.println("Vertex removed.");
                    }
                    System.out.println("******************************************************");
                    break;
                
                default:
                    System.out.println("******************************************************");
                    System.out.println("Wrong choice!!");
                    System.out.println("******************************************************");
                    break;
            }
            System.out.println("Do you want to continue(Y/N)?: ");
            choice = scan.nextLine();
        } while (choice.equals("y") || choice.equals("Y") || choice.equals("Yes") || choice.equals("yes"));
        System.out.println("Thank You!!");
        scan.close();
    }
}

