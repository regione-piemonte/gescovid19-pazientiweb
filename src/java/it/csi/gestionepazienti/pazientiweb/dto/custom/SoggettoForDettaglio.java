package it.csi.gestionepazienti.pazientiweb.dto.custom;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import it.csi.gestionepazienti.pazientiweb.dto.Medico;

public class SoggettoForDettaglio extends SoggettoForElenco{

	private List<TamponeForElenco> elencoTampone;
	private List<DecorsoForElenco> elencoDecorso;
	private Long idAura;
	private Medico medico;

	public SoggettoForDettaglio() {
	}
	
	public SoggettoForDettaglio(SoggettoForElenco soggettoForElenco,
			List<TamponeForElenco> elencoTampone,
			List<DecorsoForElenco> elencoDecorso, 
			Medico medico) {
		try {
			BeanUtils.copyProperties(this, soggettoForElenco);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		this.elencoDecorso = elencoDecorso;
		this.elencoTampone = elencoTampone;
		this.medico = medico;
	}

	public List<TamponeForElenco> getElencoTampone() {
		return elencoTampone;
	}

	public void setElencoTampone(List<TamponeForElenco> elencoTampone) {
		this.elencoTampone = elencoTampone;
	}

	public List<DecorsoForElenco> getElencoDecorso() {
		return elencoDecorso;
	}

	public void setElencoDecorso(List<DecorsoForElenco> elencoDecorso) {
		this.elencoDecorso = elencoDecorso;
	}
	
	public Long getIdAura() {
		return idAura;
	}

	public void setIdAura(Long idAura) {
		this.idAura = idAura;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	
}
