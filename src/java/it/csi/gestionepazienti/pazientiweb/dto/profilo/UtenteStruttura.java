package it.csi.gestionepazienti.pazientiweb.dto.profilo;

import it.csi.gestionepazienti.pazientiweb.dto.AbstractDto;

public class UtenteStruttura extends AbstractDto {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column r_utente_struttura.cf_utente
     *
     * @mbg.generated
     */
    private String cfUtente;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column r_utente_struttura.id_struttura
     *
     * @mbg.generated
     */
    private String idStruttura;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column r_utente_struttura.cf_utente
     *
     * @return the value of r_utente_struttura.cf_utente
     *
     * @mbg.generated
     */
    public String getCfUtente() {
        return cfUtente;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column r_utente_struttura.cf_utente
     *
     * @param cfUtente the value for r_utente_struttura.cf_utente
     *
     * @mbg.generated
     */
    public void setCfUtente(String cfUtente) {
        this.cfUtente = cfUtente;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column r_utente_struttura.id_struttura
     *
     * @return the value of r_utente_struttura.id_struttura
     *
     * @mbg.generated
     */
    public String getIdStruttura() {
        return idStruttura;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column r_utente_struttura.id_struttura
     *
     * @param idStruttura the value for r_utente_struttura.id_struttura
     *
     * @mbg.generated
     */
    public void setIdStruttura(String idStruttura) {
        this.idStruttura = idStruttura;
    }
}