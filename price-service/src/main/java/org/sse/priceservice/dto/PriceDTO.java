package org.sse.priceservice.dto;

import lombok.Data;

/**
 * @author HPY
 */
@Data
public class PriceDTO {
    String ingredientName;
    Double weekAveragePrice;
    Double monthAveragePrice;
    Long ingredientId;

}
