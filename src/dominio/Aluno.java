package dominio;

public class Aluno extends Usuario {
    private String matricula;

    public Aluno(String nome, String email, String matricula) {
        super(nome, email);
        this.matricula = matricula;
    }

    @Override
    public String getTipo() {
        return "Aluno";
    }

    public int getLimiteEmprestimo() {
        return 3;
    }


    public int getPrazoEmprestimoLivro() {
        return 7;
    }

    public int getPrazoEmprestimoOutros() {
        return 7;
    }


    public float getMultaAtrasoDia() {
        return 2.00f;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }


}
