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

import it.csi.gestionepazienti.pazientiweb.dto.Asr;
import it.csi.gestionepazienti.pazientiweb.dto.Comuni;
import it.csi.gestionepazienti.pazientiweb.dto.DecodeTipoEvento;
import it.csi.gestionepazienti.pazientiweb.dto.EsitoDimissioni;
import it.csi.gestionepazienti.pazientiweb.dto.Laboratorio;
import it.csi.gestionepazienti.pazientiweb.dto.RepartoRicovero;
import it.csi.gestionepazienti.pazientiweb.dto.RisTampone;


@Path("/decodifiche")

@Produces({ "application/json" })

public interface DecodificheApi {

	@GET
	@Path("asr")
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "get lista asr", notes = "", response = Asr.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco asr", response = Asr.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoAsr(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	@GET
	@Path("asl")
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "get lista asr", notes = "", response = Asr.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco asr", response = Asr.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoAsl(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	
	@GET
	@Path("comuni")
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "get lista comuni", notes = "", response = Comuni.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco comuni", response = Comuni.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoComuni(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);
	
	@GET
	@Path("testcovid")
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "get lista test covid", notes = "", response = Comuni.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco testcovid", response = Comuni.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoTestCovid(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);

	
	@GET
	@Path("repartoricovero")
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "get lista reparto ricovero", notes = "", response = RepartoRicovero.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco reparto ricovero", response = RepartoRicovero.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoRepartoRicovero(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);
	
	@GET
	@Path("ristampone")
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "get lista risultato tampone", notes = "", response = RisTampone.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco risultato tampone", response = RisTampone.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoRisTampone(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);
	
	
	@GET
	@Path("esitodimissioni")
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "get lista esito dimissioni", notes = "", response = EsitoDimissioni.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco esito dimissioni", response = EsitoDimissioni.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoEsitoDimissioni(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);	
	
	
	
	@GET
	@Path("laboratorio")
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "get lista Laboratorio", notes = "", response = Laboratorio.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco Laboratorio", response = Laboratorio.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoLaboratorio(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);	

	@GET
	@Path("tipoevento")
	@Produces({ "application/json" })
	@io.swagger.annotations.ApiOperation(value = "get lista tipo evento", notes = "", response = DecodeTipoEvento.class, tags = { "TOH", })
	@io.swagger.annotations.ApiResponses(value = { @io.swagger.annotations.ApiResponse(code = 200, message = "Elenco evento", response = DecodeTipoEvento.class),
	@io.swagger.annotations.ApiResponse(code = 200, message = "Unexpected error", response = String.class) })
	public Response getElencoTipoEvento(@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders, @Context HttpServletRequest req);	
}
