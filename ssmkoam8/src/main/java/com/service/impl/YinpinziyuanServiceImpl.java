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


import com.dao.YinpinziyuanDao;
import com.entity.YinpinziyuanEntity;
import com.service.YinpinziyuanService;
import com.entity.vo.YinpinziyuanVO;
import com.entity.view.YinpinziyuanView;

@Service("yinpinziyuanService")
public class YinpinziyuanServiceImpl extends ServiceImpl<YinpinziyuanDao, YinpinziyuanEntity> implements YinpinziyuanService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YinpinziyuanEntity> page = this.selectPage(
                new Query<YinpinziyuanEntity>(params).getPage(),
                new EntityWrapper<YinpinziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YinpinziyuanEntity> wrapper) {
		  Page<YinpinziyuanView> page =new Query<YinpinziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<YinpinziyuanVO> selectListVO(Wrapper<YinpinziyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YinpinziyuanVO selectVO(Wrapper<YinpinziyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YinpinziyuanView> selectListView(Wrapper<YinpinziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YinpinziyuanView selectView(Wrapper<YinpinziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
