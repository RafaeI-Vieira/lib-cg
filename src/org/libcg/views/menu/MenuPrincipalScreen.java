package org.libcg.views.menu;

import org.libcg.controllers.LivroController;
import org.libcg.core.View;
import org.libcg.views.livro.AtualizaNomeLivroScreen;

public class MenuPrincipalScreen extends View {
    @Override
    public void render() {
        System.out.println("Bem vindo a loja virtual da Biblioteca CG!");
        System.out.println("Digite 1 para acessar a área de livros.");
        System.out.println("Digite 2 para atualizar o nome de um livro.");
        System.out.println("Digite 0 para sair.");
        System.out.println("=====================================");
        System.out.print("> ");
        int opcao = this.scanner.nextInt();
        
        LivroController livroController = this.app.make(LivroController.class);
        AtualizaNomeLivroScreen atualizaNome = new AtualizaNomeLivroScreen(); // Instância da classe AtualizaNomeLivroScreen
        
        switch(opcao) {
            case 1 -> livroController.principal();
            case 2 -> {
                atualizaNome.render(); // Chamada do método render da classe AtualizaNomeLivroScreen
                // Ou, se desejar chamar apenas o método de atualizar nome:
                // atualizaNome.atualizarNomeLivro(id, novoTitulo);
            }
            default -> System.out.println("Saindo...");
        }
    }
}
