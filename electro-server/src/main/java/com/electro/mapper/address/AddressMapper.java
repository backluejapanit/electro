package com.electro.mapper.address;

import com.electro.dto.address.AddressRequest;
import com.electro.dto.address.AddressResponse;
import com.electro.entity.address.Address;
import com.electro.mapper.GenericMapper;
import com.electro.utils.MapperUtils;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = MapperUtils.class)
public interface AddressMapper extends GenericMapper<Address, AddressRequest, AddressResponse> {

    @Override
    @Mapping(source = "provinceId", target = "province", qualifiedByName = "mapProvinceIdToProvince")
    @Mapping(source = "districtId", target = "district", qualifiedByName = "mapDistrictIdToDistrict")
    Address requestToEntity(AddressRequest request);

    @Override
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "provinceId", target = "province", qualifiedByName = "mapProvinceIdToProvince")
    @Mapping(source = "districtId", target = "district", qualifiedByName = "mapDistrictIdToDistrict")
    Address partialUpdate(@MappingTarget Address entity, AddressRequest request);

}
