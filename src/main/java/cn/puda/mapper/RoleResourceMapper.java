package cn.puda.mapper;

import cn.puda.entity.RoleResourceRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @title: RoleResourceMapper
 * @Author Ypier
 * @Date: 2021/4/6 16:48
 */
@Repository
public interface RoleResourceMapper {

    int deleteAll(Long roleId);

    void insertList(List<RoleResourceRelation> list);
}
