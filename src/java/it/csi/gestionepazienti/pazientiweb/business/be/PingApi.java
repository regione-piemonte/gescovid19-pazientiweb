/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.gestionepazienti.pazientiweb.business.be;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/ping")

@Produces({ "application/json" })
@io.swagger.annotations.Api(description = "the ping API")

public interface PingApi {

	@GET

	@Produces({ "plain/text" })
	@io.swagger.annotations.ApiOperation(value = "servizio di ping del backend", notes = "Restituisce una stringa per confermare la disponibilità del backend", response = String.class, tags = {
			"TOH", })
	@io.swagger.annotations.ApiResponses(value = {
			@io.swagger.annotations.ApiResponse(code = 200, message = "stringa di conferma funzionamento", response = String.class),

			@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response ping(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders);
}
