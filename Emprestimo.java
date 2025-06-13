import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao; // Pode ser null se ainda não foi devolvido

    public Emprestimo(Livro livro, Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now(); // Data atual
        this.dataDevolucao = null; // Ainda não devolvido
        // Ao criar um empréstimo, o livro deve ser marcado como indisponível
        livro.emprestar();
    }

    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void registrarDevolucao() {
        if (dataDevolucao == null) {
            this.dataDevolucao = LocalDate.now();
            livro.devolver(); // Marca o livro como disponível novamente
            System.out.println("Devolução do livro '" + livro.getTitulo() + "' registrada com sucesso!");
        } else {
            System.out.println("Este empréstimo já foi devolvido.");
        }
    }

    public void exibirResumoEmprestimo() {
        System.out.println("--- Resumo do Empréstimo ---");
        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Usuário: " + usuario.getNome() + " (" + (usuario instanceof Aluno ? "Aluno" : "Professor") + ")");
        System.out.println("Data do Empréstimo: " + dataEmprestimo);
        if (dataDevolucao != null) {
            System.out.println("Data da Devolução: " + dataDevolucao);
        } else {
            System.out.println("Status: Empréstimo ativo");
        }
        System.out.println("----------------------------");
    }
}
