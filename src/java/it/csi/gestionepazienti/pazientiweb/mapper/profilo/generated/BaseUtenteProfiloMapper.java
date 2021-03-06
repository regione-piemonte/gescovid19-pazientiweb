package it.csi.gestionepazienti.pazientiweb.mapper.profilo.generated;

import it.csi.gestionepazienti.pazientiweb.dto.profilo.UtenteProfilo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface BaseUtenteProfiloMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table r_utente_profilo
	 * @mbg.generated
	 */
	@Delete({ "delete from r_utente_profilo", "where cf_utente = #{cfUtente,jdbcType=VARCHAR}",
			"and id_profilo = #{idProfilo,jdbcType=INTEGER}" })
	int deleteByPrimaryKey(@Param("cfUtente") String cfUtente, @Param("idProfilo") Integer idProfilo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table r_utente_profilo
	 * @mbg.generated
	 */
	@Insert({ "insert into r_utente_profilo (cf_utente, id_profilo)",
			"values (#{cfUtente,jdbcType=VARCHAR}, #{idProfilo,jdbcType=INTEGER})" })
	int insert(UtenteProfilo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table r_utente_profilo
	 * @mbg.generated
	 */
	@Select({ "select", "cf_utente, id_profilo", "from r_utente_profilo" })
	@Results({ @Result(column = "cf_utente", property = "cfUtente", jdbcType = JdbcType.VARCHAR, id = true),
			@Result(column = "id_profilo", property = "idProfilo", jdbcType = JdbcType.INTEGER, id = true) })
	List<UtenteProfilo> selectAll();
}