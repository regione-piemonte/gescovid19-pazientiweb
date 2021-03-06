package it.csi.gestionepazienti.pazientiweb.mapper.generated;

import it.csi.gestionepazienti.pazientiweb.dto.Sintomo;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface BaseSintomoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sintomo
     *
     * @mbg.generated
     */
    @Delete({
        "delete from sintomo",
        "where id_sintomo = #{idSintomo,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long idSintomo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sintomo
     *
     * @mbg.generated
     */
    @Insert({
        "insert into sintomo (id_decorso, temperatura, ",
        "flg_gusto, flg_olfatto, ",
        "flg_tosse, flg_dolori_musc, ",
        "flg_stanchezza, flg_congiuntivite, ",
        "flg_diarrea, flg_raffreddore, flg_dispnea, ",
        "note_sintomo)",
        "values (#{idDecorso,jdbcType=BIGINT}, #{temperatura,jdbcType=NUMERIC}, ",
        "#{flgGusto,jdbcType=VARCHAR}, #{flgOlfatto,jdbcType=VARCHAR}, ",
        "#{flgTosse,jdbcType=VARCHAR}, #{flgDoloriMusc,jdbcType=VARCHAR}, ",
        "#{flgStanchezza,jdbcType=VARCHAR}, #{flgCongiuntivite,jdbcType=VARCHAR}, ",
        "#{flgDiarrea,jdbcType=VARCHAR}, #{flgRaffreddore,jdbcType=VARCHAR}, #{flgDispnea,jdbcType=VARCHAR}, ",
        "#{noteSintomo,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="idSintomo")
    int insert(Sintomo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sintomo
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id_sintomo, id_decorso, temperatura, flg_gusto, flg_olfatto, flg_tosse, flg_dolori_musc, ",
        "flg_stanchezza, flg_congiuntivite, flg_diarrea, flg_raffreddore, flg_dispnea, note_sintomo",
        "from sintomo",
        "where id_sintomo = #{idSintomo,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id_sintomo", property="idSintomo", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="id_decorso", property="idDecorso", jdbcType=JdbcType.BIGINT),
        @Result(column="temperatura", property="temperatura", jdbcType=JdbcType.NUMERIC),
        @Result(column="flg_gusto", property="flgGusto", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_olfatto", property="flgOlfatto", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_tosse", property="flgTosse", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_dolori_musc", property="flgDoloriMusc", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_stanchezza", property="flgStanchezza", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_congiuntivite", property="flgCongiuntivite", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_diarrea", property="flgDiarrea", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_raffreddore", property="flgRaffreddore", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_dispnea", property="flgDispnea", jdbcType=JdbcType.VARCHAR),
        @Result(column="note_sintomo", property="noteSintomo", jdbcType=JdbcType.VARCHAR)
    })
    Sintomo selectByPrimaryKey(Long idSintomo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sintomo
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id_sintomo, id_decorso, temperatura, flg_gusto, flg_olfatto, flg_tosse, flg_dolori_musc, ",
        "flg_stanchezza, flg_congiuntivite, flg_diarrea, flg_raffreddore, flg_dispnea, note_sintomo",
        "from sintomo"
    })
    @Results({
        @Result(column="id_sintomo", property="idSintomo", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="id_decorso", property="idDecorso", jdbcType=JdbcType.BIGINT),
        @Result(column="temperatura", property="temperatura", jdbcType=JdbcType.NUMERIC),
        @Result(column="flg_gusto", property="flgGusto", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_olfatto", property="flgOlfatto", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_tosse", property="flgTosse", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_dolori_musc", property="flgDoloriMusc", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_stanchezza", property="flgStanchezza", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_congiuntivite", property="flgCongiuntivite", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_diarrea", property="flgDiarrea", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_raffreddore", property="flgRaffreddore", jdbcType=JdbcType.VARCHAR),
        @Result(column="flg_dispnea", property="flgDispnea", jdbcType=JdbcType.VARCHAR),
        @Result(column="note_sintomo", property="noteSintomo", jdbcType=JdbcType.VARCHAR)
    })
    List<Sintomo> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sintomo
     *
     * @mbg.generated
     */
    @Update({
        "update sintomo",
        "set id_decorso = #{idDecorso,jdbcType=BIGINT},",
          "temperatura = #{temperatura,jdbcType=NUMERIC},",
          "flg_gusto = #{flgGusto,jdbcType=VARCHAR},",
          "flg_olfatto = #{flgOlfatto,jdbcType=VARCHAR},",
          "flg_tosse = #{flgTosse,jdbcType=VARCHAR},",
          "flg_dolori_musc = #{flgDoloriMusc,jdbcType=VARCHAR},",
          "flg_stanchezza = #{flgStanchezza,jdbcType=VARCHAR},",
          "flg_congiuntivite = #{flgCongiuntivite,jdbcType=VARCHAR},",
          "flg_diarrea = #{flgDiarrea,jdbcType=VARCHAR},",
          "flg_raffreddore = #{flgRaffreddore,jdbcType=VARCHAR},",
          "flg_dispnea = #{noteSintomo,jdbcType=VARCHAR}",
          "flg_raffreddore = #{flgDispnea,jdbcType=VARCHAR},",
        "where id_sintomo = #{idSintomo,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Sintomo record);
}