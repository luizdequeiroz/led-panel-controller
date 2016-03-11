package fachada;

import visual.FxManager;

import comunicacao.ImplSerial;
import comunicacao.SerialPorts;

public class OFacade {

	private static ImplSerial is;

	public OFacade(String porta) {
		is = new ImplSerial(porta, 9600, 0);
	}
	
	public void conectar() {

		is.obterPortaId();
		is.abrirPorta();
	}

	public void escrever(String msg) {

		is.ativarEscrita();
		
		for(int i = 0; i < msg.length(); i++){
			
			is.enviarMsg(msg.charAt(i));
		}
	}

	public void desconectar() {
		
		is.fecharPorta();
	}
		
	public static class ListarPortas {

		public ListarPortas(){
			SerialPorts cs = new SerialPorts();
			cs.listarPortas();
			String[] portas = cs.obterPortas();
			
			FxManager.listarPortas(portas);
		}
	}
	
	int pv = ';';

	public void enviarCoord(int coord) {
		
		int bool = 'V';
		
		is.ativarEscrita();
		is.enviarMsg(coord);
		is.enviarMsg(bool);
		is.enviarMsg(pv);
	}
	
	public void enviar2Coord(int coord1, int coord2) {
		
		int bool = 'V';

		is.ativarEscrita();
		is.enviarMsg(coord1);
		is.enviarMsg(coord2);
		is.enviarMsg(bool);
		is.enviarMsg(pv);
	}

	public void apagarCoord(int coord) {
		
		int bool = 'F';
		
		is.ativarEscrita();
		is.enviarMsg(coord);
		is.enviarMsg(bool);
		is.enviarMsg(pv);
	}
	
	public void apagar2Coord(int coord1, int coord2) {

		int bool = 'F';
		
		is.ativarEscrita();
		is.enviarMsg(coord1);
		is.enviarMsg(coord2);
		is.enviarMsg(bool);
		is.enviarMsg(pv);
	}
	
	public static void mensagemParaVisual(String str){
		
		FxManager.consoleMensagem(str);
	}
	
	public static String pegarTextoDoVisual(){
		
		return FxManager.pegarTextoConsole();
	}
	
}
