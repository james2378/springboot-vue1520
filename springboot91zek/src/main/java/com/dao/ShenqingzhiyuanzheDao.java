package com.dao;

import com.entity.ShenqingzhiyuanzheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShenqingzhiyuanzheVO;
import com.entity.view.ShenqingzhiyuanzheView;


/**
 * 申请志愿者
 * 
 * @author 
 * @email 
 * @date 2023-01-19 12:40:35
 */
public interface ShenqingzhiyuanzheDao extends BaseMapper<ShenqingzhiyuanzheEntity> {
	
	List<ShenqingzhiyuanzheVO> selectListVO(@Param("ew") Wrapper<ShenqingzhiyuanzheEntity> wrapper);
	
	ShenqingzhiyuanzheVO selectVO(@Param("ew") Wrapper<ShenqingzhiyuanzheEntity> wrapper);
	
	List<ShenqingzhiyuanzheView> selectListView(@Param("ew") Wrapper<ShenqingzhiyuanzheEntity> wrapper);

	List<ShenqingzhiyuanzheView> selectListView(Pagination page,@Param("ew") Wrapper<ShenqingzhiyuanzheEntity> wrapper);
	
	ShenqingzhiyuanzheView selectView(@Param("ew") Wrapper<ShenqingzhiyuanzheEntity> wrapper);
	

}
