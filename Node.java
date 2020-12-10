package com.example.dit;

import java.util.*;

public class Node {

    double latitude ;
    double longitude;
    String label;
    List<Node> connectingNodes =  new ArrayList<Node>();

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<Node> getConnectingNodes() {
        return connectingNodes;
    }

    public void setConnectingNodes(List<Node> connectingNodes) {
        this.connectingNodes = connectingNodes;
    }

    public void addNode(Node node){
        connectingNodes.add(node);
    }

    public boolean removeNode(Node node){
        return connectingNodes.remove(node);
    }

    public static List<Node> findPath(Node start, Node end){
        return null;
    }

    // This will take a node i.e. latitude and longitude as input and return all the shops in the whole path i.e. use case 4

    public static Set<Shop> allShopsInPath(List<Node> nodes)
    {
        // To store unique shops we are using hashset
        Set<Shop> nearestShops = new HashSet<Shop>();
        for(Node node : nodes) {
            for (Map.Entry<String, Shop> entry : Shop.allShops.entrySet()) {
                double d = Math.pow(entry.getValue().getRadius(), 2) - (Math.pow(node.getLatitude() - entry.getValue().getLatitude(), 2) + Math.pow(node.getLongitude() - entry.getValue().getLongitude(), 2));
                if (d > 0)
                    nearestShops.add(entry.getValue());
            }
        }
        return nearestShops;
    }

    // This will take a node i.e. latitude and longitude as input and return all the shops near to this point i.e. use case 4
    public static Set<Shop> allShopsAtThePoint(Node node)
    {
        // To store unique shops we are using hashset
        Set<Shop> nearestShops = new HashSet<Shop>();
            for (Map.Entry<String, Shop> entry : Shop.allShops.entrySet()) {
                double d = Math.pow(entry.getValue().getRadius(), 2) - (Math.pow(node.getLatitude() - entry.getValue().getLatitude(), 2) + Math.pow(node.getLongitude() - entry.getValue().getLongitude(), 2));
                if (d > 0)
                    nearestShops.add(entry.getValue());
            }
        return nearestShops;
    }


    // This will take all nodes in the path an calculate euclidean distance and return that distance i.e. use case 5
    public static double unitDistance(List<Node> nodes){
        if(nodes == null)
            return 0;
        else
        {
            double dist=0;
            Node start = nodes.get(0);
            for(int i=0;i<nodes.size();i++)
            {
                Node next = nodes.get(i);
                dist += Math.sqrt(Math.pow(next.latitude-start.latitude,2)+Math.pow(next.longitude-start.longitude,2));
                start= next;
            }
            return dist;
        }
    }
}
