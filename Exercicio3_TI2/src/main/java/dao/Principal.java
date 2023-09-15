package dao;

import model.Jogador;

public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();

		
		//Inserir um jogador
		Jogador jogador = new Jogador(11, "Dudu", "Futebol","Palmeiras");
		if(dao.inserirJogador(jogador) == true) {
			System.out.println("Inserção com sucesso -> " + jogador.toString());
		}
		
		//Atualizar jogador
		jogador.setEsporte("nova esporte");
		dao.atualizarJogador(jogador);
		
		//Excluir jogador
		dao.excluirJogador(jogador.getID());
		
		//Mostrar jogadores
		Jogador [] jogadores = dao.getJogadores();
		System.out.println("==== Mostrar usuários === ");		
		for(int i = 0; i < jogadores.length; i++) {
			System.out.println(jogadores[i].toString());
		}
		
		dao.close();
	}
}
