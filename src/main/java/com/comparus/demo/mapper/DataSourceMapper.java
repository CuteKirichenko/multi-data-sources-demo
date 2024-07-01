package com.comparus.demo.mapper;

import com.comparus.demo.datasource.DataSourceHolder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DataSourceMapper {

    @Mapping(source = "user", target = "username")
    DriverManagerDataSource map(DataSourceHolder.DbSource source);
}
