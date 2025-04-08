package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YouerzhishiDao;
import com.entity.YouerzhishiEntity;
import com.service.YouerzhishiService;
import com.entity.vo.YouerzhishiVO;
import com.entity.view.YouerzhishiView;

@Service("youerzhishiService")
public class YouerzhishiServiceImpl extends ServiceImpl<YouerzhishiDao, YouerzhishiEntity> implements YouerzhishiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YouerzhishiEntity> page = this.selectPage(
                new Query<YouerzhishiEntity>(params).getPage(),
                new EntityWrapper<YouerzhishiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YouerzhishiEntity> wrapper) {
		  Page<YouerzhishiView> page =new Query<YouerzhishiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YouerzhishiVO> selectListVO(Wrapper<YouerzhishiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YouerzhishiVO selectVO(Wrapper<YouerzhishiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YouerzhishiView> selectListView(Wrapper<YouerzhishiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YouerzhishiView selectView(Wrapper<YouerzhishiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
