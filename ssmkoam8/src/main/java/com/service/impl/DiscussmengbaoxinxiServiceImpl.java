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


import com.dao.DiscussmengbaoxinxiDao;
import com.entity.DiscussmengbaoxinxiEntity;
import com.service.DiscussmengbaoxinxiService;
import com.entity.vo.DiscussmengbaoxinxiVO;
import com.entity.view.DiscussmengbaoxinxiView;

@Service("discussmengbaoxinxiService")
public class DiscussmengbaoxinxiServiceImpl extends ServiceImpl<DiscussmengbaoxinxiDao, DiscussmengbaoxinxiEntity> implements DiscussmengbaoxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussmengbaoxinxiEntity> page = this.selectPage(
                new Query<DiscussmengbaoxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussmengbaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussmengbaoxinxiEntity> wrapper) {
		  Page<DiscussmengbaoxinxiView> page =new Query<DiscussmengbaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussmengbaoxinxiVO> selectListVO(Wrapper<DiscussmengbaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussmengbaoxinxiVO selectVO(Wrapper<DiscussmengbaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussmengbaoxinxiView> selectListView(Wrapper<DiscussmengbaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussmengbaoxinxiView selectView(Wrapper<DiscussmengbaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
