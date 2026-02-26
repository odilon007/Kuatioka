package app;

import ui.Menu;
import dominio.Aluno;
import dominio.Item;

public class Main {
    public static void main(String[] args) {
        Menu.menuInicial();

        Aluno aluno1 = new Aluno("João", 17);
        aluno1.mostrarAluno();

        Item item1 = new Item("Livro", "Álgebra linear");
        item1.mostrarItem();
    }
}