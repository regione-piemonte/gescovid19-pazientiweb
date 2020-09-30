package it.csi.gestionepazienti.pazientiweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.blueconic.browscap.Capabilities;
import com.blueconic.browscap.ParseException;
import com.blueconic.browscap.UserAgentParser;
import com.blueconic.browscap.UserAgentService;

import it.csi.gestionepazienti.pazientiweb.business.SpringApplicationContextHelper;
import it.csi.gestionepazienti.pazientiweb.dto.Sindaco;
import it.csi.gestionepazienti.pazientiweb.dto.custom.Audit;
import it.csi.gestionepazienti.pazientiweb.dto.custom.UserLogged;
import it.csi.gestionepazienti.pazientiweb.dto.profilo.Profilo;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.AuditMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.MedicoMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.SindacoMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.UtentiMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.profilo.extend.ProfiloMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.profilo.extend.UtenteAreaMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.profilo.extend.UtenteEnteMapper;
import it.csi.gestionepazienti.pazientiweb.mapper.profilo.extend.UtenteStrutturaMapper;
import it.csi.gestionepazienti.pazientiweb.util.Constants;
import it.csi.gestionepazienti.pazientiweb.util.GenericUtils;

public class AbstractIrideIdAdapterFilter {


	UserAgentParser parser = null;
	
	protected static final Logger LOG = Logger.getLogger(Constants.COMPONENT_NAME + ".security");
	public AbstractIrideIdAdapterFilter() {
		super();
		try {
			parser = new UserAgentService().loadParser();
		} catch (Exception e) {
			LOG.error("[IrideIdAdapterFilter::loadUser] error parsing browser", e);
		} // handle IOException and ParseException
	}

	protected UserLogged loadUser(String  userIdentifier, String nome, String cognome, ServletRequest req, String applicazione) {
		LOG.info("[IrideIdAdapterFilter::loadUser] user  identifier:" + userIdentifier);
		UtentiMapper userMapper = (UtentiMapper) SpringApplicationContextHelper.getBean("UtentiMapper");
		ProfiloMapper profiloMapper = (ProfiloMapper) SpringApplicationContextHelper.getBean("ProfiloMapper");
		UtenteEnteMapper utenteEnteMapper = (UtenteEnteMapper) SpringApplicationContextHelper.getBean("UtenteEnteMapper");
		UtenteStrutturaMapper utenteStrutturaMapper  = (UtenteStrutturaMapper) SpringApplicationContextHelper.getBean("UtenteStrutturaMapper");
		UtenteAreaMapper utenteAreaMapper = (UtenteAreaMapper) SpringApplicationContextHelper.getBean("UtenteAreaMapper");
		SindacoMapper sindacoMapper = (SindacoMapper) SpringApplicationContextHelper.getBean("SindacoMapper");
		MedicoMapper medicoMapper= (MedicoMapper) SpringApplicationContextHelper.getBean("MedicoMapper");
		
		String browser="";
		String os="";
		try {
			Capabilities cap = parser.parse(((HttpServletRequest) req).getHeader("User-Agent"));
			browser = cap.getBrowser()+"(ver:"+cap.getBrowserMajorVersion()+")";
			os = cap.getPlatform()+"(ver:"+cap.getPlatformVersion()+")";
		} catch (Exception e) {
			LOG.error("[IrideIdAdapterFilter::loadUser] error parsing browser", e);
			
		} // handle IOException and ParseException


		UserLogged userLogged = userMapper.selectByCf(userIdentifier);
		if (userLogged==null) {
			LOG.info("[IrideIdAdapterFilter::loadUser] user " + userIdentifier+" is null!");
			userLogged = new UserLogged();
		}
		else {
			LOG.info("[IrideIdAdapterFilter::loadUser] user " + userIdentifier+" is not null");
			AuditMapper auditMapper = (AuditMapper) SpringApplicationContextHelper.getBean("AuditMapper");
			Audit audit = new Audit();
			audit.setIp(GenericUtils.getIpAddress((HttpServletRequest) req));
			audit.setAction("login");
			audit.setDescription("Login su "+applicazione+" ["+browser+" on "+os +"]");
			audit.setTable("utenti");
			audit.setUser(userLogged.getCfUtente());
			auditMapper.insert(audit);
			LOG.info("[IrideIdAdapterFilter::loadUser] user " + userIdentifier+" audited");
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