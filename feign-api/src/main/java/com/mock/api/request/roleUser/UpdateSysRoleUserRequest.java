package com.mock.api.request.roleUser;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author 翁丞健
 * @Date 2022/1/24 21:20
 * @Version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="创建SysRoleUser请求对象", description="")
public class UpdateSysRoleUserRequest implements Serializable {
    private static final long serialVersionUID=1L;

    @NotNull
    @ApiModelProperty(value = "角色与用户关系主键id")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @NotNull
    @ApiModelProperty(value = "角色id")
    private Long roleId;
}
