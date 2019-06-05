package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 日份表
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@Data
@TableName("tb_water_calculate_day")
public class WaterCalculateDayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 给水号
	 */
	private String waterNo;
	/**
	 * 日期
	 */
	private Date day;
	/**
	 * 用水总量
	 */
	private BigDecimal consumption;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 上一次数据更新时间
	 */
	private Date updateTime;

}
