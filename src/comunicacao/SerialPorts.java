package comunicacao;

/**
 * @author Luiz de Queiroz
 * @version 1.0
 */

import java.util.Enumeration;
import gnu.io.CommPortIdentifier;

public class SerialPorts {

	protected String[] portas;
	@SuppressWarnings("rawtypes")
	protected Enumeration listaDePortas;
	
	public SerialPorts() {
		listaDePortas = CommPortIdentifier.getPortIdentifiers();
	}
	
	public void listarPortas() {
		
		int i = 0;
        	portas = new String[10];
        	while (listaDePortas.hasMoreElements()) {
            		CommPortIdentifier cpi = (CommPortIdentifier)listaDePortas.nextElement();
            		portas[i] = cpi.getName();
            		i++;
        	}
	}

	public String[] obterPortas() {
		
		return portas;
	}

}
