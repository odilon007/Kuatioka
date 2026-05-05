package services;

import dominio.*;
import repository.RepositorioUsuarios;
import ui.Menu;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class GerenciadorUsuarios {
    private Menu menu;
    private Scanner sc;
    private RepositorioUsuarios repositorio;
    private Map<Integer, Usuario> users;

    public GerenciadorUsuarios(Menu menu, Scanner sc, RepositorioUsuarios repositorio) {
        this.menu = menu;
        this.sc = sc;
        this.repositorio = repositorio;
        this.users = repositorio.getUsers();
    }

    public void iniciar() {
        int op = -1;
        do {
            menu.gerenciarUsuarios();
            try {
                op = sc.nextInt();
                sc.nextLine();
                gerenciar(op);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida");
                sc.nextLine();
                return;
            }
        } while (op !=  0);
    }

    private void gerenciar(int op) {
        switch (op) {
            case 1:
                cadastrarUsuario();
                break;
            case 2:
                atualizarUsuario();
                break;
            case 3:
                deletarUsuario();
                break;

            case 0:
                break;
            default:
                menu.opInvalido();
                break;
        }
    }

    // CADASTRAR USUÁRIOS
    private void cadastrarUsuario() {
        menu.cadastrarUsuario();
        int op;
        try {
            op = sc.nextInt();
            sc.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida");
            sc.nextLine();
            return;
        }

        if (op > 4 || op <= 0) return;

        System.out.printf("Nome: ");
        String nome = sc.nextLine();
        System.out.printf("Email: ");
        String email = sc.nextLine();


        switch (op) {
            case 1:
                cadastrarFuncionario(nome, email);
                break;
            case 2:
                cadastrarAlunoGraduacao(nome, email);
                break;
            case 3:
                cadastrarAlunoPosGraduacao(nome, email);
                break;
            case 4:
                cadastrarProfessor(nome, email);
                break;
            default:
                menu.opInvalido();
                cadastrarUsuario();
                break;
        }
    }

    private void cadastrarFuncionario(String nome, String email) {
        System.out.printf("Digite seu salario: ");

        float salario = sc.nextFloat();
        sc.nextLine();

        Usuario funcionario = new Funcionario(nome, email, salario);
        repositorio.salvar(funcionario);

        System.out.println("Cadastro do funcionário realizado com sucesso!");
        menu.enterSaida(sc);
    }

    private void cadastrarAlunoGraduacao(String nome, String email) {
        System.out.printf("Digite sua matricula: ");

        String matricula = sc.nextLine();
        System.out.printf("Digite seu curso: ");

        String curso = sc.nextLine();

        Aluno aluno = new AlunoGraduacao(nome, email, matricula, curso);

        repositorio.salvar(aluno);

        System.out.println("Cadastro do aluno realizado com sucesso!");
        menu.enterSaida(sc);
    }

    private void cadastrarAlunoPosGraduacao(String nome, String email) {
        System.out.printf("Digite sua matricula: ");

        String matricula = sc.nextLine();
        System.out.printf("Digite sua area de pesquisa : ");

        String areaPesquisa = sc.nextLine();

        Aluno aluno = new AlunoPosGraduacao(nome, email, matricula, areaPesquisa);

        repositorio.salvar(aluno);

        System.out.println("Cadastro do aluno realizado com sucesso!");
        menu.enterSaida(sc);
    }

    private void cadastrarProfessor(String nome, String email) {
        System.out.printf("Digite sua matricula: ");

        String matricula = sc.nextLine();
        System.out.printf("Digite seu curso: ");


        Professor professor = new Professor(nome, email, matricula);

        repositorio.salvar(professor);

        System.out.println("Cadastro do aluno realizado com sucesso!");
        menu.enterSaida(sc);
    }



    // ATUALIZAR USUÁRIOS
    private void atualizarUsuario() {
        System.out.println("Digite o ID do usuário que deseja editar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Usuario user = repositorio.buscar(id);
        if (user == null) {
            System.out.println("Usuário não existe");
            atualizarUsuario();
            return;
        }
        System.out.println("Usuário encontrado");
        System.out.printf("%-5s %-20s %-40s %-15s\n",
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getTipo()
        );
        System.out.println("[1] Editar Nome");
        System.out.println("[2] Editar Email");
        System.out.println("[3] Editar Tipo");
        System.out.println("[0] Voltar");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                System.out.printf("Nome: ");
                String nome = sc.nextLine();
                user.setNome(nome);
                System.out.println("Nome alterado com sucesso!");
                menu.enterSaida(sc);
                break;
            case 2:
                System.out.printf("Email: ");
                String email = sc.nextLine();
                user.setEmail(email);
                System.out.println("Email alterado com sucesso!");
                menu.enterSaida(sc);
                break;
            case 3:
                mudarTipo(user);
                System.out.println("Tipo alterado com sucesso!");
                menu.enterSaida(sc);
                break;
            case 0:
                break;
            default:
                menu.opInvalido();
                break;

        }

    }
    private void mudarTipo(Usuario user) {
        System.out.println("[1] Funcionário");
        System.out.println("[2] Aluno");
        System.out.println("[0] Voltar");
        int op = sc.nextInt();
        sc.nextLine();

        users.remove(user.getId());

        switch (op) {
            case 1:
                cadastrarFuncionario(user.getNome(), user.getEmail());
                break;
            case 2:
                cadastrarAlunoGraduacao(user.getNome(), user.getEmail());
                break;
            case 3:
                cadastrarAlunoPosGraduacao(user.getNome(), user.getEmail());
                break;
            case 4:
                cadastrarProfessor(user.getNome(), user.getEmail());
                break;
            case 0:
                break;
            default:
                menu.opInvalido();
                mudarTipo(user);
                break;
        }
    }

    //DELETAR USUÁRIOS
    private void deletarUsuario() {
        System.out.println("Digite o ID do usuário que deseja deletar: ");
        int id = sc.nextInt();
        sc.nextLine();

        repositorio.deletar(id);
    }

}

