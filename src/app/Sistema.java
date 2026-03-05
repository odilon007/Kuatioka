package app;

import dominio.Estudante;
import dominio.Funcionario;
import dominio.Usuario;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import ui.Menu;

public class Sistema {
    private Menu menu = new Menu();
    private Scanner sc = new Scanner(System.in);
    private Map<Integer, Usuario> users = new HashMap<>();


    public void iniciar() {
        int op;
        do {
            menu.inicial();
            op = sc.nextInt();
            executarOperacao(op);
        } while (op != 0);
    }

    private void executarOperacao(int opInicial) {
        String mensagem = null;
        switch (opInicial) {
            case 1:
                gerenciarItens();
                mensagem = "Matheus não sabe Java!";
                break;
            case 2:
                gerenciarUsuarios();
                break;
            case 3:
                mensagem = "Matheus não sabe Java!";
                break;
            case 4:
                consultar();
                break;
            case 0:
                mensagem = "Saindo...";
                break;
            default:
                mensagem = "Matheus não sabe digitar um numero de 1 a 5";
                break;
        }
        if (mensagem != null) {
            System.out.println(mensagem);
        }
    }

    // GERENCIAR ITENS
    private void gerenciarItens() {
        menu.gerenciarItens();
        return;
    }

    // GERENCIAR USUÁRIOS
    private void gerenciarUsuarios() {
        menu.gerenciarUsuarios();
        int op = sc.nextInt();
        sc.nextLine();

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
                gerenciarUsuarios();
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
                gerenciarUsuarios();
                break;
            case 2:
                cadastrarEstudante(nome, email);
                gerenciarUsuarios();
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
        users.put(funcionario.getId(), funcionario);

        System.out.println("Cadastro do funcionário realizado com sucesso!");
        menu.enterSaida(sc);
    }

    private void cadastrarEstudante(String nome, String email) {
        System.out.printf("Digite sua matricula: ");

        String matricula = sc.nextLine();
        Usuario estudante = new Estudante(nome, email, matricula);
        users.put(estudante.getId(), estudante);

        System.out.println("Cadastro do estudante realizado com sucesso!");
        menu.enterSaida(sc);
    }



    // ATUALIZAR USUÁRIOS
    private void atualizarUsuario() {
        System.out.println("Digite o ID do usuário que deseja editar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Usuario user = users.get(id);
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
                atualizarUsuario();
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

    // CONSULTAS
    private void consultar() {
        menu.consultas();
        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                System.out.println("Consultar Itens");
                break;
            case 2:
                consultarUsuarios();
                break;
            case 3:
                System.out.println("Consultar Empréstimos");
                break;
            case 4:
                System.out.println("Consultar Devoluções");
                break;
            case 0:
                break;
            default:
                menu.opInvalido();
                consultar();
                break;
        }
    }

    private void consultarUsuarios() {
        System.out.println("USUÁRIOS\n");
        System.out.printf("%-5s %-20s %-40s %-15s%n", "ID", "Nome", "Email", "Tipo");
        System.out.println("---------------------------------------------------------------------------");
        for (Usuario user : users.values()) {
            System.out.printf("%-5s %-20s %-40s %-15s\n",
                    user.getId(),
                    user.getNome(),
                    user.getEmail(),
                    user.getTipo()
            );
        }
        menu.enterSaida(sc);
        consultar();
    }


    //DELETAR USUÁRIOS
    private void deletarUsuario() {
        System.out.println("Digite o ID do usuário que deseja editar: ");
        int id = sc.nextInt();
        sc.nextLine();

        Usuario user = users.get(id);
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
        System.out.println("Tem certeza que deseja excluir: ");
        System.out.println("[1] sim");
        System.out.println("[2] não");

        int op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                users.remove(id);
                System.out.println("Usuário removido com sucesso!");
                menu.enterSaida(sc);
                break;
            case 2:
                break;
            default:
                menu.opInvalido();
                deletarUsuario();
                break;
        }
    }

}
