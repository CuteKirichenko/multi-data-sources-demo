package com.comparus.demo.mapper;

import com.comparus.demo.api.model.User;
import com.comparus.demo.domain.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface UserMapper {
    List<User> map(List<UserEntity> source);
}
