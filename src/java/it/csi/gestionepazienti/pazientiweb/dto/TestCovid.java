package it.csi.gestionepazienti.pazientiweb.dto;

public class TestCovid extends AbstractDto {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column test_covid.id_test_covid
	 * @mbg.generated
	 */
	private Long idTestCovid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column test_covid.test_covid
	 * @mbg.generated
	 */
	private String testCovid;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column test_covid.id_test_covid
	 * @return  the value of test_covid.id_test_covid
	 * @mbg.generated
	 */
	public Long getIdTestCovid() {
		return idTestCovid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column test_covid.id_test_covid
	 * @param idTestCovid  the value for test_covid.id_test_covid
	 * @mbg.generated
	 */
	public void setIdTestCovid(Long idTestCovid) {
		this.idTestCovid = idTestCovid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column test_covid.test_covid
	 * @return  the value of test_covid.test_covid
	 * @mbg.generated
	 */
	public String getTestCovid() {
		return testCovid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column test_covid.test_covid
	 * @param testCovid  the value for test_covid.test_covid
	 * @mbg.generated
	 */
	public void setTestCovid(String testCovid) {
		this.testCovid = testCovid;
	}
}