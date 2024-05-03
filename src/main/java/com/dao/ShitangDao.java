package com.dao;

import com.entity.ShitangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShitangView;

/**
 * 食堂 Dao 接口
 *
 * @author 
 */
public interface ShitangDao extends BaseMapper<ShitangEntity> {

   List<ShitangView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
