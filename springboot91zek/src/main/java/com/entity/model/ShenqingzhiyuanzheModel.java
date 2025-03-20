package com.entity.model;

import com.entity.ShenqingzhiyuanzheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 申请志愿者
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2023-01-19 12:40:35
 */
public class ShenqingzhiyuanzheModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 主题
	 */
	
	private String zhuti;
		
	/**
	 * 志愿经历
	 */
	
	private String zhiyuanjingli;
		
	/**
	 * 志愿活动意向
	 */
	
	private String zhiyuanhuodongyixiang;
		
	/**
	 * 申请时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shenqingshijian;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：主题
	 */
	 
	public void setZhuti(String zhuti) {
		this.zhuti = zhuti;
	}
	
	/**
	 * 获取：主题
	 */
	public String getZhuti() {
		return zhuti;
	}
				
	
	/**
	 * 设置：志愿经历
	 */
	 
	public void setZhiyuanjingli(String zhiyuanjingli) {
		this.zhiyuanjingli = zhiyuanjingli;
	}
	
	/**
	 * 获取：志愿经历
	 */
	public String getZhiyuanjingli() {
		return zhiyuanjingli;
	}
				
	
	/**
	 * 设置：志愿活动意向
	 */
	 
	public void setZhiyuanhuodongyixiang(String zhiyuanhuodongyixiang) {
		this.zhiyuanhuodongyixiang = zhiyuanhuodongyixiang;
	}
	
	/**
	 * 获取：志愿活动意向
	 */
	public String getZhiyuanhuodongyixiang() {
		return zhiyuanhuodongyixiang;
	}
				
	
	/**
	 * 设置：申请时间
	 */
	 
	public void setShenqingshijian(Date shenqingshijian) {
		this.shenqingshijian = shenqingshijian;
	}
	
	/**
	 * 获取：申请时间
	 */
	public Date getShenqingshijian() {
		return shenqingshijian;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
