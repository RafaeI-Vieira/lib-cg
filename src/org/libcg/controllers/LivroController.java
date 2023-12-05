package org.libcg.controllers;

import java.sql.SQLException;
import java.util.List;
import org.libcg.core.Controller;
import org.libcg.dto.LivroDTO;

import org.libcg.models.Livro;
import org.libcg.views.livro.CadastraLivroScreen;
import org.libcg.views.livro.ListaLivroScreen;
import org.libcg.views.livro.LivrosPrincipalScreen;
import org.libcg.views.livro.MostraLivroScreen;

public class LivroController extends Controller {
    
    @Override
    public void principal() {
        LivrosPrincipalScreen view = new LivrosPrincipalScreen();
        
        view.render();
    }

    public void listar() {
        List<Livro> livros = Livro.findAll(Livro.class);
        List<LivroDTO> livroDTO = livros.stream()
                .map(livro -> new LivroDTO(
                        livro.getId(), 
                        livro.getTitulo(), 
                        livro.getDescricao(), 
                        livro.estaEmprestado()
                )).toList();
        
        ListaLivroScreen view = new ListaLivroScreen(livroDTO);
            
        view.render();
    }
    
    public void mostarLivro(int id) {
        Livro livro = Livro.findOne(id, Livro.class);
        LivroDTO livroDTO = new LivroDTO(
                        livro.getId(), 
                        livro.getTitulo(), 
                        livro.getDescricao(), 
                        livro.estaEmprestado()
        );
        
        MostraLivroScreen view = new MostraLivroScreen(livroDTO);
            
        view.render();
    }
    
    public void emprestar(LivroDTO livroDTO) {
        Livro livro = Livro.findOne(livroDTO.getId(), Livro.class);
        
        livro.emprestar();
        
        livro.save();
    }
    public void atualizarNomeLivro(LivroDTO livroDTO) {
        // Encontra o livro pelo ID
        Livro livro = Livro.findOne(livroDTO.getId(), Livro.class);

        if (livro != null) {
            livro.setTitulo(livroDTO.getTitulo());
            livro.setDescricao(livroDTO.getDescricao());

            livro.save();
        } else {
            System.out.println("Livro não encontrado para atualização.");
        }
    }
    
    
    public void cadastrar() {
        CadastraLivroScreen view = new CadastraLivroScreen();
        
        view.render();
    }
    
    public void guardar(LivroDTO livroDTO) {
        Livro livro = new Livro(livroDTO.getTitulo(), livroDTO.getDescricao());
        
        livro.save();
    }

    public void excluirLivro(int codigoLivroExcluir) throws SQLException {
        Livro livro = Livro.findOne(codigoLivroExcluir, Livro.class);

        if (livro != null) {
            livro.delete();
            System.out.println("Livro excluído com sucesso!");
        } else {
            System.out.println("Livro não encontrado para exclusão.");
        }

    }

}
