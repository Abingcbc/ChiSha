package org.sse.priceservice.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sse.priceservice.dto.PriceDTO;
import org.sse.priceservice.mapper.IngredientMapper;
import org.sse.priceservice.mapper.PriceMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HPY
 */
@Service
public class PriceService {
    @Autowired
    PriceMapper priceMapper;
    @Autowired
    IngredientMapper ingredientMapper;

    public PageInfo<PriceDTO> getPriceList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PriceDTO> priceDTOList = ingredientMapper.getIngredientList();
        for(PriceDTO priceDTO : priceDTOList){
            priceDTO.setWeekAveragePrice(priceMapper.searchAvgPriceInOneWeek(priceDTO.getIngredientId()));
            priceDTO.setMonthAveragePrice(priceMapper.searchAvgPriceInOneMonth(priceDTO.getIngredientId()));
        }
        return new PageInfo<>(priceDTOList);
    }

    public PriceDTO getPriceById(long id) {
        String name = ingredientMapper.searchNameById(id);
        Double weekAveragePrice = priceMapper.searchAvgPriceInOneWeek(id);
        Double monthAveragePrice = priceMapper.searchAvgPriceInOneMonth(id);

        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setIngredientId(id);
        priceDTO.setWeekAveragePrice(weekAveragePrice);
        priceDTO.setMonthAveragePrice(monthAveragePrice);
        priceDTO.setIngredientName(name);

        return priceDTO;
    }
    public List<PriceDTO> getPriceListByName(String name) {
        System.out.println(name);
        List<Long> idList = ingredientMapper.searchIdByName("%"+name+"%");
        System.out.println(idList.toString());
        List<PriceDTO> priceDTOList = new ArrayList<>();

        for(Long id : idList) {
            PriceDTO priceDTO = getPriceById(id);
            System.out.println(1);
            priceDTOList.add(priceDTO);
        }

        System.out.println(priceDTOList.toString());
        return priceDTOList;
    }
}
