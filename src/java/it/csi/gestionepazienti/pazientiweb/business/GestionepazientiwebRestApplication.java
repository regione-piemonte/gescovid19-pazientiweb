package it.csi.gestionepazienti.pazientiweb.business;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import it.csi.gestionepazienti.pazientiweb.business.be.impl.CurrentUserApiServiceImpl;
import it.csi.gestionepazienti.pazientiweb.business.be.impl.DecodificheApiImpl;
//import it.csi.gestionepazienti.pazientiweb.business.be.impl.LaboratorioApiServiceImpl;
import it.csi.gestionepazienti.pazientiweb.business.be.impl.LocalLogoutApiServiceImpl;
import it.csi.gestionepazienti.pazientiweb.business.be.impl.PingApiServiceImpl;
//import it.csi.gestionepazienti.pazientiweb.business.be.impl.SoggettoApiServiceImpl;
//import it.csi.gestionepazienti.pazientiweb.business.be.impl.TamponeApiServiceImpl;
import it.csi.gestionepazienti.pazientiweb.business.be.postiletto.impl.DecodeAreaApiServiceImpl;
import it.csi.gestionepazienti.pazientiweb.business.be.postiletto.impl.DisponibilitaApiServiceImpl;
import it.csi.gestionepazienti.pazientiweb.business.be.postiletto.impl.EnteApiServiceImpl;
import it.csi.gestionepazienti.pazientiweb.business.be.postiletto.impl.StrutturaApiServiceImpl;
//import it.csi.gestionepazienti.pazientiweb.business.be.visurammg.impl.MmgVisuraSoggettoApiServiceImpl;
//import it.csi.gestionepazienti.pazientiweb.business.be.visurapazienti.impl.VisuraSoggettoApiServiceImpl;
import it.csi.gestionepazienti.pazientiweb.util.SpringInjectorInterceptor;
import it.csi.gestionepazienti.pazientiweb.util.SpringSupportedResource;

@ApplicationPath("api")
public class GestionepazientiwebRestApplication extends Application {
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public GestionepazientiwebRestApplication() {
		// singletons.add(new GestionepazientiwclBE());
		
		singletons.add(new PingApiServiceImpl());
		singletons.add(new LocalLogoutApiServiceImpl());
		singletons.add(new CurrentUserApiServiceImpl());
		//singletons.add(new SoggettoApiServiceImpl());
		//singletons.add(new TamponeApiServiceImpl());

		//singletons.add(new DecodificheApiImpl());
		
		// api posti letto
		singletons.add(new DisponibilitaApiServiceImpl());
		singletons.add(new DecodeAreaApiServiceImpl());
		singletons.add(new EnteApiServiceImpl());
		
		//singletons.add(new VisuraSoggettoApiServiceImpl());

		//singletons.add(new MmgVisuraSoggettoApiServiceImpl());

		//singletons.add(new LaboratorioApiServiceImpl());
		singletons.add(new SpringInjectorInterceptor());
		singletons.add(new StrutturaApiServiceImpl());

		for (Object c : singletons) {
			if (c instanceof SpringSupportedResource) {
				SpringApplicationContextHelper.registerRestEasyController(c);
			}
		}
	}

	@Override
	public Set<Class<?>> getClasses() {
		return empty;
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
