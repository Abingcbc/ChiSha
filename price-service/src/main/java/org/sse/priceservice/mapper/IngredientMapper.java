package org.sse.priceservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.sse.priceservice.dto.PriceDTO;

import java.util.List;

/**
 * @author HPY
 */
@Component
@Mapper
public interface IngredientMapper {

    /**
     * search name by ingredient id
     * @param id ingredient id
     * @return ingredient name
     */
    @Select("SELECT \n" +
            "    ingredient_name\n" +
            "FROM\n" +
            "    ingredient\n" +
            "WHERE\n" +
            "    ingredient_id = #{id}")
    String searchNameById(@Param("id") long id);

    @Select("SELECT \n" +
            "    ingredient_id, ingredient_name\n" +
            "FROM\n" +
            "    ingredient")
    List<PriceDTO> getIngredientList();

    /**
     * search list of id by ingredient name
     * @param keyword
     * @return list of id
     */
    @Select("SELECT \n" +
            "    ingredient_id\n" +
            "FROM\n" +
            "    ingredient\n" +
            "where ingredient_name like #{keyword}")
    List<Long> searchIdByName(@Param("keyword") String keyword);
}
