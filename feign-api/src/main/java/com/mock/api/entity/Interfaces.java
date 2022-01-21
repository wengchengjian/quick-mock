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
@ApiModel(value="Interfaces对象", description="")
public class Interfaces implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "接口id")
    @TableId(value = "id", type = IdType.ID_WORKER)
    private Long id;

    @ApiModelProperty(value = "接口名称")
    private String name;

    @ApiModelProperty(value = "接口方法类型")
    private String methodType;

    @ApiModelProperty(value = "接口状态,0 关闭,1 开启")
    private Integer status;

    @ApiModelProperty(value = "接口地址")
    private String address;

    @ApiModelProperty(value = "接口延时 单位ms 最大 65535")
    private Integer delay;

    @ApiModelProperty(value = "接口描述")
    private String description;

    @ApiModelProperty(value = "返回值")
    private String responseText;

    @ApiModelProperty(value = "接口所属项目id,项目->接口 1对多的关系")
    private Long projectId;

    @ApiModelProperty(value = "接口所属分组id,项目->接口 1对多的关系")
    private Long groupId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除")
    private Boolean deleted;


}
