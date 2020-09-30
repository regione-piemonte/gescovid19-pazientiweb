package it.csi.gestionepazienti.pazientiweb.dto.custom;

import it.csi.gestionepazienti.pazientiweb.dto.Soggetto;

public class SoggettoForSegnalazione extends Soggetto{

	private Long idAura;
	private DecorsoSintomo decorso;

	
	public Long getIdAura() {
		return idAura;
	}

	public void setIdAura(Long idAura) {
		this.idAura = idAura;
	}

	public DecorsoSintomo getDecorso() {
		return decorso;
	}

	public void setDecorso(DecorsoSintomo decorso) {
		this.decorso = decorso;
	}

	
}
