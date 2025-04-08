package com.entity.view;

import com.entity.YouerzhishiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 幼儿知识
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
@TableName("youerzhishi")
public class YouerzhishiView  extends YouerzhishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YouerzhishiView(){
	}
 
 	public YouerzhishiView(YouerzhishiEntity youerzhishiEntity){
 	try {
			BeanUtils.copyProperties(this, youerzhishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
