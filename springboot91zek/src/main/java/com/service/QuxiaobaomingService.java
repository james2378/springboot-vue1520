package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QuxiaobaomingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QuxiaobaomingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QuxiaobaomingView;


/**
 * 取消报名
 *
 * @author 
 * @email 
 * @date 2023-01-19 12:40:35
 */
public interface QuxiaobaomingService extends IService<QuxiaobaomingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QuxiaobaomingVO> selectListVO(Wrapper<QuxiaobaomingEntity> wrapper);
   	
   	QuxiaobaomingVO selectVO(@Param("ew") Wrapper<QuxiaobaomingEntity> wrapper);
   	
   	List<QuxiaobaomingView> selectListView(Wrapper<QuxiaobaomingEntity> wrapper);
   	
   	QuxiaobaomingView selectView(@Param("ew") Wrapper<QuxiaobaomingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QuxiaobaomingEntity> wrapper);
   	

}

