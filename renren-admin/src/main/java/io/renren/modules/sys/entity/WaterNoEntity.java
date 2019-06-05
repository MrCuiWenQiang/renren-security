package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 给水号表
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@Data
@TableName("tb_water_no")
public class WaterNoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 给水号
	 */
	private String waterNo;
	/**
	 * 设备名称
	 */
	private String deviceName;
	/**
	 * 设备类型
	 */
	private Integer deviceType;
	/**
	 * 设备状态 0正常 1 停用
	 */
	private Integer deviceStatus;
	/**
	 * 备注
	 */
	private String remarks;
	/**
	 * 房间表id
	 */
	private Integer roomId;

}
