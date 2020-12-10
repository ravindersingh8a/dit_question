package com.example.dit;

import java.util.*;

public class Main {
    public static void createShops(){
        Shop s1 = Shop.createShop("S1",2,7,1); //Shop 1 have Smallest Radius among all.
        Shop s2 = Shop.createShop("S2",3,6,5);
        Shop s3 = Shop.createShop("S3",6,6,5);
        Shop s4 = Shop.createShop("S4",7,5,5);
        Shop s5 = Shop.createShop("S5",8,6,5);
    }



    public static void createGraph(List<Node> graph){
        Node A = new Node();
        A.setLabel("A");
        A.setLatitude(0);
        A.setLongitude(0);
        graph.add(A);

        Node B = new Node();
        B.setLabel("B");
        B.setLatitude(2);
        B.setLongitude(2);
        A.addNode(B);
        graph.add(B);

        Node C = new Node();
        C.setLabel("C");
        C.setLatitude(2);
        C.setLongitude(3);
        graph.add(C);
        B.addNode(C);

        Node D = new Node();
        D.setLabel("D");
        D.setLatitude(4);
        D.setLongitude(6);
        graph.add(D);
        C.addNode(D);

        Node E = new Node();
        E.setLabel("E");
        E.setLatitude(3);
        E.setLongitude(7);
        graph.add(E);
        D.addNode(E);

        Node F = new Node();
        F.setLabel("F");
        F.setLatitude(5);
        F.setLongitude(8);
        graph.add(F);
        E.addNode(F);

        Node G = new Node();
        G.setLabel("G");
        G.setLatitude(5);
        G.setLongitude(5);
        graph.add(G);
        F.addNode(G);

        Node H = new Node();
        H.setLabel("H");
        H.setLatitude(6);
        H.setLongitude(6);
        G.addNode(H);
        graph.add(H);

        Node I = new Node();
        I.setLabel("I");
        I.setLatitude(10);
        I.setLongitude(10);
        H.addNode(I);
        graph.add(I);
    }

    public static void main(String[] args) {
        createShops();//Shop Details saved i.e Use Case:1
        List<Node> graph = new ArrayList<Node>();
        createGraph(graph);
        //Search shop by name i.e Use case 3
        System.out.println("Enter shop name to be searched");
        Scanner scan = new Scanner(System.in);
        String shopName =  scan.nextLine();
        Shop shop = Shop.searchShop(shopName);
        if(shop!=null)
        {
            System.out.println("Shop: "+shop.getName()+" found at latitude: "+shop.getLatitude()+" longitude: "+shop.getLongitude());
        }
        else {
            System.out.println("Shop not found");
        }
        // Intersecting Shops i.e UseCase 4
        Set<Shop> intersectingShops = Node.allShopsInPath(graph);
        if(intersectingShops.size()>0) {
            System.out.println("Intersecting Shops");
            for (Shop shops : intersectingShops) {
                System.out.println(shops.toString());
            }
        } else{
            System.out.println("No intersecting shops in path");
        }

        // Calculating unit distance i.e Use case 5
        double unitDistance  = Node.unitDistance(graph);
        System.out.println("The distance from start to end is: "+ unitDistance);

    }
}
