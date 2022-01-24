package com.mock.api.request.group;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author 翁丞健
 * @Date 2022/1/24 20:50
 * @Version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="创建Group请求对象", description="")
public class CreateGroupRequest implements Serializable {
    private static final long serialVersionUID=1L;

    @NotNull
    @ApiModelProperty(value = "分组名称")
    private String name;

    @ApiModelProperty(value = "项目基础路径")
    private String baseUrl;

    @ApiModelProperty(value = "项目描述")
    private String description;

    @NotNull
    @ApiModelProperty(value = "分组所属项目id,项目->分组 1对多的关系")
    private Long projectId;

}
