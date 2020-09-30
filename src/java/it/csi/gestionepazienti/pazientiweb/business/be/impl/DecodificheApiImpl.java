package it.csi.gestionepazienti.pazientiweb.business.be.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.gestionepazienti.pazientiweb.business.be.DecodificheApi;
import it.csi.gestionepazienti.pazientiweb.business.service.BackendService;
import it.csi.gestionepazienti.pazientiweb.dto.Asl;
import it.csi.gestionepazienti.pazientiweb.dto.Asr;
import it.csi.gestionepazienti.pazientiweb.dto.Comuni;
import it.csi.gestionepazienti.pazientiweb.dto.DecodeTipoEvento;
import it.csi.gestionepazienti.pazientiweb.dto.EsitoDimissioni;
import it.csi.gestionepazienti.pazientiweb.dto.Laboratorio;
import it.csi.gestionepazienti.pazientiweb.dto.RepartoRicovero;
import it.csi.gestionepazienti.pazientiweb.dto.RisTampone;
import it.csi.gestionepazienti.pazientiweb.dto.TestCovid;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.AslMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.AsrMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.ComuniMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.DecodeTipoEventoMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.EsitoDimissioniMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.LaboratorioMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.RepartoRicoveroMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.RisTamponeMapper;
//import it.csi.gestionepazienti.pazientiweb.mapper.extend.SoggettoMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.TestCovidMapper;
import it.csi.gestionepazienti.pazientiweb.util.SpringSupportedResource;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DecodificheApiImpl extends SpringSupportedResource implements DecodificheApi{

	private static final int ID_LABOR_ALTRI = 6;
	
	//@Autowired
	public BackendService beService;

	public BackendService getBeService() {
//	if (beService==null) {
//  		beService = (BackendService)SpringApplicationContextHelper.getBean("backendService");
//  	}
		return beService;
	}

	public void setBeService(BackendService beService) {
		this.beService = beService;
	}	
	
	
	@Autowired
	AsrMapper asrMapper;
	
	@Autowired
	AslMapper aslMapper;
	
	@Override
	public Response getElencoAsl(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req) {
		try {
			List<Asl> aslList = aslMapper.selectAll();
			return Response.ok(aslList).build();
		} catch (Exception e) {
			System.err.println(e);
			return Response.serverError().build();
		}

	}


	
	@Override
	public Response getElencoAsr(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req) {
		try {
			List<Asr> asrList = asrMapper.selectAll();
			return Response.ok(asrList).build();
		} catch (Exception e) {
			System.err.println(e);
			return Response.serverError().build();
		}

	}

	
	@Autowired
	ComuniMapper comuniMapper;
	
	@Override
	public Response getElencoComuni(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req) {
		try {
			List<Comuni> comuniList = comuniMapper.selectAll();
			return Response.ok(comuniList).build();
		} catch (Exception e) {
			System.err.println(e);
			return Response.serverError().build();
		}

	}
	
	
	
	@Autowired
	TestCovidMapper testCovidMapper;
	
	@Override
	public Response getElencoTestCovid(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req) {
		try {
			List<TestCovid> retList = testCovidMapper.selectAll();
			return Response.ok(retList).build();
		} catch (Exception e) {
			System.err.println(e);
			return Response.serverError().build();
		}

	}	
	

	
	@Autowired
	RepartoRicoveroMapper repartoRicoveroMapper;
	
	@Override
	public Response getElencoRepartoRicovero(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req) {
		try {
			List<RepartoRicovero> retList = repartoRicoveroMapper.selectAll();
			return Response.ok(retList).build();
		} catch (Exception e) {
			System.err.println(e);
			return Response.serverError().build();
		}

	}	
	
	
	@Autowired
	RisTamponeMapper risTamponeMapper;
	
	@Override
	public Response getElencoRisTampone(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req) {
		try {
			List<RisTampone> retList = risTamponeMapper.selectAll();
			return Response.ok(retList).build();
		} catch (Exception e) {
			System.err.println(e);
			return Response.serverError().build();
		}

	}		
	
	
	
	
	@Autowired
	EsitoDimissioniMapper esitoDimissioniMapper;
	
	@Override
	public Response getElencoEsitoDimissioni(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req) {
		try {
			List<EsitoDimissioni> retList = esitoDimissioniMapper.selectAll();
			return Response.ok(retList).build();
		} catch (Exception e) {
			System.err.println(e);
			return Response.serverError().build();
		}

	}		
		
	
	@Autowired
	LaboratorioMapper laboratorioMapper;
	
	@Override
	public Response getElencoLaboratorio(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req) {
		try {
			List<Laboratorio> retList = laboratorioMapper.selectAll();
			List<Laboratorio> retListSenzaAltri = new ArrayList<Laboratorio>();
			for (Laboratorio laboratorio : retList) {
				if (laboratorio.getIdLaboratorio().intValue()!=ID_LABOR_ALTRI)
					retListSenzaAltri.add(laboratorio);
			}
			return Response.ok(retListSenzaAltri).build();
		} catch (Exception e) {
			System.err.println(e);
			return Response.serverError().build();
		}

	}	
	
	@Autowired
	DecodeTipoEventoMapper decodeTipoEventoMapper;
	
	@Override
	public Response getElencoTipoEvento(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req) {
		try {
			List<DecodeTipoEvento> retList = decodeTipoEventoMapper.selectAll();
			return Response.ok(retList).build();
		} catch (Exception e) {
			System.err.println(e);
			return Response.serverError().build();
		}

	}	

}
