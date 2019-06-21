package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 余额表
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-11 00:36:15
 */
@Data
public class RechargeListEntity implements Serializable {
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
	 * 小区名
	 */
	private String comName;
	/**
	 * 楼号
	 */
	private String buildingNo;
	/**
	 * 单元室
	 */
	private String cell;
	/**
	 * 房号
	 */
	private String room;
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

	/**
	 * 总记录数
	 */
	private int totalCount;


}
