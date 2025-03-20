package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.QuxiaobaomingDao;
import com.entity.QuxiaobaomingEntity;
import com.service.QuxiaobaomingService;
import com.entity.vo.QuxiaobaomingVO;
import com.entity.view.QuxiaobaomingView;

@Service("quxiaobaomingService")
public class QuxiaobaomingServiceImpl extends ServiceImpl<QuxiaobaomingDao, QuxiaobaomingEntity> implements QuxiaobaomingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuxiaobaomingEntity> page = this.selectPage(
                new Query<QuxiaobaomingEntity>(params).getPage(),
                new EntityWrapper<QuxiaobaomingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QuxiaobaomingEntity> wrapper) {
		  Page<QuxiaobaomingView> page =new Query<QuxiaobaomingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<QuxiaobaomingVO> selectListVO(Wrapper<QuxiaobaomingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QuxiaobaomingVO selectVO(Wrapper<QuxiaobaomingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QuxiaobaomingView> selectListView(Wrapper<QuxiaobaomingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuxiaobaomingView selectView(Wrapper<QuxiaobaomingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
