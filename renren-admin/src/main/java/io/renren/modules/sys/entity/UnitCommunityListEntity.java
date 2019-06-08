package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 小区号
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@Data
public class UnitCommunityListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Long userId;
	/**
	 * 小区名
	 */
	private String name;
	/**
	 * 房间个数
	 */
	private Integer roomCount;
	/**
	 * 楼层个数
	 */
	private Integer buildingCount;

	/**
	 * 总记录数
	 */
	private int totalCount;
}
