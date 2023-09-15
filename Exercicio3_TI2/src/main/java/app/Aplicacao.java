package app;

import static spark.Spark.*;

import service.JogadorService;

public class Aplicacao {
	
	private static JogadorService jogadorService = new JogadorService();
	
    public static void main(String[] args) {
        port(6789);

        post("/jogador", (request, response) -> jogadorService.add(request, response));

        get("/jogador/:id", (request, response) -> jogadorService.get(request, response));

        get("/jogador/update/:id", (request, response) -> jogadorService.update(request, response));

        get("/jogador/delete/:id", (request, response) -> jogadorService.remove(request, response));

        get("/jogador", (request, response) -> jogadorService.getAll(request, response));
               
    }
}
