package it.csi.gestionepazienti.pazientiweb.dto.custom;

import it.csi.gestionepazienti.pazientiweb.dto.Comuni;
import it.csi.gestionepazienti.pazientiweb.dto.Sindaco;

public class SindacoComune extends Sindaco{

	private Comuni comune;

	public Comuni getComune() {
		return comune;
	}

	public void setComune(Comuni comune) {
		this.comune = comune;
	}
	
	
}
