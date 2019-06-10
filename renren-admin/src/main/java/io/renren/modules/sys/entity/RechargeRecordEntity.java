package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

/**
 * 充值记录表
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-09 11:53:03
 */
@Data
@TableName("tb_recharge_record")
public class RechargeRecordEntity implements Serializable {
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
	 * 充值人id
	 */
	private Long rechargeUserId;
	/**
	 * 充值金额
	 */
	private BigDecimal money;
	/**
	 * 支付类型 1：平台充值  2.微信充值
	 */
	private Integer type;
	/**
	 * 支付状态  0：支付成功  1：支付失败
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
