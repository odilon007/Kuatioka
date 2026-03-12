package app;

import dominio.Usuario;

import java.util.InputMismatchException;
import java.util.Scanner;

import repository.RepositorioUsuarios;
import services.Consultas;
import services.GerenciadorUsuarios;
import ui.Menu;

public class Sistema {
    private Menu menu = new Menu();
    private Scanner sc = new Scanner(System.in);
    private RepositorioUsuarios repositorio = new RepositorioUsuarios();
    private GerenciadorUsuarios usuarios = new GerenciadorUsuarios(menu, sc, repositorio);
    private Consultas consultas = new Consultas(menu, sc, repositorio);

    public void iniciar() {
        int op;
        do {
            menu.inicial();
            try {
                op = sc.nextInt();
                sc.nextLine();
                executarOperacao(op);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida");
                sc.nextLine();
                return;
            }
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
                usuarios.iniciar();
                break;
            case 3:
                mensagem = "Matheus não sabe Java!";
                break;
            case 4:
                consultas.iniciar();
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
    }
}


