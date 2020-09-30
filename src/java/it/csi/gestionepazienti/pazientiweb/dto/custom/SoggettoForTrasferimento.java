package it.csi.gestionepazienti.pazientiweb.dto.custom;

import it.csi.gestionepazienti.pazientiweb.dto.Asr;
import it.csi.gestionepazienti.pazientiweb.dto.Comuni;
import it.csi.gestionepazienti.pazientiweb.dto.DecodeTipoEvento;
import it.csi.gestionepazienti.pazientiweb.dto.Decorso;
import it.csi.gestionepazienti.pazientiweb.dto.Soggetto;
import it.csi.gestionepazienti.pazientiweb.dto.postiletto.Area;
import it.csi.gestionepazienti.pazientiweb.dto.postiletto.Ente;
import it.csi.gestionepazienti.pazientiweb.dto.postiletto.Struttura;

public class SoggettoForTrasferimento extends Soggetto {

	private Asr asr;
	private Decorso decorso;
	private Area area;
	private Struttura struttura;
	private Ente ente;
	private DecodeTipoEvento tipoEvento;
	private Comuni comuneRicovero;

	public SoggettoForTrasferimento() {
		super();
	}

	public Asr getAsr() {
		return asr;
	}

	public void setAsr(Asr asr) {
		this.asr = asr;
	}

	public Decorso getDecorso() {
		return decorso;
	}

	public void setDecorso(Decorso decorso) {
		this.decorso = decorso;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Struttura getStruttura() {
		return struttura;
	}

	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}

	public Ente getEnte() {
		return ente;
	}

	public void setEnte(Ente ente) {
		this.ente = ente;
	}

	public DecodeTipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(DecodeTipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Comuni getComuneRicovero() {
		return comuneRicovero;
	}

	public void setComuneRicovero(Comuni comuneRicovero) {
		this.comuneRicovero = comuneRicovero;
	}

}
