package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BaomutuijianEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BaomutuijianVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BaomutuijianView;


/**
 * 保姆推荐
 *
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
public interface BaomutuijianService extends IService<BaomutuijianEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<BaomutuijianVO> selectListVO(Wrapper<BaomutuijianEntity> wrapper);
   	
   	BaomutuijianVO selectVO(@Param("ew") Wrapper<BaomutuijianEntity> wrapper);
   	
   	List<BaomutuijianView> selectListView(Wrapper<BaomutuijianEntity> wrapper);
   	
   	BaomutuijianView selectView(@Param("ew") Wrapper<BaomutuijianEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<BaomutuijianEntity> wrapper);
   	
}

