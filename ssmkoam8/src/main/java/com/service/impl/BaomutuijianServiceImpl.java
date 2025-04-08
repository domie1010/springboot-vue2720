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


import com.dao.BaomutuijianDao;
import com.entity.BaomutuijianEntity;
import com.service.BaomutuijianService;
import com.entity.vo.BaomutuijianVO;
import com.entity.view.BaomutuijianView;

@Service("baomutuijianService")
public class BaomutuijianServiceImpl extends ServiceImpl<BaomutuijianDao, BaomutuijianEntity> implements BaomutuijianService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BaomutuijianEntity> page = this.selectPage(
                new Query<BaomutuijianEntity>(params).getPage(),
                new EntityWrapper<BaomutuijianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<BaomutuijianEntity> wrapper) {
		  Page<BaomutuijianView> page =new Query<BaomutuijianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<BaomutuijianVO> selectListVO(Wrapper<BaomutuijianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public BaomutuijianVO selectVO(Wrapper<BaomutuijianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<BaomutuijianView> selectListView(Wrapper<BaomutuijianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public BaomutuijianView selectView(Wrapper<BaomutuijianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
