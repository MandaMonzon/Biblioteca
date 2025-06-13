public class Professor extends Usuario {
    private String departamento;

    public Professor(String nome, String id, String departamento) {
        super(nome, id);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public void exibirTipoUsuario() {
        System.out.println("Usuário: Professor");
        System.out.println("Nome: " + nome);
        System.out.println("ID: " + id);
        System.out.println("Departamento: " + departamento);
    }
}
