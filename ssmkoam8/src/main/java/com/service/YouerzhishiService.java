package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YouerzhishiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YouerzhishiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YouerzhishiView;


/**
 * 幼儿知识
 *
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
public interface YouerzhishiService extends IService<YouerzhishiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YouerzhishiVO> selectListVO(Wrapper<YouerzhishiEntity> wrapper);
   	
   	YouerzhishiVO selectVO(@Param("ew") Wrapper<YouerzhishiEntity> wrapper);
   	
   	List<YouerzhishiView> selectListView(Wrapper<YouerzhishiEntity> wrapper);
   	
   	YouerzhishiView selectView(@Param("ew") Wrapper<YouerzhishiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YouerzhishiEntity> wrapper);
   	
}

