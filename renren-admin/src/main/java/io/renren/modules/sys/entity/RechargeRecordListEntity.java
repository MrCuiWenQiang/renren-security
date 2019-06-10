package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class RechargeRecordListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 给水号
	 */
	private String waterNo;
	/**
	 * 充值人id
	 */
	private Long rechargeUserId;

	private String rechargeUserName;//充值人姓名
	private String typeName;//支付类型文字化
	private String statusName;//支付状态文字化
	private int totalCount;//总记录数

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
