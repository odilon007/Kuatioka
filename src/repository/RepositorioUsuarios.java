package repository;

import dominio.Usuario;
import ui.Menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class RepositorioUsuarios {
    private Map<Integer, Usuario> users = new HashMap<>();
    private Scanner sc = new Scanner(System.in);
    private Menu menu = new Menu();

    public Map<Integer, Usuario> getUsers() {
        return this.users;
    }

    public void salvar(Usuario user) {
        this.users.put(user.getId(), user);
    }

    public Usuario buscar(int id) {
        return this.users.get(id);
    }

    public void deletar(int id) {
        Usuario user = users.get(id);
        if (user == null) {
            System.out.println("Usuário não existe");
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
                break;
        }
    }

    public void listar() {
        System.out.println("USUÁRIOS\n");
        System.out.printf("%-5s %-20s %-40s %-15s%n", "ID", "Nome", "Email", "Tipo");
        System.out.println("---------------------------------------------------------------------------");
        for (Usuario user : this.users.values()) {
            System.out.printf("%-5s %-20s %-40s %-15s\n",
                    user.getId(),
                    user.getNome(),
                    user.getEmail(),
                    user.getTipo()
            );
        }
        menu.enterSaida(sc);
    }
}
