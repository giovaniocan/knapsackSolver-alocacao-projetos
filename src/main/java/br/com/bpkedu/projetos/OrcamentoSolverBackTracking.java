package br.com.bpkedu.projetos;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class OrcamentoSolverBackTracking {
    // definindo o limite da profundidade da arvore de decisao, e tambem o tamanho da fila de prioridade para evitar estouro de memoria.
    private static final int MAX_QUEUE_SIZE = 1000;
    private static final int MAX_DEPTH = 50;

    public OrcamentoState solve(Orcamento orcamento){
        List<Projeto> projetos = orcamento.getProjetos();
        double valorDisponivel = orcamento.getValorDisponivel();

        // criando a fila de projetos para armazenar os estados
        PriorityQueue<OrcamentoState> openList = new PriorityQueue<>(Comparator.comparingDouble(this::calcularPrioridade).reversed());

        OrcamentoState estadoInicial = new OrcamentoState();
        openList.add(estadoInicial);
        OrcamentoState melhorEstado = estadoInicial;

        while(!openList.isEmpty() && openList.size() <= MAX_QUEUE_SIZE){
            OrcamentoState atual = openList.poll();

            // Atualiza o melhor estado se necessário
            if(atual.getTotalRetorno() > melhorEstado.getTotalRetorno() && atual.getTotalInvestimento() <= valorDisponivel){
                melhorEstado = atual;
            }

            // Expande o estado atual se não tiver atingido o limite de profundidade
            if(atual.projetosSelecionados.size() < MAX_DEPTH){
                for(Projeto projeto : projetos){
                    if(!atual.projetosSelecionados.contains(projeto)){
                       OrcamentoState novoEstado = new OrcamentoState(atual.projetosSelecionados);
                        novoEstado.addProjeto(projeto);

                       // adiciona um novo estado a fila apenas se ele respeitar o limite de capacidade
                        if(novoEstado.getTotalInvestimento() <= valorDisponivel && calculaBound(novoEstado, projetos, valorDisponivel) > melhorEstado.getTotalRetorno()){
                            openList.add(novoEstado);

                            if(openList.size() > MAX_QUEUE_SIZE){
                                openList.poll();
                            }
                        }
                    }
                }
            }
        }
        return melhorEstado;
    }

    private Double calculaBound(OrcamentoState estado, List<Projeto> projetos, double valorDisponivel) {
        double bound = estado.getTotalRetorno();
        double investimentoRestante = valorDisponivel - estado.getTotalInvestimento();

        for (Projeto projeto : projetos) {
            if(!estado.projetosSelecionados.contains(projeto)){
                bound += projeto.getRetorno();
                investimentoRestante -= projeto.getInvestimento();
            }else{
                bound += projeto.getRetorno() * (investimentoRestante / projeto.getInvestimento());
                break;
            }
        }

        return  bound;
    }

    private double calcularPrioridade(OrcamentoState state) {
        return state.getTotalRetorno() / (state.getTotalInvestimento() + 1e-5);
    }
}
