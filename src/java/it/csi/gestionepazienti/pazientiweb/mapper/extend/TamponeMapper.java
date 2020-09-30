package it.csi.gestionepazienti.pazientiweb.mapper.extend;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import it.csi.gestionepazienti.pazientiweb.dto.Tampone;
import it.csi.gestionepazienti.pazientiweb.dto.custom.TamponeForElenco;
import it.csi.gestionepazienti.pazientiweb.dto.custom.TamponeForReport;
import it.csi.gestionepazienti.pazientiweb.mapper.generated.BaseTamponeMapper;

public interface TamponeMapper extends BaseTamponeMapper {

	
	@Insert({ "insert into tampone (id_tampone,id_soggetto, id_laboratorio, ", 
		"criterio_epidemiologico_covid19, id_test_covid, ", 
		"id_ris_tamp, ",
		"tampone_autorizzato, data_inserimento_richiesta, ", 
		"data_ultima_modifica, utente_ultima_modifica, ", 
		"data_test, ",
		"medico_richiedente, contatto_richiedente )",
		"values (nextval('seq_id_tampone'),#{idSoggetto,jdbcType=BIGINT}, #{idLaboratorio,jdbcType=BIGINT}, ",
		"#{criterioEpidemiologicoCovid19,jdbcType=VARCHAR}, #{idTestCovid,jdbcType=BIGINT}, ",
		"#{idRisTamp,jdbcType=BIGINT}, ",
		"#{tamponeAutorizzato,jdbcType=VARCHAR}, #{dataInserimentoRichiesta,jdbcType=TIMESTAMP}, ",
		"#{dataUltimaModifica,jdbcType=TIMESTAMP}, #{utenteUltimaModifica,jdbcType=VARCHAR}, ", 
		"#{dataTest,jdbcType=TIMESTAMP}, ",
		"#{medicoRichiedente,jdbcType=VARCHAR}, #{contattoRichiedente,jdbcType=VARCHAR})" 
	})
	@Options(useGeneratedKeys = true, keyProperty = "idTampone")
	int insert(Tampone record);

	
	
	@Select({"<script>",
		" select id_tampone, tampone.id_soggetto,laboratorio.id_laboratorio,data_inserimento_richiesta, "
		+ "soggetto.codice_fiscale, soggetto.cognome, soggetto.nome, soggetto.data_nascita, "
		+ "tampone_autorizzato,  ris_tampone.risultato_tampone risultato_tampone, data_test,"
		+ "tampone.criterio_epidemiologico_covid19, "
		+ "medico_richiedente, contatto_richiedente, "
    	+ " soggetto.comune_residenza_istat, soggetto.comune_domicilio_istat, soggetto.indirizzo_domicilio," 
    	+ " comuni_dom.nome_comune as comune_domicilio_nome, comuni_res.nome_comune as comune_residenza_nome," 
		+ "laboratorio.descrizione laboratorio_descrizione,tampone.id_ris_tamp  " + 
		" from tampone" + 
		" left join soggetto on tampone.id_soggetto = soggetto.id_soggetto" + 
		" left join ris_tampone on tampone.id_ris_tamp = ris_tampone.id_ris_tamp" + 
		" left join laboratorio on tampone.id_laboratorio = laboratorio.id_laboratorio"+
    	" left join comuni comuni_res on soggetto.comune_residenza_istat = comuni_res.istat_comune" +
    	" left join comuni comuni_dom on soggetto.comune_domicilio_istat = comuni_dom.istat_comune" +
	    " <if test='idAsr != -1'> where soggetto.id_asr=#{idAsr,jdbcType=BIGINT} </if>",
	        " order by "
	        + " case when tampone_autorizzato = 'NI' then 0 else 1 end,  "
	        + " data_inserimento_richiesta desc nulls last"
	        + "</script>"
	})
	@Results({
        @Result(column="id_tampone", property="idTampone", jdbcType=JdbcType.BIGINT),
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.BIGINT),
        @Result(column="nome", property="nome", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_nascita", property="dataNascita", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="codice_fiscale", property="codiceFiscale", jdbcType=JdbcType.VARCHAR),
        @Result(column="cognome", property="cognome", jdbcType=JdbcType.VARCHAR),
        @Result(column="medico_richiedente", property="medicoRichiedente", jdbcType=JdbcType.VARCHAR),
        @Result(column="contatto_richiedente", property="contattoRichiedente", jdbcType=JdbcType.VARCHAR),
        @Result(column="data_test", property="dataEsito", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="tampone_autorizzato", property="tamponeAutorizzato", jdbcType=JdbcType.VARCHAR),
		@Result(column = "data_inserimento_richiesta", property = "dataInserimentoRichiesta", jdbcType = JdbcType.TIMESTAMP),
        @Result(column="laboratorio_descrizione", property="laboratorio", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_domicilio_nome", property="comuneDomicilio", jdbcType=JdbcType.VARCHAR),
        @Result(column="comune_residenza_nome", property="comuneResidenza", jdbcType=JdbcType.VARCHAR),
        @Result(column="indirizzo_domicilio", property="indirizzoDomicilio", jdbcType=JdbcType.VARCHAR),
		@Result(column = "criterio_epidemiologico_covid19", property = "criterioEpidemiologicoCovid19", jdbcType = JdbcType.VARCHAR),
        @Result(column="risultato_tampone", property="esitoTampone", jdbcType=JdbcType.VARCHAR)
    })
    List<TamponeForReport> selectForReportByIdAsr(@Param("idAsr") Long idAsr);
	
	
    @Select({
    	"select tampone.id_tampone, id_soggetto, tampone.id_laboratorio, criterio_epidemiologico_covid19, tampone.id_test_covid, ",
       " data_test, tampone.id_ris_tamp, tampone_autorizzato, data_inserimento_richiesta, data_ultima_modifica, utente_ultima_modifica,",
       " laboratorio.descrizione laboratorio_descrizione, ",
	   " medico_richiedente, contatto_richiedente, ",
       " test_covid.test_covid,",
       " ris_tampone.risultato_tampone",
       " from tampone",
       " left join laboratorio on tampone.id_laboratorio = laboratorio.id_laboratorio ", 
       " left join test_covid on tampone.id_test_covid = test_covid.id_test_covid ",
       " left join ris_tampone on tampone.id_ris_tamp = ris_tampone.id_ris_tamp ",
       " where id_soggetto=#{idSoggetto,jdbcType=BIGINT} "
    })
    @Results({
        @Result(column="id_tampone", property="idTampone", jdbcType=JdbcType.BIGINT),
        @Result(column="id_soggetto", property="idSoggetto", jdbcType=JdbcType.BIGINT),
        @Result(column="id_laboratorio", property="idLaboratorio", jdbcType=JdbcType.BIGINT),
        @Result(column="criterio_epidemiologico_covid19", property="criterioEpidemiologicoCovid19", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_test_covid", property="idTestCovid", jdbcType=JdbcType.BIGINT),
        @Result(column="data_test", property="dataTest", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="id_ris_tamp", property="idRisTamp", jdbcType=JdbcType.BIGINT),
        @Result(column="medico_richiedente", property="medicoRichiedente", jdbcType=JdbcType.VARCHAR),
        @Result(column="contatto_richiedente", property="contattoRichiedente", jdbcType=JdbcType.VARCHAR),
        @Result(column="tampone_autorizzato", property="tamponeAutorizzato", jdbcType=JdbcType.VARCHAR),
		@Result(column = "data_inserimento_richiesta", property = "dataInserimentoRichiesta", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "data_ultima_modifica", property = "dataUltimaModifica", jdbcType = JdbcType.TIMESTAMP),
		@Result(column = "utente_ultima_modifica", property = "utenteUltimaModifica", jdbcType = JdbcType.VARCHAR),
        @Result(column="id_laboratorio", property="laboratorio.idLaboratorio", jdbcType=JdbcType.BIGINT),
        @Result(column="laboratorio_descrizione", property="laboratorio.descrizione", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_test_covid", property="testCovid.idTestCovid", jdbcType=JdbcType.BIGINT),
        @Result(column="test_covid", property="testCovid.testCovid", jdbcType=JdbcType.VARCHAR),
        @Result(column="id_ris_tamp", property="risTampone.idRisTamp", jdbcType=JdbcType.BIGINT),
        @Result(column="risultato_tampone", property="risTampone.risultatoTampone", jdbcType=JdbcType.VARCHAR)
    })
    List<TamponeForElenco> selectForElencoByIdSoggetto(Long idSoggetto);
	
    
    
    
}
