package it.csi.gestionepazienti.pazientiweb.filter;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import it.csi.gestionepazienti.pazientiweb.business.SpringApplicationContextHelper;
import it.csi.gestionepazienti.pazientiweb.dto.Utenti;
import it.csi.gestionepazienti.pazientiweb.dto.custom.Audit;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.AuditMapper;

public class SessionCounterListener implements HttpSessionListener {
 
	public Utenti getCurrentUser(HttpSession sess) {
		return (Utenti) sess.getAttribute(IrideIdAdapterFilter.USERINFO_SESSIONATTR);

	}

	
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
    }
 
    @Override
    public void sessionDestroyed(HttpSessionEvent sessionEvent) {
    	Utenti ut = getCurrentUser(sessionEvent.getSession());
    	if (ut!=null) {
			AuditMapper auditMapper = (AuditMapper) SpringApplicationContextHelper.getBean("AuditMapper");
			Audit audit = new Audit();
			audit.setIp("0.0.0.0");
			audit.setAction("logout");
			audit.setDescription("Logout su gestione pazienti");
			audit.setTable("utenti");
			audit.setUser(ut.getCfUtente());
			auditMapper.insert(audit);
    	}
    }	
  
    

}