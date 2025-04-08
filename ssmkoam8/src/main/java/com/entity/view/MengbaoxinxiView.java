package com.entity.view;

import com.entity.MengbaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 萌宝信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-06-02 21:36:34
 */
@TableName("mengbaoxinxi")
public class MengbaoxinxiView  extends MengbaoxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MengbaoxinxiView(){
	}
 
 	public MengbaoxinxiView(MengbaoxinxiEntity mengbaoxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, mengbaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
