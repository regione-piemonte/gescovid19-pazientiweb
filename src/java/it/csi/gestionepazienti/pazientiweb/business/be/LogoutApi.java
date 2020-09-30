/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.gestionepazienti.pazientiweb.business.be;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import io.swagger.annotations.ApiParam;
import it.csi.gestionepazienti.pazientiweb.dto.util.Message;

@Path("/localLogout")

@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the locallogout API")

public interface LogoutApi {


	@GET
	public Message localLogout(@ApiParam(value = "" ,required=true)@HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
			   				   @ApiParam(value = "" ,required=true)@HeaderParam("X-Request-ID") String xRequestID,
			                   @ApiParam(value = "" ,required=true)@HeaderParam("X-Codice-Servizio") String xCodiceServizio,
			                   @Context HttpServletRequest req);
}
