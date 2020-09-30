package it.csi.gestionepazienti.pazientiweb.business.service;

import javax.servlet.http.HttpServletRequest;


import it.csi.gestionepazienti.pazientiweb.dto.custom.UserLogged;

public interface BackendService {

	public String getMessage();

	public UserLogged getCurrentUser(HttpServletRequest req);
	
	public UserLogged getCurrentUser(String cf, String xRequestID, String xCodiceServizio);

	public String localLogout(HttpServletRequest req);
}
