package org.libcg.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbInit {
    public static String[] run() {
        String[] queries = {
            "DROP TABLE IF EXISTS Livro",
            "CREATE TABLE IF NOT EXISTS Livro(id INT PRIMARY KEY AUTO_INCREMENT, titulo VARCHAR(255) NOT NULL, descricao VARCHAR(255) NOT NULL, autor VARCHAR(255) NULL, emprestado BOOLEAN DEFAULT false)",
            "INSERT INTO Livro(titulo, descricao) VALUES('Engenharia de Software Moderna', 'Engenharia de Software Moderna eh um livro-texto destinado a alunos de cursos de graduação em Computacao')",
            "INSERT INTO Livro(titulo, descricao) VALUES('O Pequeno Principe', 'Eh uma novela do escritor, aviador aristocrata frances Antoine de Saint-Exupery')",
            "INSERT INTO Livro(titulo, descricao) VALUES('Romeu e Julieta', 'Eh uma novela do escritor, aviador aristocrata frances Antoine de Saint-Exupery')",
        };

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/lib_db")) {
            for (String query : queries) {
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.executeUpdate();
                }
            }
            System.out.println("Banco de dados inicializado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return queries;
    }
}
