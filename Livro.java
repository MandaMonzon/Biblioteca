public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel;

    public Livro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponivel = true; // Livro é criado como disponível
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        if (disponivel) {
            this.disponivel = false;
            System.out.println("Livro '" + titulo + "' emprestado com sucesso!");
        } else {
            System.out.println("Livro '" + titulo + "' não está disponível para empréstimo.");
        }
    }

    public void devolver() {
        if (!disponivel) {
            this.disponivel = true;
            System.out.println("Livro '" + titulo + "' devolvido com sucesso!");
        } else {
            System.out.println("Livro '" + titulo + "' já está disponível.");
        }
    }

    public void exibirInformacoes() {
        System.out.println("--- Informações do Livro ---");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("ISBN: " + isbn);
        System.out.println("Disponível: " + (disponivel ? "Sim" : "Não"));
        System.out.println("----------------------------");
    }
}
