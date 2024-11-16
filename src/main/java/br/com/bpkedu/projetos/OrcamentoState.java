package br.com.bpkedu.projetos;

import br.com.bpkedu.knapsack.Item;

import java.util.ArrayList;
import java.util.List;

public class OrcamentoState {
    protected final List<Projeto> projetosSelecionados;
    protected double totalInvestimento;
    protected double totalRetorno;

    //criando um construtor quando ele é inicado sem parametros
    public OrcamentoState() {
        this.projetosSelecionados = new ArrayList<>();
        this.totalInvestimento = 0.0;
        this.totalRetorno = 0.0;
    }

    // criando um construtor quando ele é iniciado com parametros, onde ele recebe uma lista de projetos e calcula o total de investimento e retorno
    public OrcamentoState(List<Projeto> projetosSelecionados) {
        this.projetosSelecionados = new ArrayList<>(projetosSelecionados);
        //this.projetosSelecionados = projetosSelecionados;

        for (Projeto projeto : projetosSelecionados){
            this.totalInvestimento += projeto.getInvestimento();
            this.totalRetorno += projeto.getRetorno();
        }
    }

    public void addProjeto(Projeto projeto){
        projetosSelecionados.add(projeto);
        totalInvestimento += projeto.getInvestimento();
        totalRetorno += projeto.getRetorno();
    }

    public Double getTotalInvestimento(){
        return totalInvestimento;
    }

    public Double getTotalRetorno(){
        return totalRetorno;
    }
    public Double heuristica(double valorDisponivel) {
        return valorDisponivel - totalInvestimento;

    }

    @Override
    public String toString() {
        return "OrcamentoState{" +
                "projetosSelecionados=" + projetosSelecionados +
                ", totalInvestimento=" + totalInvestimento +
                ", totalRetorno=" + totalRetorno +
                '}';
    }
}
