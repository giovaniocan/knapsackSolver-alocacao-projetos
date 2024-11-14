package br.com.bpkedu.knapsack;

import br.com.bpkedu.knapsack.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe KnapsackState representa um estado de seleção de itens no problema da mochila.
 * Cada estado armazena os itens selecionados, bem como o peso total e o valor total desses itens.
 * Esta classe é usada pelo algoritmo A* para avaliar diferentes combinações de itens e encontrar a solução ótima.
 */
public class KnapsackState {
    /**
     * Lista de itens selecionados no estado atual.
     */
    protected final List<Item> selectedItems;

    /**
     * Peso total dos itens selecionados no estado atual.
     */
    protected double totalWeight;

    /**
     * Valor total dos itens selecionados no estado atual.
     */
    protected double totalValue;

    /**
     * Construtor padrão que inicializa o estado com uma lista vazia de itens,
     * e define o peso e valor total como 0.
     */
    public KnapsackState() {
        this.selectedItems = new ArrayList<>();
        this.totalWeight = 0.0;
        this.totalValue = 0.0;
    }

    /**
     * Construtor que inicializa o estado com uma lista específica de itens.
     * Calcula automaticamente o peso total e o valor total com base nos itens fornecidos.
     *
     * @param selectedItems A lista de itens a ser usada para inicializar o estado.
     */
    public KnapsackState(List<Item> selectedItems) {
        this.selectedItems = new ArrayList<>(selectedItems);
        for (Item item : selectedItems) {
            this.totalWeight += item.getWeight();
            this.totalValue += item.getValue();
        }
    }

    /**
     * Adiciona um item ao estado atual, atualizando o peso e o valor total.
     *
     * @param item O item a ser adicionado.
     */
    public void addItem(Item item) {
        selectedItems.add(item);
        totalWeight += item.getWeight();
        totalValue += item.getValue();
    }

    /**
     * Retorna o peso total dos itens selecionados no estado atual.
     *
     * @return O peso total dos itens selecionados.
     */
    public double getTotalWeight() {
        return totalWeight;
    }

    /**
     * Retorna o valor total dos itens selecionados no estado atual.
     *
     * @return O valor total dos itens selecionados.
     */
    public double getTotalValue() {
        return totalValue;
    }

    /**
     * Calcula a heurística para o estado atual, que representa a diferença entre
     * a capacidade da mochila e o peso total dos itens selecionados.
     * A heurística é usada para priorizar estados que estão mais próximos
     * da capacidade da mochila sem ultrapassá-la.
     *
     * @param capacity A capacidade máxima da mochila.
     * @return A heurística para o estado atual (diferença entre capacidade e peso total).
     */
    public double heuristic(double capacity) {
        return capacity - totalWeight;
    }

    @Override
    public String toString() {
        return "KnapsackState{" +
                "totalWeight=" + totalWeight +
                ", totalValue=" + totalValue +
                '}';
    }
}
