package com.dao;

import com.entity.ErshoushangpinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ErshoushangpinVO;
import com.entity.view.ErshoushangpinView;


/**
 * 二手商品
 * 
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
public interface ErshoushangpinDao extends BaseMapper<ErshoushangpinEntity> {
	
	List<ErshoushangpinVO> selectListVO(@Param("ew") Wrapper<ErshoushangpinEntity> wrapper);
	
	ErshoushangpinVO selectVO(@Param("ew") Wrapper<ErshoushangpinEntity> wrapper);
	
	List<ErshoushangpinView> selectListView(@Param("ew") Wrapper<ErshoushangpinEntity> wrapper);

	List<ErshoushangpinView> selectListView(Pagination page,@Param("ew") Wrapper<ErshoushangpinEntity> wrapper);
	
	ErshoushangpinView selectView(@Param("ew") Wrapper<ErshoushangpinEntity> wrapper);
	
}
