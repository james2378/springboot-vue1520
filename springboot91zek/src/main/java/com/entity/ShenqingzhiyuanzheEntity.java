package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 申请志愿者
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-01-19 12:40:35
 */
@TableName("shenqingzhiyuanzhe")
public class ShenqingzhiyuanzheEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShenqingzhiyuanzheEntity() {
		
	}
	
	public ShenqingzhiyuanzheEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
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
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：用户账号
	 */
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
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
