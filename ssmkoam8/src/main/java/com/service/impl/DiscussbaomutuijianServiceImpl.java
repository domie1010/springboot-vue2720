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


import com.dao.DiscussbaomutuijianDao;
import com.entity.DiscussbaomutuijianEntity;
import com.service.DiscussbaomutuijianService;
import com.entity.vo.DiscussbaomutuijianVO;
import com.entity.view.DiscussbaomutuijianView;

@Service("discussbaomutuijianService")
public class DiscussbaomutuijianServiceImpl extends ServiceImpl<DiscussbaomutuijianDao, DiscussbaomutuijianEntity> implements DiscussbaomutuijianService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussbaomutuijianEntity> page = this.selectPage(
                new Query<DiscussbaomutuijianEntity>(params).getPage(),
                new EntityWrapper<DiscussbaomutuijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussbaomutuijianEntity> wrapper) {
		  Page<DiscussbaomutuijianView> page =new Query<DiscussbaomutuijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussbaomutuijianVO> selectListVO(Wrapper<DiscussbaomutuijianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussbaomutuijianVO selectVO(Wrapper<DiscussbaomutuijianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussbaomutuijianView> selectListView(Wrapper<DiscussbaomutuijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussbaomutuijianView selectView(Wrapper<DiscussbaomutuijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
