public class Aluno extends Usuario {
    private String curso;

    public Aluno(String nome, String id, String curso) {
        super(nome, id);
        this.curso = curso;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public void exibirTipoUsuario() {
        System.out.println("Usuário: Aluno");
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
        System.out.println("Curso: " + curso);
    }
}
