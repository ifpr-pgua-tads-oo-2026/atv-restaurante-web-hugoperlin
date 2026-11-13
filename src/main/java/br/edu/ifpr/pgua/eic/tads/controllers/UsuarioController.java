package br.edu.ifpr.pgua.eic.tads.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.hugoperlin.results.Resultado;

import br.edu.ifpr.pgua.eic.tads.models.Restaurante;
import br.edu.ifpr.pgua.eic.tads.models.entities.Usuario;
import br.edu.ifpr.pgua.eic.tads.models.repositories.UsuarioRepository;
import io.javalin.http.Context;

public class UsuarioController {
    

    private UsuarioRepository repositorio;

    public UsuarioController(UsuarioRepository repositorio){
        this.repositorio = repositorio;
    }

    public void get(Context ctx){
        System.out.println("Renderizando cadastro.html");
        ctx.render("/usuarios/cadastro.html");
    }

    public void post(Context ctx){
        String nome = ctx.formParam("nome");
        String cpf = ctx.formParam("cpf");
        String email = ctx.formParam("email");
        String telefone = ctx.formParam("telefone");


        Resultado<Usuario> res = repositorio.criar(nome, cpf, email, telefone);

        String mensagem;
        String tipoMensagem;
        if(res.foiSucesso()){
            Usuario u = res.comoSucesso().getObj();
            mensagem = res.getMsg();
            tipoMensagem = "sucesso";
        }else{
            mensagem = res.getMsg();
            tipoMensagem = "erro";
        }


        Map<String,Object> dados = new HashMap<>();

        dados.put("mensagem",mensagem);
        dados.put("tipoMensagem",tipoMensagem);

        ctx.render("/usuarios/cadastro.html",dados);
    }

    public void listar(Context ctx){

        Resultado<List<Usuario>> res = repositorio.listar();

        Map<String,Object> dados = new HashMap<>();

        
        if(res.foiSucesso()){
            List<Usuario> lista = res.comoSucesso().getObj();
            dados.put("usuarios", lista);
        }else{
            dados.put("mensagem",res.getMsg());
        }
        
        
        ctx.render("/usuarios/lista.html",dados);
    }

}
