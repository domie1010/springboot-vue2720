package com.dao;

import com.entity.YinpinziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YinpinziyuanVO;
import com.entity.view.YinpinziyuanView;


/**
 * 音频资源
 * 
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
public interface YinpinziyuanDao extends BaseMapper<YinpinziyuanEntity> {
	
	List<YinpinziyuanVO> selectListVO(@Param("ew") Wrapper<YinpinziyuanEntity> wrapper);
	
	YinpinziyuanVO selectVO(@Param("ew") Wrapper<YinpinziyuanEntity> wrapper);
	
	List<YinpinziyuanView> selectListView(@Param("ew") Wrapper<YinpinziyuanEntity> wrapper);

	List<YinpinziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<YinpinziyuanEntity> wrapper);
	
	YinpinziyuanView selectView(@Param("ew") Wrapper<YinpinziyuanEntity> wrapper);
	
}
