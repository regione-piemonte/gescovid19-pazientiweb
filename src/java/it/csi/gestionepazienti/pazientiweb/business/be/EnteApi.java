/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.gestionepazienti.pazientiweb.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/ente")

@Produces({ "application/json" })


public interface EnteApi  {

		
	@GET
	@Produces({ "application/json" })
	public Response getElencoEnti(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);
	
}
