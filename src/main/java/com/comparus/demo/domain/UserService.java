package com.comparus.demo.domain;

import com.comparus.demo.api.model.User;
import com.comparus.demo.datasource.DataSourceContextHolder;
import com.comparus.demo.datasource.DataSourceHolder;
import com.comparus.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final DataSourceContextHolder dataSourceContextHolder;
    private final DataSourceHolder dataSourceHolder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(DataSourceContextHolder dataSourceContextHolder, DataSourceHolder dataSourceHolder, UserRepository userRepository, UserMapper userMapper) {
        this.dataSourceContextHolder = dataSourceContextHolder;
        this.dataSourceHolder = dataSourceHolder;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<User> getAllUsers(String dataSource) {
        dataSourceContextHolder.setBranchContext(dataSource);
        return userMapper.map(userRepository.findAll());
    }

    public List<String> getDataSources(){
        return dataSourceHolder.getDbNames();
    }
}
