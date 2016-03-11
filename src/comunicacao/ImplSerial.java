package comunicacao;

/**
 * @author Luiz de Queiroz
 * @version 1.0 
 */

import fachada.OFacade;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;

import java.io.OutputStream;

public class ImplSerial {

	private String nomePorta;
	private SerialPort porta;
	private int baudrate, timeout;
	private boolean escrita;
	private CommPortIdentifier cpi;
	private OutputStream saida;

	public ImplSerial(String porta, int baudrate, int timeout) {
		this.nomePorta = porta;
		this.baudrate = baudrate;
		this.timeout = timeout;
	}

	public void ativarEscrita() {
		escrita = true;
	}

	public void obterPortaId() {

		try {
			cpi = CommPortIdentifier.getPortIdentifier(nomePorta);
			System.out.println("ID da Porta " + nomePorta + ": Okay!");
			OFacade.mensagemParaVisual("ID da Prota: Obtido!");
			if (cpi == null) {
				System.out.println("Erro na porta");
				OFacade.mensagemParaVisual(OFacade.pegarTextoDoVisual() + "\nErro na porta! Não obtida!");
			}
		} catch (Exception erro) {
			System.out.println("Erro obtendo ID da porta: " + erro);
			OFacade.mensagemParaVisual(OFacade.pegarTextoDoVisual() + "\nErro obtendo ID: " + erro + " - Não obtida!");
		}
	}

	public void abrirPorta() {
		try {
			porta = (SerialPort) cpi.open("ImplSerial", timeout);
			porta.setSerialPortParams(baudrate, SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
			porta.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);
			System.out.println("Porta aberta: SUCESSO!");
			OFacade.mensagemParaVisual(OFacade.pegarTextoDoVisual() + "\nEstado da porta " + nomePorta + ": Aberta!");
		} catch (Exception erro) {
			System.out.println("Erro ao abrir porta: " + erro);
			OFacade.mensagemParaVisual(OFacade.pegarTextoDoVisual() + "\nErro abrindo a porta: " + erro + " - Não aberta!");
		}
	}

	public void enviarMsg(int msg) {
		if (escrita == true) {
			try {
				saida = porta.getOutputStream();
				System.out.println("FLUXO DE SAÍDA -> OKAY!");
				OFacade.mensagemParaVisual(OFacade.pegarTextoDoVisual() + "\nFLUXO DE SAÍDA -> OKAY!");
			} catch (Exception erro) {
				System.out.println("Erro. STATUS: " + erro);
				OFacade.mensagemParaVisual(OFacade.pegarTextoDoVisual() + "\nErro no fluxo de saída: " + erro);
			}
			try {
				saida.write(msg);
				Thread.sleep(10);
				saida.flush();
				
				System.out.println("Enviando um byte para " + nomePorta);
				System.out.println("Enviado: " + msg);
				OFacade.mensagemParaVisual(OFacade.pegarTextoDoVisual() + "\nEnviando uma mensagem/byte para " + nomePorta
						+ "\nEnviado: " + msg);
			} catch (Exception erro) {
				System.out.println("Houve um erro durante o envio. ");
				System.out.println("STATUS: " + erro);
				OFacade.mensagemParaVisual(OFacade.pegarTextoDoVisual() + "\nHouve um erro durante o envio. Erro: " + erro);
			}
		} else {
			System.exit(1);
		}
	}

	public void fecharPorta() {
		try {
			porta.close();
			OFacade.mensagemParaVisual(OFacade.pegarTextoDoVisual() + "\nEstado da porta " + nomePorta + ": Fechada!");
			System.out.println("Porta fechada!");
		} catch (Exception erro) {
			System.out.println("Erro fechando porta: " + erro);
			OFacade.mensagemParaVisual(OFacade.pegarTextoDoVisual() + "\nErro ao fechar porta.  Erro: "
					+ erro);
		}
	}
}
