/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.gestionepazienti.pazientiweb.business.be.postiletto;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/postiletto/struttura")

@Produces({ "application/json" })


public interface StrutturaApi  {


	@GET
	@Path("{id}/area")
	@Produces({ "application/json" })
	public Response getElencoAreeByIdStruttura(@PathParam(value="id") String id, @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Produces({ "application/json" })
	@Path("/nonacuta")
	public Response getElencoStrutturaRicettiva(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);
	

	//    @GET
//    @Path("/report/csv")
//    @Produces({ "text/csv" })
//    public Response getTableCSV( @QueryParam("table") String table, @QueryParam("lang") String lang, @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
//
//    @GET
//    @Path("/report/table")
//    @Produces({ "application/json" })
//    public Response getTable( @QueryParam("table") String table,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders , @Context HttpServletRequest httpRequest );
}
