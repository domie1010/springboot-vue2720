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


import com.dao.MengbaoxinxiDao;
import com.entity.MengbaoxinxiEntity;
import com.service.MengbaoxinxiService;
import com.entity.vo.MengbaoxinxiVO;
import com.entity.view.MengbaoxinxiView;

@Service("mengbaoxinxiService")
public class MengbaoxinxiServiceImpl extends ServiceImpl<MengbaoxinxiDao, MengbaoxinxiEntity> implements MengbaoxinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MengbaoxinxiEntity> page = this.selectPage(
                new Query<MengbaoxinxiEntity>(params).getPage(),
                new EntityWrapper<MengbaoxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MengbaoxinxiEntity> wrapper) {
		  Page<MengbaoxinxiView> page =new Query<MengbaoxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MengbaoxinxiVO> selectListVO(Wrapper<MengbaoxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MengbaoxinxiVO selectVO(Wrapper<MengbaoxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MengbaoxinxiView> selectListView(Wrapper<MengbaoxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MengbaoxinxiView selectView(Wrapper<MengbaoxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
