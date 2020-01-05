package org.sse.priceservice.dto;

import lombok.Data;

/**
 * @author HPY
 */
@Data
public class PriceDTO {
    String ingredientName;
    Double todayPrice;
    Double weekAveragePrice;
    Double monthAveragePrice;
    Long ingredientId;
    String ingredientImage;

}
