package it.csi.gestionepazienti.pazientiweb.mapper.profilo.generated;

import it.csi.gestionepazienti.pazientiweb.dto.profilo.UtenteEnte;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

public interface BaseUtenteEnteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_utente_ente
     *
     * @mbg.generated
     */
    @Delete({
        "delete from r_utente_ente",
        "where cf_utente = #{cfUtente,jdbcType=VARCHAR}",
          "and id_ente = #{idEnte,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(@Param("cfUtente") String cfUtente, @Param("idEnte") Integer idEnte);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_utente_ente
     *
     * @mbg.generated
     */
    @Insert({
        "insert into r_utente_ente (cf_utente, id_ente)",
        "values (#{cfUtente,jdbcType=VARCHAR}, #{idEnte,jdbcType=INTEGER})"
    })
    int insert(UtenteEnte record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_utente_ente
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "cf_utente, id_ente",
        "from r_utente_ente"
    })
    @Results({
        @Result(column="cf_utente", property="cfUtente", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="id_ente", property="idEnte", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<UtenteEnte> selectAll();
}