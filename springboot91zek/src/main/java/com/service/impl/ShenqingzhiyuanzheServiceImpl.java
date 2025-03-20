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


import com.dao.ShenqingzhiyuanzheDao;
import com.entity.ShenqingzhiyuanzheEntity;
import com.service.ShenqingzhiyuanzheService;
import com.entity.vo.ShenqingzhiyuanzheVO;
import com.entity.view.ShenqingzhiyuanzheView;

@Service("shenqingzhiyuanzheService")
public class ShenqingzhiyuanzheServiceImpl extends ServiceImpl<ShenqingzhiyuanzheDao, ShenqingzhiyuanzheEntity> implements ShenqingzhiyuanzheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenqingzhiyuanzheEntity> page = this.selectPage(
                new Query<ShenqingzhiyuanzheEntity>(params).getPage(),
                new EntityWrapper<ShenqingzhiyuanzheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenqingzhiyuanzheEntity> wrapper) {
		  Page<ShenqingzhiyuanzheView> page =new Query<ShenqingzhiyuanzheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ShenqingzhiyuanzheVO> selectListVO(Wrapper<ShenqingzhiyuanzheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShenqingzhiyuanzheVO selectVO(Wrapper<ShenqingzhiyuanzheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShenqingzhiyuanzheView> selectListView(Wrapper<ShenqingzhiyuanzheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenqingzhiyuanzheView selectView(Wrapper<ShenqingzhiyuanzheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
