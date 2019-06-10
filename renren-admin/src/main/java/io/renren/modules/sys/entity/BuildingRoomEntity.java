package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 单元房间号
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@Data
@TableName("tb_building_room")
public class BuildingRoomEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
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
	private Integer buildingId;
	/**
	 * 绑定的用户Id
 	 */
	private Long bindUserId;

}
