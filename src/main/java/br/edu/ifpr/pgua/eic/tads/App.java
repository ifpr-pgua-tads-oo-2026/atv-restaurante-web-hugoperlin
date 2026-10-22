package br.edu.ifpr.pgua.eic.tads;

import br.edu.ifpr.pgua.eic.tads.controllers.FuncionarioController;
import br.edu.ifpr.pgua.eic.tads.controllers.IndexController;
import br.edu.ifpr.pgua.eic.tads.controllers.UsuarioController;
import br.edu.ifpr.pgua.eic.tads.models.Restaurante;
import br.edu.ifpr.pgua.eic.tads.utils.JavalinUtils;
import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        var app = JavalinUtils.makeApp(8080);
        
        Restaurante restaurante = new Restaurante();

        IndexController indexController = new IndexController();
        UsuarioController usuariosController = new UsuarioController(restaurante);
        FuncionarioController funcionariosController = new FuncionarioController(restaurante);
        
        app.get("/", indexController::get);

        app.get("/usuarios/cadastro",usuariosController::get);
        app.post("/usuarios/cadastro",usuariosController::post);

        app.get("/funcionarios/cadastro",funcionariosController::get);
        app.post("/funcionarios/cadastro",funcionariosController::post);

        
    }
}
