package com.comparus.demo;

import com.comparus.demo.datasource.DataSourceHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapFromYamlTest {

    @Autowired
    private DataSourceHolder dataSourceHolder;

    @Test
    public void whenYamlFileProvidedThenInjectSimpleMap() {
        List<DataSourceHolder.DbSource> dataSources = dataSourceHolder.getDataSources();
        System.out.println(dataSources);
        assertEquals("comparus", dataSources
                .get(0).getName());
    }
}
