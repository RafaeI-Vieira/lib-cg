package org.libcg.views.livro;

import org.libcg.controllers.LivroController;
import org.libcg.core.View;
import org.libcg.dto.LivroDTO;

import java.util.Scanner;

public class AtualizaNomeLivroScreen extends View {
    private final Scanner scanner;

    public AtualizaNomeLivroScreen() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void render() {
        System.out.print("Digite o ID do livro a ser atualizado: ");
        int id = this.scanner.nextInt();
        this.scanner.nextLine(); // Consumir quebra de linha
    
        System.out.print("Digite o novo título do livro: ");
        String novoTitulo = this.scanner.nextLine();
    
        System.out.print("Digite a nova descrição do livro: ");
        String novaDescricao = this.scanner.nextLine();

        System.out.print("Digite o novo autor do livro: ");
        String novoAutor = this.scanner.nextLine();
    
        LivroDTO livro = new LivroDTO(id, novoTitulo, novaDescricao, novoAutor);
    
        LivroController livroController = this.app.make(LivroController.class);
        livroController.atualizarNomeLivro(livro);
        livroController.principal();
    }

}
