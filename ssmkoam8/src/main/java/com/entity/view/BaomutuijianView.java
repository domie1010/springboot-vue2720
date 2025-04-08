package com.entity.view;

import com.entity.BaomutuijianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 保姆推荐
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
@TableName("baomutuijian")
public class BaomutuijianView  extends BaomutuijianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public BaomutuijianView(){
	}
 
 	public BaomutuijianView(BaomutuijianEntity baomutuijianEntity){
 	try {
			BeanUtils.copyProperties(this, baomutuijianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
