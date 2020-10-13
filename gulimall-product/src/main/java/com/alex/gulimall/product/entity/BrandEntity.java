package com.alex.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * 品牌
 * 
 * @author alex
 * @email 734663446@qq.com
 * @date 2020-09-24 21:34:09
 */
@Data
@TableName("pms_brand")
public class BrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 品牌id
	 */
	@TableId
	private Long brandId;
	/**
	 * 品牌名
	 */
	@NotBlank(message = "品牌名不能为空")
	private String name;
	/**
	 * 品牌logo地址
	 */
	@NotBlank(message = "品牌logo地址不能为空")
	@URL(message = "必须是有效的品牌logo地址")
	private String logo;
	/**
	 * 介绍
	 */
	private String descript;
	/**
	 * 显示状态[0-不显示；1-显示]
	 */
	
	private Integer showStatus;
	/**
	 * 检索首字母
	 */
	@Pattern(regexp = "/^a-zA-Z$/")
	private String firstLetter;
	/**
	 * 排序
	 */
	@Digits(message = "必须是数字", integer = 10, fraction = 0)
	@Min(value = 0, message = "必须是不小于0的整数")
	private Integer sort;
}
