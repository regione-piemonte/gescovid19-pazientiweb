package it.csi.gestionepazienti.pazientiweb.dto.custom;

import it.csi.gestionepazienti.pazientiweb.dto.Asr;
import it.csi.gestionepazienti.pazientiweb.dto.Comuni;
import it.csi.gestionepazienti.pazientiweb.dto.Soggetto;

public class SoggettoForElenco extends Soggetto{

	private Asr asr;
	private Comuni comuneDomicilio;
	private Comuni comuneResidenza;
	private int numeroCampioni;
	private int numeroDecorsi;
	private int ultimoIdTipoEvento;
	
	public int getNumeroDecorsi() {
		return numeroDecorsi;
	}
	public void setNumeroDecorsi(int numeroDecorsi) {
		this.numeroDecorsi = numeroDecorsi;
	}
	public Asr getAsr() {
		return asr;
	}
	public void setAsr(Asr asr) {
		this.asr = asr;
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
	public int getNumeroCampioni() {
		return numeroCampioni;
	}
	public void setNumeroCampioni(int numeroCampioni) {
		this.numeroCampioni = numeroCampioni;
	}
	public int getUltimoIdTipoEvento() {
		return ultimoIdTipoEvento;
	}
	public void setUltimoIdTipoEvento(int ultimoIdTipoEvento) {
		this.ultimoIdTipoEvento = ultimoIdTipoEvento;
	}
	
	
	
}
