package dominio;

public class AlunoPosGraduacao extends Aluno {

    private String areaPesquisa;

    public AlunoPosGraduacao(String nome, String email, String matricula, String areaPesquisa) {
        super(nome, email, matricula);
        this.areaPesquisa = areaPesquisa;
    }
    @Override
    public String getTipo() {
        return "Aluno de Pós-Graduação";
    }

    @Override
    public int getLimiteEmprestimo() {
        return 5;
    }
    @Override
    public int getPrazoEmprestimoLivro() {
        return 14;
    }
    @Override
    public float getMultaAtrasoDia() {
        return 1.00f;
    }

    public String getAreaPesquisa() {
        return areaPesquisa;
    }

    public void setAreaPesquisa(String areaPesquisa) {
        this.areaPesquisa = areaPesquisa;
    }
}
