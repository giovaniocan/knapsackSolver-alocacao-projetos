package br.com.bpkedu.projetos;

import java.util.ArrayList;
import java.util.List;

public class Orcamento {
    private double valorDisponivel;
    private List<Projeto> projetos;

    public Orcamento(double valorDisponivel) {
        this.valorDisponivel = valorDisponivel;
        this.projetos = new ArrayList<>();
    }

    public Orcamento(double valorDisponivel, List<Projeto> projetos) {
        this.valorDisponivel = valorDisponivel;
        this.projetos = projetos;
    }

    public void addProjeto(Projeto projeto) {
        this.projetos.add(projeto);
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public double getValorDisponivel() {
        return valorDisponivel;
    }
}
