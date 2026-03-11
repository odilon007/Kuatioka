package services;

import dominio.Estudante;
import dominio.Funcionario;
import dominio.Usuario;
import repository.RepositorioUsuarios;
import ui.Menu;

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
            op = sc.nextInt();
            sc.nextLine();
            gerenciar(op);
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
        System.out.println("[1] Funcionario");
        System.out.println("[2] Estudante");
        System.out.println("[0] Voltar");

        int op = sc.nextInt();
        sc.nextLine();


        if (op != 1 && op != 2) return;

        System.out.printf("Nome: ");
        String nome = sc.nextLine();
        System.out.printf("Email: ");
        String email = sc.nextLine();


        switch (op) {
            case 1:
                cadastrarFuncionario(nome, email);
                break;
            case 2:
                cadastrarEstudante(nome, email);
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

    private void cadastrarEstudante(String nome, String email) {
        System.out.printf("Digite sua matricula: ");

        String matricula = sc.nextLine();
        Usuario estudante = new Estudante(nome, email, matricula);
        repositorio.salvar(estudante);

        System.out.println("Cadastro do estudante realizado com sucesso!");
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
        System.out.println("[2] Estudante");
        System.out.println("[0] Voltar");
        int op = sc.nextInt();
        sc.nextLine();

        users.remove(user.getId());

        switch (op) {
            case 1:
                cadastrarFuncionario(user.getNome(), user.getEmail());
                break;
            case 2:
                cadastrarEstudante(user.getNome(), user.getEmail());
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
        System.out.println("Digite o ID do usuário que deseja editar: ");
        int id = sc.nextInt();
        sc.nextLine();

        repositorio.deletar(id);
    }

}

