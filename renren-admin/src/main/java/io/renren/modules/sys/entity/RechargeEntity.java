package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 余额表
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-11 00:36:15
 */
@Data
@TableName("tb_recharge")
public class RechargeEntity implements Serializable {
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
	 * 房间号id
	 */
	private Integer roomId;
	/**
	 * 余额
	 */
	private BigDecimal money;
	/**
	 * 上次更新时间
	 */
	private Date updateTime;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
