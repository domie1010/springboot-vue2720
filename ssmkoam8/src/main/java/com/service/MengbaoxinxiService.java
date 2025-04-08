package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MengbaoxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MengbaoxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MengbaoxinxiView;


/**
 * 萌宝信息
 *
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
public interface MengbaoxinxiService extends IService<MengbaoxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MengbaoxinxiVO> selectListVO(Wrapper<MengbaoxinxiEntity> wrapper);
   	
   	MengbaoxinxiVO selectVO(@Param("ew") Wrapper<MengbaoxinxiEntity> wrapper);
   	
   	List<MengbaoxinxiView> selectListView(Wrapper<MengbaoxinxiEntity> wrapper);
   	
   	MengbaoxinxiView selectView(@Param("ew") Wrapper<MengbaoxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MengbaoxinxiEntity> wrapper);
   	
}

