package org.sse.priceservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResultDTO {
    List<PriceDTO> result;
}
