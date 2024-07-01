package com.comparus.demo.datasource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.comparus.demo.mapper.DataSourceMapper;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

@Component
public class DataSourceRouting extends AbstractRoutingDataSource {
    private final DataSourceContextHolder dataSourceContextHolder;
    private final DataSourceHolder dataSourceHolder;
    private final DataSourceMapper dataSourceMapper;

    public DataSourceRouting(DataSourceContextHolder dataSourceContextHolder, DataSourceHolder dataSourceHolder, DataSourceMapper dataSourceMapper) {
        this.dataSourceContextHolder = dataSourceContextHolder;
        this.dataSourceHolder = dataSourceHolder;
        this.dataSourceMapper = dataSourceMapper;

        this.setTargetDataSources(initDataSourceMap());
        this.setDefaultTargetDataSource(initDataSourceMap().get(dataSourceHolder.getDataSources().get(0).getName()));
        this.afterPropertiesSet();
    }
    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceContextHolder.getBranchContext();
    }

    public Map<Object, Object> initDataSourceMap() {
        List<DataSourceHolder.DbSource> dataSources = dataSourceHolder.getDataSources();
        return dataSources.stream()
                .map(ds -> Map.entry(ds.getName(), dataSourceMapper.map(ds)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
