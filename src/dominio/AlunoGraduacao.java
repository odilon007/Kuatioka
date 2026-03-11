package dominio;

public class AlunoGraduacao extends Aluno {

    private String curso;


    public AlunoGraduacao(String nome, String email, String matricula, String curso) {
        super(nome, email, matricula);
        this.curso = curso;
    }
    @Override
    public String getTipo() {
        return "Aluno de Graduação";
    }


    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
