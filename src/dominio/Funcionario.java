package dominio;

public class Funcionario extends Usuario {
    private float salario;

    public Funcionario(String nome, String email, float salario) {
        super(nome, email);
        this.salario = salario;
    }

    @Override
    public String getTipo() {
        return "Funcionario Administrativo";
    }

    public float getSalario() {
        return this.salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
