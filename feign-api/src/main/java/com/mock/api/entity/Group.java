package com.mock.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author WengChengjian
 * @since 2022-01-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Group对象", description="")
public class Group implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "分组id")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "分组名称")
    private String name;

    @ApiModelProperty(value = "项目基础路径")
    private String baseUrl;

    @ApiModelProperty(value = "项目描述")
    private String description;

    @ApiModelProperty(value = "分组所属项目id,项目->分组 1对多的关系")
    private Long projectId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;


}
