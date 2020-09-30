package it.csi.gestionepazienti.pazientiweb.dto.custom;

import it.csi.gestionepazienti.pazientiweb.dto.Laboratorio;
import it.csi.gestionepazienti.pazientiweb.dto.RisTampone;
import it.csi.gestionepazienti.pazientiweb.dto.Tampone;
import it.csi.gestionepazienti.pazientiweb.dto.TestCovid;

public class TamponeForElenco extends Tampone {

	private Laboratorio laboratorio;
	private TestCovid	testCovid;
	private RisTampone  risTampone;
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public TestCovid getTestCovid() {
		return testCovid;
	}
	public void setTestCovid(TestCovid testCovid) {
		this.testCovid = testCovid;
	}
	public RisTampone getRisTampone() {
		return risTampone;
	}
	public void setRisTampone(RisTampone risTampone) {
		this.risTampone = risTampone;
	}
	
	
	
}
