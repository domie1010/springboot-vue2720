package com.entity.view;

import com.entity.DiscussmengbaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 萌宝信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-06-02 21:36:35
 */
@TableName("discussmengbaoxinxi")
public class DiscussmengbaoxinxiView  extends DiscussmengbaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussmengbaoxinxiView(){
	}
 
 	public DiscussmengbaoxinxiView(DiscussmengbaoxinxiEntity discussmengbaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussmengbaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
