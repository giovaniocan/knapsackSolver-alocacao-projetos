package br.com.bpkedu.projetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjetoTest {
    public static void main(String[] args) {
        // gerando o orcamento e quantos projetos tem
        Double valorDisponivel = 500.0;
        int numberOfProjects = 4;

        // gerando os projetos meio aleatorios.
       List<Projeto> projetos = generateRandomProjects(numberOfProjects, 100.0, 250.0, 200.0, 1000.0);

        /*// criando os projetos
        List<Projeto> projetos = new ArrayList<>();
        projetos.add(new Projeto("Projeto 1", 100.0, 200.0));
        projetos.add(new Projeto("Projeto 2", 50.0, 300.0));
        projetos.add(new Projeto("Projeto 3", 200.0, 400.0));
        projetos.add(new Projeto("Projeto 4", 75.0, 300.0));
        projetos.add(new Projeto("Projeto 5", 300.0, 250.0));
        projetos.add(new Projeto("Projeto 6", 300.0, 2000.0));*/


        //mostrando todos os projetos disponiveis.
        projetos.forEach(projeto -> System.out.println(projeto));

        // criando o orcamento com o valor disponivel e a lista de projetos
        Orcamento orcamento = new Orcamento(valorDisponivel, projetos);

        //resolvendo o probblema aqui
        OrcamentoSolverBackTracking solver = new OrcamentoSolverBackTracking();
        OrcamentoState melhorEstado = solver.solve(orcamento);

        //mostrando os resultados
        System.out.println("Projetos selecionados para o orcamento:");
        for (Projeto projeto : melhorEstado.projetosSelecionados) {
            System.out.printf("Investimento %s: %.2f, Retorno: %.2f%n", projeto.getNome(), projeto.getInvestimento(), projeto.getRetorno());
        }
        System.out.printf("Investimento total: %.2f%n", melhorEstado.getTotalInvestimento());
        System.out.printf("Retorno total: %.2f%n", melhorEstado.getTotalRetorno());

    }
         private static List<Projeto> generateRandomProjects(int count, double minInvestimento, double maxInvestimento, double minRetorno, double maxRetorno) {
            List<Projeto> projetosRandom = new ArrayList<>();
            Random random = new Random();

            for (int i = 1; i <= count; i++) {
                double investimento = minInvestimento + (maxInvestimento - minInvestimento) * random.nextDouble();
                double retorno = minRetorno + (maxRetorno - minRetorno) * random.nextDouble();
                projetosRandom.add(new Projeto("Projeto " + i, investimento, retorno));
            }

            return projetosRandom;
            }
}
