package org.sse.recommendservice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.sse.recommendservice.model.TrainData;

import java.util.List;

/**
 * @author cbc
 */
@Component
@Mapper
public interface RecommendMapper {


    List<TrainData> getTrainDataByUserID()
}
