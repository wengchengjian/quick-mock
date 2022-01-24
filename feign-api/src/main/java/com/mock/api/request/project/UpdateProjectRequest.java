package com.mock.api.request.project;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @Author 翁丞健
 * @Date 2022/1/24 20:40
 * @Version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="更新Project请求对象", description="")
public class UpdateProjectRequest {
    private static final long serialVersionUID=1L;

    @NotNull
    @ApiModelProperty(value = "项目id")
    private Long id;

    @ApiModelProperty(value = "项目名称")
    private String name;

    @ApiModelProperty(value = "项目基础路径")
    private String baseUrl;

    @ApiModelProperty(value = "项目描述")
    private String description;

}