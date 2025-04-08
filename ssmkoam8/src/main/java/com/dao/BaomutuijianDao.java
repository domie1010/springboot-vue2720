package com.dao;

import com.entity.BaomutuijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BaomutuijianVO;
import com.entity.view.BaomutuijianView;


/**
 * 保姆推荐
 * 
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
public interface BaomutuijianDao extends BaseMapper<BaomutuijianEntity> {
	
	List<BaomutuijianVO> selectListVO(@Param("ew") Wrapper<BaomutuijianEntity> wrapper);
	
	BaomutuijianVO selectVO(@Param("ew") Wrapper<BaomutuijianEntity> wrapper);
	
	List<BaomutuijianView> selectListView(@Param("ew") Wrapper<BaomutuijianEntity> wrapper);

	List<BaomutuijianView> selectListView(Pagination page,@Param("ew") Wrapper<BaomutuijianEntity> wrapper);
	
	BaomutuijianView selectView(@Param("ew") Wrapper<BaomutuijianEntity> wrapper);
	
}
