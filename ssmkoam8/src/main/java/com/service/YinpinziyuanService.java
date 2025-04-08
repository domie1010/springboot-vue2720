package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YinpinziyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YinpinziyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YinpinziyuanView;


/**
 * 音频资源
 *
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
public interface YinpinziyuanService extends IService<YinpinziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinpinziyuanVO> selectListVO(Wrapper<YinpinziyuanEntity> wrapper);
   	
   	YinpinziyuanVO selectVO(@Param("ew") Wrapper<YinpinziyuanEntity> wrapper);
   	
   	List<YinpinziyuanView> selectListView(Wrapper<YinpinziyuanEntity> wrapper);
   	
   	YinpinziyuanView selectView(@Param("ew") Wrapper<YinpinziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinpinziyuanEntity> wrapper);
   	
}

