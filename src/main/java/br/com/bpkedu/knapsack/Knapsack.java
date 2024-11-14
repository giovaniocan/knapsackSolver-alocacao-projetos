package br.com.bpkedu.knapsack;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {
    private double capacity;
    private List<Item> items;


    public Knapsack(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public Knapsack(double capacity, List<Item> itens) {
        this.capacity = capacity;
        this.items = itens;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public double getCapacity() {
        return capacity;
    }
}
