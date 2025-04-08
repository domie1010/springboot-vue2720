package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MengbaoxinxiEntity;
import com.entity.view.MengbaoxinxiView;

import com.service.MengbaoxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 萌宝信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
@RestController
@RequestMapping("/mengbaoxinxi")
public class MengbaoxinxiController {
    @Autowired
    private MengbaoxinxiService mengbaoxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MengbaoxinxiEntity mengbaoxinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			mengbaoxinxi.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MengbaoxinxiEntity> ew = new EntityWrapper<MengbaoxinxiEntity>();
		PageUtils page = mengbaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mengbaoxinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MengbaoxinxiEntity mengbaoxinxi, 
		HttpServletRequest request){
        EntityWrapper<MengbaoxinxiEntity> ew = new EntityWrapper<MengbaoxinxiEntity>();
		PageUtils page = mengbaoxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, mengbaoxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MengbaoxinxiEntity mengbaoxinxi){
       	EntityWrapper<MengbaoxinxiEntity> ew = new EntityWrapper<MengbaoxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( mengbaoxinxi, "mengbaoxinxi")); 
        return R.ok().put("data", mengbaoxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MengbaoxinxiEntity mengbaoxinxi){
        EntityWrapper< MengbaoxinxiEntity> ew = new EntityWrapper< MengbaoxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( mengbaoxinxi, "mengbaoxinxi")); 
		MengbaoxinxiView mengbaoxinxiView =  mengbaoxinxiService.selectView(ew);
		return R.ok("查询萌宝信息成功").put("data", mengbaoxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MengbaoxinxiEntity mengbaoxinxi = mengbaoxinxiService.selectById(id);
        return R.ok().put("data", mengbaoxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MengbaoxinxiEntity mengbaoxinxi = mengbaoxinxiService.selectById(id);
        return R.ok().put("data", mengbaoxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        MengbaoxinxiEntity mengbaoxinxi = mengbaoxinxiService.selectById(id);
        if(type.equals("1")) {
        	mengbaoxinxi.setThumbsupnum(mengbaoxinxi.getThumbsupnum()+1);
        } else {
        	mengbaoxinxi.setCrazilynum(mengbaoxinxi.getCrazilynum()+1);
        }
        mengbaoxinxiService.updateById(mengbaoxinxi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MengbaoxinxiEntity mengbaoxinxi, HttpServletRequest request){
    	mengbaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mengbaoxinxi);

        mengbaoxinxiService.insert(mengbaoxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MengbaoxinxiEntity mengbaoxinxi, HttpServletRequest request){
    	mengbaoxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(mengbaoxinxi);

        mengbaoxinxiService.insert(mengbaoxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MengbaoxinxiEntity mengbaoxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(mengbaoxinxi);
        mengbaoxinxiService.updateById(mengbaoxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        mengbaoxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<MengbaoxinxiEntity> wrapper = new EntityWrapper<MengbaoxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = mengbaoxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
