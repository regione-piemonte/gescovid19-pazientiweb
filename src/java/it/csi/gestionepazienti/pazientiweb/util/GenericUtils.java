package it.csi.gestionepazienti.pazientiweb.util;

import javax.servlet.http.HttpServletRequest;

import it.csi.gestionepazienti.pazientiweb.dto.custom.UserLogged;
import it.csi.gestionepazienti.pazientiweb.dto.profilo.Profilo;

public class GenericUtils {
	
	public static int ID_PROFILO_UNITA_CRISI = 1;
	public static int ID_PROFILO_GESTORE_PAZIENTI = 4;
	public static int ID_PROFILO_SUPERUSER_PAZIENTI = 6;
	public static int ID_PROFILO_DIRETTORE_ASL= 5;
	public static int ID_PROFILO_SINDACO = 8;
	public static int ID_PROFILO_MEDICO_MMG = 15;
	
	public static String getIpAddress(HttpServletRequest req) {
		String ip = "0.0.0.0";
		try {
		    ip = req.getHeader("X-Forwarded-For").split(",")[0];
		} catch (Exception ignored){
			ip = req.getRemoteAddr();
		}
		return ip;
	}
	
	public static boolean currentUserHasProfilo(UserLogged user, int idProfilo)
	{
		if (user.getElencoProfilo()!=null)
		{
			for (Profilo profilo : user.getElencoProfilo()) {
				if (profilo.getIdProfilo().equals(idProfilo)) 
				{
					return true;
				}
			}
		}
		
		return false;
	}
}
