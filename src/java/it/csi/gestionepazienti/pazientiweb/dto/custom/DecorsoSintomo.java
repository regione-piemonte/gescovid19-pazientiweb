package it.csi.gestionepazienti.pazientiweb.dto.custom;

import it.csi.gestionepazienti.pazientiweb.dto.Decorso;
import it.csi.gestionepazienti.pazientiweb.dto.Sintomo;

public class DecorsoSintomo extends Decorso {
	
	private Sintomo sintomo;

	public Sintomo getSintomo() {
		return sintomo;
	}

	public void setSintomo(Sintomo sintomo) {
		this.sintomo = sintomo;
	}
	

	
}
