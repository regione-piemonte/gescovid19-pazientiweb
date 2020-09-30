package it.csi.gestionepazienti.pazientiweb.business.be.impl;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;

import it.csi.gestionepazienti.pazientiweb.business.be.CurrentUserApi;
import it.csi.gestionepazienti.pazientiweb.business.service.BackendService;
import it.csi.gestionepazienti.pazientiweb.dto.custom.UserLogged;
import it.csi.gestionepazienti.pazientiweb.util.SpringSupportedResource;

public class CurrentUserApiServiceImpl extends SpringSupportedResource implements CurrentUserApi {

	public Response getCurrentUser(String shibIdentitaCodiceFiscale, String xRequestID,
			String xCodiceServizio, SecurityContext securityContext, HttpHeaders httpHeaders, HttpServletRequest req) {

		UserLogged currentUser = getBeService().getCurrentUser(shibIdentitaCodiceFiscale,xRequestID, xCodiceServizio);
		return Response.ok(currentUser).build();
	}

	@Autowired
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


}
