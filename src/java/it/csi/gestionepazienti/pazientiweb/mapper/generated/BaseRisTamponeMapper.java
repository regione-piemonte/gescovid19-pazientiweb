package it.csi.gestionepazienti.pazientiweb.mapper.generated;

import it.csi.gestionepazienti.pazientiweb.dto.RisTampone;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

public interface BaseRisTamponeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ris_tampone
	 * @mbg.generated
	 */
	@Delete({ "delete from ris_tampone", "where id_ris_tamp = #{idRisTamp,jdbcType=BIGINT}" })
	int deleteByPrimaryKey(Long idRisTamp);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ris_tampone
	 * @mbg.generated
	 */
	@Insert({ "insert into ris_tampone (risultato_tampone)", "values (#{risultatoTampone,jdbcType=VARCHAR})" })
	@Options(useGeneratedKeys = true, keyProperty = "idRisTamp")
	int insert(RisTampone record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ris_tampone
	 * @mbg.generated
	 */
	@Select({ "select", "id_ris_tamp, risultato_tampone", "from ris_tampone", "where id_ris_tamp = #{idRisTamp,jdbcType=BIGINT}" })
	@Results({ @Result(column = "id_ris_tamp", property = "idRisTamp", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "risultato_tampone", property = "risultatoTampone", jdbcType = JdbcType.VARCHAR) })
	RisTampone selectByPrimaryKey(Long idRisTamp);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ris_tampone
	 * @mbg.generated
	 */
	@Select({ "select", "id_ris_tamp, risultato_tampone", "from ris_tampone" })
	@Results({ @Result(column = "id_ris_tamp", property = "idRisTamp", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "risultato_tampone", property = "risultatoTampone", jdbcType = JdbcType.VARCHAR) })
	List<RisTampone> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ris_tampone
	 * @mbg.generated
	 */
	@Update({ "update ris_tampone", "set risultato_tampone = #{risultatoTampone,jdbcType=VARCHAR}", "where id_ris_tamp = #{idRisTamp,jdbcType=BIGINT}" })
	int updateByPrimaryKey(RisTampone record);
}