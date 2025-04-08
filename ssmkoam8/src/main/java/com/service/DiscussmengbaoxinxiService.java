package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmengbaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmengbaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmengbaoxinxiView;


/**
 * 萌宝信息评论表
 *
 * @author 
 * @email 
 * @date 2021-06-02 21:36:35
 */
public interface DiscussmengbaoxinxiService extends IService<DiscussmengbaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmengbaoxinxiVO> selectListVO(Wrapper<DiscussmengbaoxinxiEntity> wrapper);
   	
   	DiscussmengbaoxinxiVO selectVO(@Param("ew") Wrapper<DiscussmengbaoxinxiEntity> wrapper);
   	
   	List<DiscussmengbaoxinxiView> selectListView(Wrapper<DiscussmengbaoxinxiEntity> wrapper);
   	
   	DiscussmengbaoxinxiView selectView(@Param("ew") Wrapper<DiscussmengbaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmengbaoxinxiEntity> wrapper);
   	
}

