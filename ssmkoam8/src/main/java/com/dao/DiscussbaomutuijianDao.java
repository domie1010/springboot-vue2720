package com.dao;

import com.entity.DiscussbaomutuijianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussbaomutuijianVO;
import com.entity.view.DiscussbaomutuijianView;


/**
 * 保姆推荐评论表
 * 
 * @author 
 * @email 
 * @date 2021-06-02 21:36:35
 */
public interface DiscussbaomutuijianDao extends BaseMapper<DiscussbaomutuijianEntity> {
	
	List<DiscussbaomutuijianVO> selectListVO(@Param("ew") Wrapper<DiscussbaomutuijianEntity> wrapper);
	
	DiscussbaomutuijianVO selectVO(@Param("ew") Wrapper<DiscussbaomutuijianEntity> wrapper);
	
	List<DiscussbaomutuijianView> selectListView(@Param("ew") Wrapper<DiscussbaomutuijianEntity> wrapper);

	List<DiscussbaomutuijianView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussbaomutuijianEntity> wrapper);
	
	DiscussbaomutuijianView selectView(@Param("ew") Wrapper<DiscussbaomutuijianEntity> wrapper);
	
}
