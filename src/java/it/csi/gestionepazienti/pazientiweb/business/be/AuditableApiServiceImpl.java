package it.csi.gestionepazienti.pazientiweb.business.be;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import it.csi.gestionepazienti.pazientiweb.business.SpringApplicationContextHelper;
import it.csi.gestionepazienti.pazientiweb.business.service.BackendService;
import it.csi.gestionepazienti.pazientiweb.dto.AbstractDto;
import it.csi.gestionepazienti.pazientiweb.dto.custom.Audit;
import it.csi.gestionepazienti.pazientiweb.dto.custom.TamponeForReportPlain;
import it.csi.gestionepazienti.pazientiweb.mapper.extend.AuditMapper;
import it.csi.gestionepazienti.pazientiweb.util.GenericUtils;
import it.csi.gestionepazienti.pazientiweb.util.SpringSupportedResource;
import it.csi.gestionepazienti.pazientiweb.util.csv.CleanStringSerializer;
import it.csi.gestionepazienti.pazientiweb.util.csv.LocalizedPropertyNamingStrategy;

public abstract class AuditableApiServiceImpl extends SpringSupportedResource {

	public Logger log = Logger.getLogger(getClass());
	
	ObjectMapper mapper = null;
	
	@Autowired
    private MessageSource messageSource;

	@Autowired
	public BackendService beService;

	
	public AuditableApiServiceImpl() {
		super();
		mapper = new ObjectMapper();
	}

	protected void insertAudit(String action, String table, String descrizione, String user, 
								Object dto, HttpServletRequest req) {
		AuditMapper auditMapper = (AuditMapper) SpringApplicationContextHelper.getBean("AuditMapper");
		Audit audit = new Audit();
		audit.setIp(GenericUtils.getIpAddress(req));
		audit.setAction(action);
		if (dto==null)
			audit.setDescription(descrizione);
		else {
			String descr = descrizione;
			try {
				 descr = descr + "[" +mapper.writeValueAsString(dto) +"]";
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			audit.setDescription(descr);
		}
		audit.setTable(table);
		audit.setUser(user);
		auditMapper.insert(audit);
	}
	
	
	protected void insertAudit(String action, String table, String descrizione, String user, String xRequestId, String xCodiceServizio) {
		AuditMapper auditMapper = (AuditMapper) SpringApplicationContextHelper.getBean("AuditMapper");
		Audit audit = new Audit();
		audit.setIp(xRequestId);
		audit.setAction(action);
		
		audit.setDescription("Logout su "+xCodiceServizio+" ]");
		
		audit.setTable(table);
		audit.setUser(user);
		auditMapper.insert(audit);
	}
	
	public String convertObjectsToCsv(List<? extends AbstractDto> obj) {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Locale locale = LocaleContextHolder.getLocale();
			if(obj!=null && obj.size()>0) {
				CsvMapper mapper = new CsvMapper();
				mapper.disable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
				mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
				mapper.setDateFormat(df);
				mapper.setPropertyNamingStrategy(new LocalizedPropertyNamingStrategy(messageSource, locale));
				CsvSchema schema = mapper.schemaFor(obj.get(0).getClass());
				SimpleModule module = new SimpleModule();
				module.addSerializer(String.class, new CleanStringSerializer());
				mapper.registerModule(module);				
				schema = schema.withColumnSeparator(';');
				schema = schema.withUseHeader(true);
				schema = schema.withQuoteChar('"');
				String csv = mapper.writer(schema).writeValueAsString(obj);
				return csv;
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "CSV conversion error";
		}
	}

	public BackendService getBeService() {
	//	if (beService==null) {
	//  		beService = (BackendService)SpringApplicationContextHelper.getBean("backendService");
	//  	}
			return beService;
		}

	public void setBeService(BackendService beService) {
		this.beService = beService;
	}


}