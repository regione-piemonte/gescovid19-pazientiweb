package it.csi.gestionepazienti.pazientiweb.dto.profilo;

import it.csi.gestionepazienti.pazientiweb.dto.AbstractDto;

public class UtenteArea extends AbstractDto {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column r_utente_area.cf_utente
	 * @mbg.generated
	 */
	private String cfUtente;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column r_utente_area.id_area
	 * @mbg.generated
	 */
	private Integer idArea;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column r_utente_area.cf_utente
	 * @return  the value of r_utente_area.cf_utente
	 * @mbg.generated
	 */
	public String getCfUtente() {
		return cfUtente;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column r_utente_area.cf_utente
	 * @param cfUtente  the value for r_utente_area.cf_utente
	 * @mbg.generated
	 */
	public void setCfUtente(String cfUtente) {
		this.cfUtente = cfUtente;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column r_utente_area.id_area
	 * @return  the value of r_utente_area.id_area
	 * @mbg.generated
	 */
	public Integer getIdArea() {
		return idArea;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column r_utente_area.id_area
	 * @param idArea  the value for r_utente_area.id_area
	 * @mbg.generated
	 */
	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}
}