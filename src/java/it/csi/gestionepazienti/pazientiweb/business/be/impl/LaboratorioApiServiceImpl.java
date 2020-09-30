package it.csi.gestionepazienti.pazientiweb.business.be.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.csi.gestionepazienti.pazientiweb.business.be.AuditableApiServiceImpl;
import it.csi.gestionepazienti.pazientiweb.business.be.LaboratorioApi;
//import it.csi.gestionepazienti.pazientiweb.business.be.SoggettoApi;
import it.csi.gestionepazienti.pazientiweb.business.be.TamponeApi;
import it.csi.gestionepazienti.pazientiweb.dto.Decorso;
import it.csi.gestionepazienti.pazientiweb.dto.Soggetto;
import it.csi.gestionepazienti.pazientiweb.dto.Tampone;
import it.csi.gestionepazienti.pazientiweb.dto.Utenti;
import it.csi.gestionepazienti.pazientiweb.dto.custom.DecorsoForElenco;
import it.csi.gestionepazienti.pazientiweb.dto.custom.LaboratorioCompleto;
import it.csi.gestionepazienti.pazientiweb.dto.custom.SoggettoForDettaglio;
import it.csi.gestionepazienti.pazientiweb.dto.custom.SoggettoForElenco;
import it.csi.gestionepazienti.pazientiweb.dto.custom.SoggettoForElencoPlain;
import it.csi.gestionepazienti.pazientiweb.dto.custom.TamponeForElenco;
import it.csi.gestionepazienti.pazientiweb.dto.custom.TamponeForReport;
import it.csi.gestionepazienti.pazientiweb.dto.custom.TamponeForReportPlain;
import it.csi.gestionepazienti.pazientiweb.dto.custom.UserLogged;
import it.csi.gestionepazienti.pazientiweb.dto.util.Message;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.DecorsoMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.LaboratorioMapper;
//import it.csi.gestionepazienti.pazientiweb.mapper.extend.SoggettoMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.TamponeMapper;
import it.csi.gestionepazienti.pazientiweb.util.SpringSupportedResource;;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)

public class LaboratorioApiServiceImpl extends AuditableApiServiceImpl implements LaboratorioApi {

	@Autowired
	LaboratorioMapper laboratorioMapper;


	@Autowired
	private MessageSource messageSource;

	
	
	@Override
	public Response getElencoLaboratori(SecurityContext securityContext, HttpHeaders httpHeaders,
			HttpServletRequest req) {
		try {
			
			UserLogged currentUser = getBeService().getCurrentUser(req);
			List<LaboratorioCompleto> laboratoriList = laboratorioMapper.selectAllWithCarico();
			insertAudit("select", "laboratori", "selectAllWithCarico()", currentUser.getCfUtente(), null, req);

			return Response.ok(laboratoriList).build();


		} catch (Exception e) {
			log.error("Errore recupero laboratori", e);
			return Response.serverError().entity(new Message("Errore recupero laboratori")).build();
		}

	}
	


}
