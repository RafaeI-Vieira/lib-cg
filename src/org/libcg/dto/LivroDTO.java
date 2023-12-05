package org.libcg.dto;

public class LivroDTO {
    private final Integer id;
    private final String titulo;
    private final String descricao;
    private final String autor;
    private final Boolean emprestado;
    
    public LivroDTO(String titulo, String descricao, String autor) {
        this.id = 0;
        this.titulo = titulo;
        this.descricao = descricao;
        this.autor = autor;
        this.emprestado = true;
    }
    
    public LivroDTO(Integer id, String titulo, String descricao, String autor, Boolean emprestado) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.autor = autor;
        this.emprestado = emprestado;
    }
    public LivroDTO(int id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = null;
        this.autor = null;
        this.emprestado = null; 
    }
    public LivroDTO(Integer id, String novoTitulo, String novaDescricao, String novoAutor) {
        this.id = id;
        this.titulo = novoTitulo;
        this.descricao = novaDescricao;
        this.autor = novoAutor;
        this.emprestado = true; // Você pode definir o emprestado como desejar
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAutor() {
        return autor;
    }
    public Boolean estaEmprestado() {
        return emprestado;
    }
}
