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
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import io.swagger.annotations.ApiParam;
import it.csi.gestionepazienti.pazientiweb.dto.Utenti;
import it.csi.gestionepazienti.pazientiweb.dto.util.Message;

@Path("/currentUser")

@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the currentUser API")

public interface CurrentUserApi {

	@GET

	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "get current user", notes = "restituisce l'utente corrente", response = Utenti.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "l'utente corrente", response = Utenti.class),

			@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getCurrentUser(@ApiParam(value = "" ,required=true)@HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
								   @ApiParam(value = "" ,required=true)@HeaderParam("X-Request-ID") String xRequestID,
								   @ApiParam(value = "" ,required=true)@HeaderParam("X-Codice-Servizio") String xCodiceServizio, 
								   @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);


}
