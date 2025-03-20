package com.entity.view;

import com.entity.ShenqingzhiyuanzheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 申请志愿者
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-01-19 12:40:35
 */
@TableName("shenqingzhiyuanzhe")
public class ShenqingzhiyuanzheView  extends ShenqingzhiyuanzheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenqingzhiyuanzheView(){
	}
 
 	public ShenqingzhiyuanzheView(ShenqingzhiyuanzheEntity shenqingzhiyuanzheEntity){
 	try {
			BeanUtils.copyProperties(this, shenqingzhiyuanzheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
