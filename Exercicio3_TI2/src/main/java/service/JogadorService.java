package service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import dao.DAO;
import model.Jogador;
import spark.Request;
import spark.Response;


public class JogadorService {

	private DAO jogadorDAO;

	public JogadorService() {
		try {
			jogadorDAO = new JogadorDAO("Jogador.dat");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public Object add(Request request, Response response) {
		String descricao = request.queryParams("Nome");
		String Esporte = request.queryParams("Esporte");
		String Clube = request.queryParams("Clube");

		int ID = jogadorDAO.getMaxID() + 1;

		Jogador jogador = new Jogador(ID, , Esporte, Clube);

		jogadorDAO.add(jogador);

		response.status(201); // 201 Created
		return id;
	}

	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.params(":id"));
		
		Jogador jogador = (Jogador) jogadorDAO.get(id);
		
		if (produto != null) {
    	    response.header("Content-Type", "application/xml");
    	    response.header("Content-Encoding", "UTF-8");

            return "<jogador>\n" + 
            		"\t<id>" + jogador.getID() + "</id>\n" +
            		"\t<nome>" + jogador.getNome() + "</nome>\n" +
            		"\t<esporte>" + jogador.getEsporte() + "</esporte>\n" +
            		"\t<clube>" + jogador.getClube() + "</clube>\n" +
            		"</jogador>\n";
        } else {
            response.status(404); // 404 Not found
            return "Jogador " + ID + " não encontrado.";
        }

	}

	public Object update(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));
        
		Jogador jogador = (jogador) jogadorDAO.get(id);

        if (jogador != null) {
        	jogador.setNome(request.queryParams("nome"));
        	jogador.setEsporte("esporte");
        	jogador.setClube("clube");

        	jogadorDAO.update(jogador);
        	
            return id;
        } else {
            response.status(404); // 404 Not found
            return "Jogador não encontrado.";
        }

	}

	public Object remove(Request request, Response response) {
        int id = Integer.parseInt(request.params(":id"));

        Jogador jogador = (Jogador) jogadorDAO.get(id);

        if (jogador != null) {

            jogadorDAO.remove(jogador);

            response.status(200); // success
        	return id;
        } else {
            response.status(404); // 404 Not found
            return "Jogador não encontrado.";
        }
	}

	public Object getAll(Request request, Response response) {
		StringBuffer returnValue = new StringBuffer("<produtos type=\"array\">");
		for (Jogador jogador : jogadorDAO.getAll()) {
			returnValue.append("\n<jogador>\n" + 
            		"\t<id>" + jogador.getID() + "</id>\n" +
            		"\t<nome>" + jogador.getNome() + "</nome>\n" +
            		"\t<esporte>" + jogador.getEsporte() + "</esporte>\n" +
            		"\t<clube>" + jogador.getClube() + "</clube>\n" +
            		"</jogador>\n");
		}
		returnValue.append("</jogador>");
	    response.header("Content-Type", "application/xml");
	    response.header("Content-Encoding", "UTF-8");
		return returnValue.toString();
	}
}
