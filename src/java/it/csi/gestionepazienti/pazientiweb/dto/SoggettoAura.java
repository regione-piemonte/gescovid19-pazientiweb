package it.csi.gestionepazienti.pazientiweb.dto;

public class SoggettoAura extends AbstractDto {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column r_soggetto_aura.id_soggetto
	 * @mbg.generated
	 */
	private Long idSoggetto;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column r_soggetto_aura.id_aura
	 * @mbg.generated
	 */
	private Long idAura;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column r_soggetto_aura.id_soggetto
	 * @return  the value of r_soggetto_aura.id_soggetto
	 * @mbg.generated
	 */
	public Long getIdSoggetto() {
		return idSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column r_soggetto_aura.id_soggetto
	 * @param idSoggetto  the value for r_soggetto_aura.id_soggetto
	 * @mbg.generated
	 */
	public void setIdSoggetto(Long idSoggetto) {
		this.idSoggetto = idSoggetto;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column r_soggetto_aura.id_aura
	 * @return  the value of r_soggetto_aura.id_aura
	 * @mbg.generated
	 */
	public Long getIdAura() {
		return idAura;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column r_soggetto_aura.id_aura
	 * @param idAura  the value for r_soggetto_aura.id_aura
	 * @mbg.generated
	 */
	public void setIdAura(Long idAura) {
		this.idAura = idAura;
	}
}