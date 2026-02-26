package dominio;

public class Item {
    private String nome;
    private String tipo;
    private Status status;

    private enum Status {
        DISPONIVEL,
        EMPRESTADO
    }

    public Item(String tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
        this.status = status.DISPONIVEL;
    }

    public void mostrarItem() {
        System.out.println("Tipo: "+tipo);
        System.out.println("Nome do Item: "+nome);
        System.out.println("Status: "+status);
    }
}
