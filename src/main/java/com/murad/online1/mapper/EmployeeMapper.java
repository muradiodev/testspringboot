package com.murad.online1.mapper;

import com.murad.online1.db.entity.Employee;
import com.murad.online1.model.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public abstract class EmployeeMapper {

    public static final EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mappings(
            {
                    @Mapping(source = "id", target = "idEmployee")
            }
    )
    public abstract EmployeeDto mapToEmpDto(Employee employee);

    @Mappings(
            {
                    @Mapping(source = "idEmployee", target = "id")
            }
    )
    public abstract Employee mapToEmp(EmployeeDto employeeDto);

}
