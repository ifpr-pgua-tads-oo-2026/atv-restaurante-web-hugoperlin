package br.edu.ifpr.pgua.eic.tads.controllers;

import br.edu.ifpr.pgua.eic.tads.models.Restaurante;
import io.javalin.http.Context;

public class UsuarioController {
    

    private Restaurante restaurante;

    public UsuarioController(Restaurante restaurante){
        this.restaurante = restaurante;
    }

    public void get(Context ctx){
        ctx.render("/usuarios/cadastro.html");
    }

    public void post(Context ctx){
        String nome = ctx.formParam("nome");
        String cpf = ctx.formParam("cpf");
        String email = ctx.formParam("email");
        String telefone = ctx.formParam("telefone");

        Boolean ret = restaurante.cadastrarUsuario(nome, email, telefone, cpf);

        ctx.result(ret.toString());
    }

}
