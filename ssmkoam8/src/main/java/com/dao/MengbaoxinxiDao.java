package com.dao;

import com.entity.MengbaoxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.MengbaoxinxiVO;
import com.entity.view.MengbaoxinxiView;


/**
 * 萌宝信息
 * 
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
public interface MengbaoxinxiDao extends BaseMapper<MengbaoxinxiEntity> {
	
	List<MengbaoxinxiVO> selectListVO(@Param("ew") Wrapper<MengbaoxinxiEntity> wrapper);
	
	MengbaoxinxiVO selectVO(@Param("ew") Wrapper<MengbaoxinxiEntity> wrapper);
	
	List<MengbaoxinxiView> selectListView(@Param("ew") Wrapper<MengbaoxinxiEntity> wrapper);

	List<MengbaoxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<MengbaoxinxiEntity> wrapper);
	
	MengbaoxinxiView selectView(@Param("ew") Wrapper<MengbaoxinxiEntity> wrapper);
	
}
