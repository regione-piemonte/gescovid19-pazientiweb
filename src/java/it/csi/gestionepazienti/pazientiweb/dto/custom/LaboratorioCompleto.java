package it.csi.gestionepazienti.pazientiweb.dto.custom;

import it.csi.gestionepazienti.pazientiweb.dto.Laboratorio;

public class LaboratorioCompleto extends Laboratorio {

	private Integer tamponiDaLavorare;

	public Integer getTamponiDaLavorare() {
		return tamponiDaLavorare;
	}

	public void setTamponiDaLavorare(Integer tamponiDaLavorare) {
		this.tamponiDaLavorare = tamponiDaLavorare;
	}


}
