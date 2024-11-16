package br.com.bpkedu.projetos;

public class Projeto {
    private String nome;
    private double investimento;
    private double retorno;


    public Projeto(String nome, double investimento, double retorno) {
        this.nome = nome;
        this.investimento = investimento;
        this.retorno = retorno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getInvestimento() {
        return investimento;
    }

    public void setInvestimento(double investimento) {
        this.investimento = investimento;
    }

    public double getRetorno() {
        return retorno;
    }

    public void setRetorno(double retorno) {
        this.retorno = retorno;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "nome='" + nome + '\'' +
                ", investimento=" + investimento +
                ", retorno=" + retorno +
                '}';
    }
}
