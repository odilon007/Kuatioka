package services;

import dominio.Usuario;
import repository.RepositorioUsuarios;
import ui.Menu;

import java.util.Scanner;

public class Consultas {
    private Scanner sc;
    private Menu menu;
    private RepositorioUsuarios repositorio;

    public Consultas(Menu menu, Scanner sc, RepositorioUsuarios repositorio) {
        this.menu = menu;
        this.sc = sc;
        this.repositorio = repositorio;
    }


    public void iniciar() {
        int op;
        do {
            menu.consultas();
            op = sc.nextInt();
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
                    break;
            }
        } while (op != 0);
    }
    // CONSULTAS

    private void consultarUsuarios() {
        repositorio.listar();
    }
}
