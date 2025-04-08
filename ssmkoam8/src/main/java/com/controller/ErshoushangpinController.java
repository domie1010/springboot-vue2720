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

import com.entity.ErshoushangpinEntity;
import com.entity.view.ErshoushangpinView;

import com.service.ErshoushangpinService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 二手商品
 * 后端接口
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
@RestController
@RequestMapping("/ershoushangpin")
public class ErshoushangpinController {
    @Autowired
    private ErshoushangpinService ershoushangpinService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ErshoushangpinEntity ershoushangpin, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			ershoushangpin.setMaijiazhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ErshoushangpinEntity> ew = new EntityWrapper<ErshoushangpinEntity>();
		PageUtils page = ershoushangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ershoushangpin), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ErshoushangpinEntity ershoushangpin, 
		HttpServletRequest request){
        EntityWrapper<ErshoushangpinEntity> ew = new EntityWrapper<ErshoushangpinEntity>();
		PageUtils page = ershoushangpinService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, ershoushangpin), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ErshoushangpinEntity ershoushangpin){
       	EntityWrapper<ErshoushangpinEntity> ew = new EntityWrapper<ErshoushangpinEntity>();
      	ew.allEq(MPUtil.allEQMapPre( ershoushangpin, "ershoushangpin")); 
        return R.ok().put("data", ershoushangpinService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ErshoushangpinEntity ershoushangpin){
        EntityWrapper< ErshoushangpinEntity> ew = new EntityWrapper< ErshoushangpinEntity>();
 		ew.allEq(MPUtil.allEQMapPre( ershoushangpin, "ershoushangpin")); 
		ErshoushangpinView ershoushangpinView =  ershoushangpinService.selectView(ew);
		return R.ok("查询二手商品成功").put("data", ershoushangpinView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ErshoushangpinEntity ershoushangpin = ershoushangpinService.selectById(id);
        return R.ok().put("data", ershoushangpin);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ErshoushangpinEntity ershoushangpin = ershoushangpinService.selectById(id);
        return R.ok().put("data", ershoushangpin);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        ErshoushangpinEntity ershoushangpin = ershoushangpinService.selectById(id);
        if(type.equals("1")) {
        	ershoushangpin.setThumbsupnum(ershoushangpin.getThumbsupnum()+1);
        } else {
        	ershoushangpin.setCrazilynum(ershoushangpin.getCrazilynum()+1);
        }
        ershoushangpinService.updateById(ershoushangpin);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ErshoushangpinEntity ershoushangpin, HttpServletRequest request){
    	ershoushangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ershoushangpin);

        ershoushangpinService.insert(ershoushangpin);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ErshoushangpinEntity ershoushangpin, HttpServletRequest request){
    	ershoushangpin.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(ershoushangpin);

        ershoushangpinService.insert(ershoushangpin);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ErshoushangpinEntity ershoushangpin, HttpServletRequest request){
        //ValidatorUtils.validateEntity(ershoushangpin);
        ershoushangpinService.updateById(ershoushangpin);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        ershoushangpinService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<ErshoushangpinEntity> wrapper = new EntityWrapper<ErshoushangpinEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			wrapper.eq("maijiazhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = ershoushangpinService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
