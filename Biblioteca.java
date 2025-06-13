import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livrosCadastrados;
    private List<Usuario> usuariosCadastrados;
    private List<Emprestimo> emprestimosAtivos;

    public Biblioteca() {
        this.livrosCadastrados = new ArrayList<>();
        this.usuariosCadastrados = new ArrayList<>();
        this.emprestimosAtivos = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livrosCadastrados.add(livro);
        System.out.println("Livro '" + livro.getTitulo() + "' cadastrado com sucesso!");
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuariosCadastrados.add(usuario);
        System.out.println("Usuário '" + usuario.getNome() + "' cadastrado com sucesso!");
    }

    public Emprestimo realizarEmprestimo(Livro livro, Usuario usuario) {
        if (livro.isDisponivel()) {
            Emprestimo novoEmprestimo = new Emprestimo(livro, usuario);
            emprestimosAtivos.add(novoEmprestimo);
            return novoEmprestimo;
        } else {
            System.out.println("Não foi possível realizar o empréstimo: Livro '" + livro.getTitulo() + "' não está disponível.");
            return null;
        }
    }

    public void exibirTodosOsLivros() {
        System.out.println("\n--- Livros Cadastrados na Biblioteca ---");
        if (livrosCadastrados.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            for (Livro livro : livrosCadastrados) {
                livro.exibirInformacoes();
            }
        }
        System.out.println("----------------------------------------");
    }

    public void exibirTodosOsUsuarios() {
        System.out.println("\n--- Usuários Cadastrados na Biblioteca ---");
        if (usuariosCadastrados.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario usuario : usuariosCadastrados) {
                usuario.exibirTipoUsuario();
                System.out.println("----------------------------");
            }
        }
        System.out.println("----------------------------------------");
    }

    public void exibirTodosOsEmprestimosAtivos() {
        System.out.println("\n--- Empréstimos Ativos na Biblioteca ---");
        if (emprestimosAtivos.isEmpty()) {
            System.out.println("Nenhum empréstimo ativo.");
        } else {
            for (Emprestimo emprestimo : emprestimosAtivos) {
                if (emprestimo.getDataDevolucao() == null) { // Apenas empréstimos não devolvidos
                    emprestimo.exibirResumoEmprestimo();
                }
            }
        }
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        Biblioteca minhaBiblioteca = new Biblioteca();

        // 1. Cadastro de Livros
        Livro livro1 = new Livro("Introdução à POO", "João da Silva", "978-85-7522-805-4");
        Livro livro2 = new Livro("Algoritmos e Estruturas de Dados", "Maria Oliveira", "978-85-7522-806-1");
        Livro livro3 = new Livro("Redes de Computadores", "Carlos Souza", "978-85-7522-807-8");

        minhaBiblioteca.cadastrarLivro(livro1);
        minhaBiblioteca.cadastrarLivro(livro2);
        minhaBiblioteca.cadastrarLivro(livro3);

        livro1.exibirInformacoes();
        livro2.exibirInformacoes();

        // 2. Cadastro de um Aluno e um Professor
        Aluno aluno1 = new Aluno("Ana Maria", "12345", "Engenharia de Software");
        Professor professor1 = new Professor("Dr. Pedro Mendes", "P001", "Ciência da Computação");

        minhaBiblioteca.cadastrarUsuario(aluno1);
        minhaBiblioteca.cadastrarUsuario(professor1);

        aluno1.exibirTipoUsuario();
        professor1.exibirTipoUsuario();

        // 3. Empréstimo de Livros
        System.out.println("\n--- Simulando Empréstimos ---");

        Emprestimo emprestimo1 = minhaBiblioteca.realizarEmprestimo(livro1, aluno1);
        if (emprestimo1 != null) {
            emprestimo1.exibirResumoEmprestimo();
        }

        // Tentando emprestar o mesmo livro novamente
        System.out.println("\nTentando emprestar o livro1 novamente (deve falhar):");
        minhaBiblioteca.realizarEmprestimo(livro1, professor1);

        // Empréstimo de outro livro
        Emprestimo emprestimo2 = minhaBiblioteca.realizarEmprestimo(livro2, professor1);
        if (emprestimo2 != null) {
            emprestimo2.exibirResumoEmprestimo();
        }

        // 4. Exibição de dados do empréstimo e dos usuários
        minhaBiblioteca.exibirTodosOsLivros();
        minhaBiblioteca.exibirTodosOsUsuarios();
        minhaBiblioteca.exibirTodosOsEmprestimosAtivos();

        // Simular devolução
        System.out.println("\n--- Simulando Devolução ---");
        if (emprestimo1 != null) {
            emprestimo1.registrarDevolucao();
        }
        livro1.exibirInformacoes(); // Verificar a disponibilidade após a devolução

        // Exibir empréstimos ativos após a devolução
        minhaBiblioteca.exibirTodosOsEmprestimosAtivos();
    }
}
