package it.csi.gestionepazienti.pazientiweb.business.be.impl;

import javax.servlet.http.HttpServletRequest;

import it.csi.gestionepazienti.pazientiweb.business.be.AuditableApiServiceImpl;
import it.csi.gestionepazienti.pazientiweb.business.be.LogoutApi;
import it.csi.gestionepazienti.pazientiweb.dto.custom.UserLogged;
import it.csi.gestionepazienti.pazientiweb.dto.util.Message;

public class LocalLogoutApiServiceImpl extends AuditableApiServiceImpl implements LogoutApi {


	@Override
	public Message localLogout(String shibIdentitaCodiceFiscale, 
							   String xRequestID,
							   String xCodiceServizio, 
							   HttpServletRequest req) {
		
		UserLogged currentUser = getBeService().getCurrentUser(shibIdentitaCodiceFiscale, xRequestID, xCodiceServizio);

		insertAudit("logout", "utenti", "Logout su gestione pazienti", currentUser.getCfUtente(), xRequestID, xCodiceServizio);
		return new Message(beService.localLogout(req));
	}

}
