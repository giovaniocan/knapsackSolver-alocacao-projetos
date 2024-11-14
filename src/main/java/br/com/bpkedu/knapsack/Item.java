package br.com.bpkedu.knapsack;

public class Item {
    private Double weight;
    private Double value;

    public Item(Double weight, Double value) {
        this.weight = weight;
        this.value = value;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Item{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }
}
