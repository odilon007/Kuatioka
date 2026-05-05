package ui;

import java.util.Scanner;

public class Menu {
    public void inicial() {
        System.out.println("KUATIOKA\n");
        System.out.println("[1] Gerenciar Itens");
        System.out.println("[2] Gerenciar Usuários");
        System.out.println("[3] Operações (Empréstimo/Devolução)");
        System.out.println("[4] Consultas");
        System.out.println("[0] Sair");
    }

    public void gerenciarUsuarios() {
        System.out.println("GERENCIAR USUARIOS\n");
        System.out.println("[1] Cadastrar usuario");
        System.out.println("[2] Atualizar usuário");
        System.out.println("[3] Deletar usuário");
        System.out.println("[0] Voltar");

    }
    public void gerenciarItens() {
        System.out.println("GERENCIAR ITENS\n");
        System.out.println("[1] Cadastrar item");
        System.out.println("[2] Atualizar item");
        System.out.println("[3] Deletar item");
        System.out.println("[0] Voltar");
    }

    public void consultas() {
        System.out.println("CONSULTAS\n");
        System.out.println("[1] Consultar Itens");
        System.out.println("[2] Consultar Usuários");
        System.out.println("[3] Consultar Empréstimos");
        System.out.println("[4] Consultar Devoluções");
        System.out.println("[0] Voltar");
    }

    public void cadastrarUsuario() {
        System.out.println("[1] Funcionário Administrativo");
        System.out.println("[2] Aluno Graduação");
        System.out.println("[3] Aluno Pós-Graduação");
        System.out.println("[4] Professor");
        System.out.println("[0] Voltar");
    }

    public void opInvalido() {
        System.out.println("Opção inválida");
    }

    public void enterSaida(Scanner sc) {
        System.out.println("\nPressione ENTER para continuar...");
        sc.nextLine();
    }
}
