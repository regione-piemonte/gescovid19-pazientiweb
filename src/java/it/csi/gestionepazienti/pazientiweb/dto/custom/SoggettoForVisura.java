package it.csi.gestionepazienti.pazientiweb.dto.custom;

import it.csi.gestionepazienti.pazientiweb.dto.Comuni;
import it.csi.gestionepazienti.pazientiweb.dto.Tampone;

public class SoggettoForVisura extends SoggettoForTrasferimento {

	private Tampone tampone;
	private Comuni comuneDomicilio;
	private Comuni comuneResidenza;


	public Tampone getTampone() {
		return tampone;
	}

	public void setTampone(Tampone tampone) {
		this.tampone = tampone;
	}

	public Comuni getComuneDomicilio() {
		return comuneDomicilio;
	}

	public void setComuneDomicilio(Comuni comuneDomicilio) {
		this.comuneDomicilio = comuneDomicilio;
	}

	public Comuni getComuneResidenza() {
		return comuneResidenza;
	}

	public void setComuneResidenza(Comuni comuneResidenza) {
		this.comuneResidenza = comuneResidenza;
	}


}