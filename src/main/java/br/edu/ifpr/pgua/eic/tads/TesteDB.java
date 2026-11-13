package br.edu.ifpr.pgua.eic.tads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.models.FabricaConexoes;
import br.edu.ifpr.pgua.eic.tads.models.daos.UsuarioDao;
import br.edu.ifpr.pgua.eic.tads.models.daos.UsuarioDaoImpl;
import br.edu.ifpr.pgua.eic.tads.models.entities.Usuario;
import br.edu.ifpr.pgua.eic.tads.models.repositories.UsuarioRepository;
import br.edu.ifpr.pgua.eic.tads.models.repositories.UsuarioRepositoryImpl;

public class TesteDB {
    

    public static void main(String[] args) {

        UsuarioDao dao = new UsuarioDaoImpl(FabricaConexoes.getInstance());
        
        UsuarioRepository usuarioRep = new UsuarioRepositoryImpl(dao);

        Resultado<Usuario> res = usuarioRep.criar("Zé", "123.456", "ze@teste.com", "1234");

        System.out.println(res.getMsg());

    }

}
