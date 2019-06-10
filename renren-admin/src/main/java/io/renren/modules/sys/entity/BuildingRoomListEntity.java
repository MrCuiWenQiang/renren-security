package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 单元房间号
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@Data
public class BuildingRoomListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 单元室
	 */
	private String cell;
	/**
	 * 房号
	 */
	private String room;
	/**
	 * 楼号id
	 */
	private int buildingId;

	private boolean isBind;//用户是否微信绑定

	/**
	 * 总记录数
	 */
	private int totalCount;

	/**
	 * 绑定的用户Id
	 */
	private long bindUserId;
	/**
	 * 绑定状态
	 */
	private String bindStatus;

	/**
	 * 绑定的用户名称
	 */
	private String bindUserName;
	/**
	 * 小区名
	 */
	private String comName;
	/**
	 * 楼号
	 */
	private String buildingNo;


}
