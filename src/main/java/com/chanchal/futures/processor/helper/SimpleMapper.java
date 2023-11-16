package com.chanchal.futures.processor.helper;

import com.chanchal.futures.bo.OrderBO;
import com.chanchal.futures.to.OrderTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.Timestamp;

@Mapper(componentModel = "spring")
public interface SimpleMapper {

    SimpleMapper INSTANCE = Mappers.getMapper(SimpleMapper.class);

//    @Mapping(target = "orderedTime", resultType = Timestamp.class)
    OrderBO OrderTOToOrderBO(OrderTO source);
}