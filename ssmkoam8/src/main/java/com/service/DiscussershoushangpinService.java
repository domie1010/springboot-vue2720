package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussershoushangpinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussershoushangpinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussershoushangpinView;


/**
 * 二手商品评论表
 *
 * @author 
 * @email 
 * @date 2021-06-02 21:36:35
 */
public interface DiscussershoushangpinService extends IService<DiscussershoushangpinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussershoushangpinVO> selectListVO(Wrapper<DiscussershoushangpinEntity> wrapper);
   	
   	DiscussershoushangpinVO selectVO(@Param("ew") Wrapper<DiscussershoushangpinEntity> wrapper);
   	
   	List<DiscussershoushangpinView> selectListView(Wrapper<DiscussershoushangpinEntity> wrapper);
   	
   	DiscussershoushangpinView selectView(@Param("ew") Wrapper<DiscussershoushangpinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussershoushangpinEntity> wrapper);
   	
}

