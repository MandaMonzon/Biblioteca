**Sistema de Gerenciamento de Biblioteca em Java**
Este projeto simples implementa um sistema básico de *gerenciamento de biblioteca* usando os princípios da Programação Orientada a Objetos (POO) em Java. Ele permite cadastrar livros, usuários (alunos e professores) e gerenciar o empréstimo e devolução de livros.

**Estrutura do Projeto**
O sistema é dividido nas seguintes classes:
**Livro**: Representa um livro com atributos como título, autor, ISBN e disponibilidade.
**Usuario**: Uma classe abstrata base para usuários, com atributos como nome e ID.
**Aluno**: Estende Usuario e adiciona o atributo curso.
**Professor**: Estende Usuario e adiciona o atributo departamento.
**Emprestimo:** Registra as informações de um empréstimo, incluindo o livro, o usuário, a data de empréstimo e a data de devolução.
**Biblioteca**: A classe principal que simula o sistema, contendo listas de livros, usuários e empréstimos, e a lógica para as operações.

**Conceitos de POO**
**Herança**: Criar novas classes a partir de classes existentes, reutilizando e estendendo funcionalidades.
**Encapsulamento**: Agrupar dados e métodos em uma única unidade, escondendo os detalhes internos.
**Abstração**:Focar no que um objeto faz, em vez de como ele faz, simplificando a complexidade.
**Polimorfismo**: Capacidade de objetos de diferentes classes responderem ao mesmo método de formas distintas.
