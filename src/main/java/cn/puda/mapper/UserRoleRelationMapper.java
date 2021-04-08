package cn.puda.mapper;

import cn.puda.entity.Resource;
import cn.puda.entity.UserRoleRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRelationMapper {

    List<Resource> getResourceList(Long id);

    void deleteAll(Long userId);

    void insertAll(List<UserRoleRelation> list);
}
