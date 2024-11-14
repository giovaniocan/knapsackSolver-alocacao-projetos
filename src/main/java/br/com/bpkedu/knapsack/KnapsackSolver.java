package br.com.bpkedu.knapsack;

import java.util.*;

/**
 * A classe KnapsackSolver implementa o Algoritmo A* para resolver o problema da mochila.
 * Dado um conjunto de itens e uma capacidade máxima de uma mochila, esta classe encontra
 * a melhor combinação de itens que maximiza o valor total sem ultrapassar a capacidade.
 */
public class KnapsackSolver {

    /**
     * Resolve o problema da mochila utilizando o Algoritmo A* para encontrar o estado ótimo,
     * que representa a combinação de itens com o valor total máximo sem exceder a capacidade da mochila.
     *
     * @param knapsack A instância de Knapsack que contém a capacidade máxima e a lista de itens disponíveis.
     * @return O estado da mochila (KnapsackState) que representa a melhor solução encontrada, contendo os itens selecionados.
     */
    public KnapsackState solve(Knapsack knapsack) {
        System.out.println("Solucionando o problema de otimização");
        // Ordena os itens com base na eficiência (valor/peso), priorizando itens de maior valor por unidade de peso
        System.out.println("Ordenando os itens...");
        List<Item> sortedItems = new ArrayList<>(knapsack.getItems());
        sortedItems.sort((a, b) -> Double.compare(b.getValue() / b.getWeight(), a.getValue() / a.getWeight()));

        // Fila de prioridade para explorar estados com base no valor total (maior valor primeiro)
        System.out.println("Criando fila de prioridade para explorar os estados com base no valor total");
        PriorityQueue<KnapsackState> openList = new PriorityQueue<>(Comparator.comparingDouble(KnapsackState::getTotalValue).reversed());
        openList.add(new KnapsackState());

        // Variável para armazenar o melhor estado encontrado
        KnapsackState bestState = null;

        // Loop de busca A* para encontrar o melhor estado
        System.out.println("Buscando a melhor combinação...");
        while (!openList.isEmpty()) {
            KnapsackState current = openList.poll();


            // Verifica se o estado atual é melhor que o melhor estado encontrado até agora
            if (current.getTotalWeight() <= knapsack.getCapacity() &&
                    (bestState == null || current.getTotalValue() > bestState.getTotalValue())) {
                System.out.println("Substituindo a combinação: " + bestState + " por " + current);
                bestState = current;
            }

            // Expande o estado atual adicionando os próximos itens disponíveis na lista ordenada
//            System.out.println("Expandindo o estado atual adicionando os próximos itens disponíveis na lista ordenada");
            for (Item item : sortedItems) {
                // Adiciona o item ao estado atual apenas se o peso total resultante não exceder a capacidade
                if (current.getTotalWeight() + item.getWeight() <= knapsack.getCapacity() &&
                        !current.selectedItems.contains(item)) {  // Evita adicionar o mesmo item várias vezes
                    KnapsackState newState = new KnapsackState(current.selectedItems);
                    newState.addItem(item);
                    openList.add(newState);
                }
            }
        }

        // Retorna o melhor estado encontrado, contendo a combinação de itens de valor máximo
        return bestState;
    }
}
