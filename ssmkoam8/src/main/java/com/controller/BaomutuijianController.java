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

import com.entity.BaomutuijianEntity;
import com.entity.view.BaomutuijianView;

import com.service.BaomutuijianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 保姆推荐
 * 后端接口
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
@RestController
@RequestMapping("/baomutuijian")
public class BaomutuijianController {
    @Autowired
    private BaomutuijianService baomutuijianService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,BaomutuijianEntity baomutuijian, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			baomutuijian.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<BaomutuijianEntity> ew = new EntityWrapper<BaomutuijianEntity>();
		PageUtils page = baomutuijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baomutuijian), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,BaomutuijianEntity baomutuijian, 
		HttpServletRequest request){
        EntityWrapper<BaomutuijianEntity> ew = new EntityWrapper<BaomutuijianEntity>();
		PageUtils page = baomutuijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baomutuijian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( BaomutuijianEntity baomutuijian){
       	EntityWrapper<BaomutuijianEntity> ew = new EntityWrapper<BaomutuijianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( baomutuijian, "baomutuijian")); 
        return R.ok().put("data", baomutuijianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(BaomutuijianEntity baomutuijian){
        EntityWrapper< BaomutuijianEntity> ew = new EntityWrapper< BaomutuijianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( baomutuijian, "baomutuijian")); 
		BaomutuijianView baomutuijianView =  baomutuijianService.selectView(ew);
		return R.ok("查询保姆推荐成功").put("data", baomutuijianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        BaomutuijianEntity baomutuijian = baomutuijianService.selectById(id);
		baomutuijian.setClicknum(baomutuijian.getClicknum()+1);
		baomutuijian.setClicktime(new Date());
		baomutuijianService.updateById(baomutuijian);
        return R.ok().put("data", baomutuijian);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        BaomutuijianEntity baomutuijian = baomutuijianService.selectById(id);
		baomutuijian.setClicknum(baomutuijian.getClicknum()+1);
		baomutuijian.setClicktime(new Date());
		baomutuijianService.updateById(baomutuijian);
        return R.ok().put("data", baomutuijian);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        BaomutuijianEntity baomutuijian = baomutuijianService.selectById(id);
        if(type.equals("1")) {
        	baomutuijian.setThumbsupnum(baomutuijian.getThumbsupnum()+1);
        } else {
        	baomutuijian.setCrazilynum(baomutuijian.getCrazilynum()+1);
        }
        baomutuijianService.updateById(baomutuijian);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BaomutuijianEntity baomutuijian, HttpServletRequest request){
    	baomutuijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baomutuijian);

        baomutuijianService.insert(baomutuijian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody BaomutuijianEntity baomutuijian, HttpServletRequest request){
    	baomutuijian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(baomutuijian);

        baomutuijianService.insert(baomutuijian);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BaomutuijianEntity baomutuijian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(baomutuijian);
        baomutuijianService.updateById(baomutuijian);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        baomutuijianService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<BaomutuijianEntity> wrapper = new EntityWrapper<BaomutuijianEntity>();
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

		int count = baomutuijianService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,BaomutuijianEntity baomutuijian, HttpServletRequest request,String pre){
        EntityWrapper<BaomutuijianEntity> ew = new EntityWrapper<BaomutuijianEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        
        params.put("order", "desc");
		PageUtils page = baomutuijianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, baomutuijian), params), params));
        return R.ok().put("data", page);
    }


}
