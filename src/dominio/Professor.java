package dominio;

public class Professor extends Usuario{
    private String matricula;

    public Professor(String nome, String email, String matricula) {
        super(nome, email);
        this.matricula = matricula;
    }
    @Override
    public String getTipo() {
        return "Professor";
    }
}
