package it.csi.gestionepazienti.pazientiweb.dto;

public class RisTampone extends AbstractDto {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ris_tampone.id_ris_tamp
	 * @mbg.generated
	 */
	private Long idRisTamp;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ris_tampone.risultato_tampone
	 * @mbg.generated
	 */
	private String risultatoTampone;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ris_tampone.id_ris_tamp
	 * @return  the value of ris_tampone.id_ris_tamp
	 * @mbg.generated
	 */
	public Long getIdRisTamp() {
		return idRisTamp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ris_tampone.id_ris_tamp
	 * @param idRisTamp  the value for ris_tampone.id_ris_tamp
	 * @mbg.generated
	 */
	public void setIdRisTamp(Long idRisTamp) {
		this.idRisTamp = idRisTamp;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ris_tampone.risultato_tampone
	 * @return  the value of ris_tampone.risultato_tampone
	 * @mbg.generated
	 */
	public String getRisultatoTampone() {
		return risultatoTampone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ris_tampone.risultato_tampone
	 * @param risultatoTampone  the value for ris_tampone.risultato_tampone
	 * @mbg.generated
	 */
	public void setRisultatoTampone(String risultatoTampone) {
		this.risultatoTampone = risultatoTampone;
	}
}