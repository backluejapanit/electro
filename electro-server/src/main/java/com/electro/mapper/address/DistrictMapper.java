package com.electro.mapper.address;

import com.electro.dto.address.DistrictRequest;
import com.electro.dto.address.DistrictResponse;
import com.electro.entity.address.District;
import com.electro.mapper.GenericMapper;
import com.electro.utils.MapperUtils;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = MapperUtils.class)
public interface DistrictMapper extends GenericMapper<District, DistrictRequest, DistrictResponse> {

    @Override
    @Mapping(source = "provinceId", target = "province", qualifiedByName = "mapProvinceIdToProvince")
    District requestToEntity(DistrictRequest request);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "provinceId", target = "province", qualifiedByName = "mapProvinceIdToProvince")
    District partialUpdate(@MappingTarget District entity, DistrictRequest request);

}
