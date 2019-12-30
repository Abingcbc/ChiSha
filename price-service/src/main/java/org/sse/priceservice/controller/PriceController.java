package org.sse.priceservice.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sse.priceservice.dto.PriceDTO;
import org.sse.priceservice.dto.SearchDTO;
import org.sse.priceservice.dto.ResultDTO;
import org.sse.priceservice.service.PriceService;

/**
 * @author HPY
 */
@RestController
@RequestMapping("/price")
public class PriceController {
    @Autowired
    PriceService priceService;

    @GetMapping("/get-list")
    public PageInfo<PriceDTO> getPageOfPrice(@RequestParam("page-num") int pageNum,
                                             @RequestParam("page-size") int pageSize){
        return priceService.getPriceList(pageNum, pageSize);
    }

    @PostMapping("/get-list-by-name")
    public ResultDTO getPageOfPriceByName(@RequestBody SearchDTO searchDTO
    ) {
        System.out.println(searchDTO.toString());
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResult(priceService.getPriceListByName(searchDTO.getKeyword()));
        return resultDTO;
    }


}
