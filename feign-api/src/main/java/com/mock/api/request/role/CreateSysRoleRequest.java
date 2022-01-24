package com.mock.api.request.role;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author 翁丞健
 * @Date 2022/1/24 20:57
 * @Version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="创建SysRole请求对象", description="")
public class CreateSysRoleRequest implements Serializable {
    private static final long serialVersionUID=1L;

    @NotNull
    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色描述")
    private String description;

}
