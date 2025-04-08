package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussbaomutuijianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussbaomutuijianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussbaomutuijianView;


/**
 * 保姆推荐评论表
 *
 * @author 
 * @email 
 * @date 2021-06-02 21:36:35
 */
public interface DiscussbaomutuijianService extends IService<DiscussbaomutuijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussbaomutuijianVO> selectListVO(Wrapper<DiscussbaomutuijianEntity> wrapper);
   	
   	DiscussbaomutuijianVO selectVO(@Param("ew") Wrapper<DiscussbaomutuijianEntity> wrapper);
   	
   	List<DiscussbaomutuijianView> selectListView(Wrapper<DiscussbaomutuijianEntity> wrapper);
   	
   	DiscussbaomutuijianView selectView(@Param("ew") Wrapper<DiscussbaomutuijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussbaomutuijianEntity> wrapper);
   	
}

