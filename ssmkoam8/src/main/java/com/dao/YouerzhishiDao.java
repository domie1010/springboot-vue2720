package com.dao;

import com.entity.YouerzhishiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YouerzhishiVO;
import com.entity.view.YouerzhishiView;


/**
 * 幼儿知识
 * 
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
public interface YouerzhishiDao extends BaseMapper<YouerzhishiEntity> {
	
	List<YouerzhishiVO> selectListVO(@Param("ew") Wrapper<YouerzhishiEntity> wrapper);
	
	YouerzhishiVO selectVO(@Param("ew") Wrapper<YouerzhishiEntity> wrapper);
	
	List<YouerzhishiView> selectListView(@Param("ew") Wrapper<YouerzhishiEntity> wrapper);

	List<YouerzhishiView> selectListView(Pagination page,@Param("ew") Wrapper<YouerzhishiEntity> wrapper);
	
	YouerzhishiView selectView(@Param("ew") Wrapper<YouerzhishiEntity> wrapper);
	
}
