package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShenqingzhiyuanzheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShenqingzhiyuanzheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShenqingzhiyuanzheView;


/**
 * 申请志愿者
 *
 * @author 
 * @email 
 * @date 2023-01-19 12:40:35
 */
public interface ShenqingzhiyuanzheService extends IService<ShenqingzhiyuanzheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenqingzhiyuanzheVO> selectListVO(Wrapper<ShenqingzhiyuanzheEntity> wrapper);
   	
   	ShenqingzhiyuanzheVO selectVO(@Param("ew") Wrapper<ShenqingzhiyuanzheEntity> wrapper);
   	
   	List<ShenqingzhiyuanzheView> selectListView(Wrapper<ShenqingzhiyuanzheEntity> wrapper);
   	
   	ShenqingzhiyuanzheView selectView(@Param("ew") Wrapper<ShenqingzhiyuanzheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenqingzhiyuanzheEntity> wrapper);
   	

}

