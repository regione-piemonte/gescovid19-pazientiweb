/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.gestionepazienti.pazientiweb.business.be.postiletto;

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
import it.csi.gestionepazienti.pazientiweb.dto.postiletto.custom.DisponibilitaForReport;

@Path("/postiletto/disponibilita")

@Produces({ "application/json" })


public interface DisponibilitaApi  {


	@GET
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "get lista disponibilita", notes = "", response = DisponibilitaForReport.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco disponibilita", response = DisponibilitaForReport.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoDisponibilitaReport(@ApiParam(value = "" ,required=true)@HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
			   @ApiParam(value = "" ,required=true)@HeaderParam("X-Request-ID") String xRequestID,
			   @ApiParam(value = "" ,required=true)@HeaderParam("X-Codice-Servizio") String xCodiceServizio,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("/transposed")
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "get lista disponibilita", notes = "", response = DisponibilitaForReport.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco disponibilita", response = DisponibilitaForReport.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoDisponibilitaReportTransposed(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("/report/csv")
	@Produces({ "application/csv" })
	@io.swagger.annotations.ApiOperation(value = "get lista disponibilita", notes = "", response = DisponibilitaForReport.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco disponibilita", response = DisponibilitaForReport.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoDisponibilitaReportTransposedCSV(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);


	@GET
	@Path("/report/xlsx")
	@Produces({ "application/xlsx" })
	@io.swagger.annotations.ApiOperation(value = "get lista disponibilita", notes = "", response = DisponibilitaForReport.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco disponibilita", response = DisponibilitaForReport.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoDisponibilitaReportTransposedXlsx(@ApiParam(value = "" ,required=true)@HeaderParam("Shib-Identita-CodiceFiscale") String shibIdentitaCodiceFiscale,
			   @ApiParam(value = "" ,required=true)@HeaderParam("X-Request-ID") String xRequestID,
			   @ApiParam(value = "" ,required=true)@HeaderParam("X-Codice-Servizio") String xCodiceServizio, 
			   @Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

}
