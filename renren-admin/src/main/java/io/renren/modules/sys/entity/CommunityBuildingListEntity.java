package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 楼号
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-06-05 01:55:52
 */
@Data
public class CommunityBuildingListEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 楼号
	 */
	private String no;
	/**
	 * 小区名
	 */
	private String communityName;

	/**
	 * 房间数目
	 */
	private int roomCount;
	/**
	 * 总记录数
	 */
	private int totalCount;

}
