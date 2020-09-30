package it.csi.gestionepazienti.pazientiweb.business.impl;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.blueconic.browscap.Capabilities;

import it.csi.gestionepazienti.pazientiweb.business.SpringApplicationContextHelper;
import it.csi.gestionepazienti.pazientiweb.business.service.BackendService;
import it.csi.gestionepazienti.pazientiweb.dto.custom.Audit;
import it.csi.gestionepazienti.pazientiweb.dto.custom.UserLogged;
import it.csi.gestionepazienti.pazientiweb.filter.IrideIdAdapterFilter;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.AuditMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.MedicoMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.SindacoMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.UtentiMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.profilo.extend.ProfiloMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.profilo.extend.UtenteAreaMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.profilo.extend.UtenteEnteMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.profilo.extend.UtenteStrutturaMapper;
import it.csi.gestionepazienti.pazientiweb.util.GenericUtils;
import it.csi.gestionepazienti.pazientiweb.util.SpringSupportedResource;

@Component
@Qualifier("provaprovaprova")
public class BackendServiceImpl extends SpringSupportedResource implements BackendService {

	public String getMessage() {
		return "ping!!!!!";
	}

	@Value("${logout.url}")
	private String logoutUrl;

	public UserLogged getCurrentUser(HttpServletRequest req) {
		return (UserLogged) req.getSession().getAttribute(IrideIdAdapterFilter.USERINFO_SESSIONATTR);
		//return null;
	}

	
	
	public UserLogged getCurrentUser(String codicefiscale, String xRequestID, String xCodiceServizio) {
		
		UserLogged  user = loadUser(codicefiscale,xRequestID, xCodiceServizio); 
		
		// verifica per l'applicazione  covid
		//
		
		/**
		 * Raffa 24-04-2020:si toglie il filtro sul profilo, tutti vedono tutto
		 */
		/**
		 * 
		
		
		user.setEnabled(
				GenericUtils.currentUserHasProfilo(user, 1) // unita di crisi
				||
				GenericUtils.currentUserHasProfilo(user, 5) // direttore asl
				);
				
				
		 */	
		user.setEnabled(true);
		
		return user;
	}

	public String localLogout(HttpServletRequest req) {
		// User res = getCurrentUser(req);
		req.getSession().invalidate();
		System.out.println("\n\n\n\nSessione invalidata !!! Redirect to "+ logoutUrl);
		return logoutUrl;
	}
	
	
	protected UserLogged loadUser(String  userIdentifier, String xRequestID, String xCodiceServizio) {
		
		System.out.println("[BackendService::loadUser] user  identifier:" + userIdentifier);
		
		UtentiMapper userMapper = (UtentiMapper) SpringApplicationContextHelper.getBean("UtentiMapper");
		ProfiloMapper profiloMapper = (ProfiloMapper) SpringApplicationContextHelper.getBean("ProfiloMapper");
		UtenteEnteMapper utenteEnteMapper = (UtenteEnteMapper) SpringApplicationContextHelper.getBean("UtenteEnteMapper");
		UtenteStrutturaMapper utenteStrutturaMapper  = (UtenteStrutturaMapper) SpringApplicationContextHelper.getBean("UtenteStrutturaMapper");
		UtenteAreaMapper utenteAreaMapper = (UtenteAreaMapper) SpringApplicationContextHelper.getBean("UtenteAreaMapper");
		SindacoMapper sindacoMapper = (SindacoMapper) SpringApplicationContextHelper.getBean("SindacoMapper");
		MedicoMapper medicoMapper= (MedicoMapper) SpringApplicationContextHelper.getBean("MedicoMapper");
		
		UserLogged userLogged = userMapper.selectByCf(userIdentifier);
		if (userLogged==null) {
			System.out.println("[BackendService::loadUser] user " + userIdentifier+" is null!");
			userLogged = new UserLogged();
		}
		else {
			System.out.println("[BackendService::loadUser] user " + userIdentifier+" is not null");
			AuditMapper auditMapper = (AuditMapper) SpringApplicationContextHelper.getBean("AuditMapper");
			Audit audit = new Audit();
			audit.setIp(xRequestID);
			audit.setAction("login");
			audit.setDescription("Login su "+xCodiceServizio+" ]");
			audit.setTable("utenti");
			audit.setUser(userLogged.getCfUtente());
			auditMapper.insert(audit);
			System.out.println("[BackendService::loadUser] user " + userIdentifier+" audited");
			userLogged.setEnabled(false);  // TO SET a TRUE from implementation
			userLogged.setElencoProfilo(profiloMapper.selectElencoProfiloByCodiceFiscale(userLogged.getCfUtente()));
			userLogged.setElencoEnte(utenteEnteMapper.selectElencoEnteProfiloByCodiceFiscale(userLogged.getCfUtente()));
			userLogged.setElencoStruttura(utenteStrutturaMapper.selectElencoStrutturaDaEnteProfiloByCodiceFiscale(userLogged.getCfUtente()));
			//userLogged.setElencoStruttura(utenteStrutturaMapper.selectElencoStrutturaProfiloByCodiceFiscale(userLogged.getCfUtente()));
			userLogged.setElencoArea(utenteAreaMapper.selectElencoAreaProfiloByCodiceFiscale(userLogged.getCfUtente()));
			userLogged.setSindaco(sindacoMapper.selectByCodiceFiscale(userLogged.getCfUtente()));
			userLogged.setMedico(medicoMapper.selectByCodiceFiscale(userLogged.getCfUtente()));
		}
	

		return userLogged;
		
	}
}
