package com.mock.api.request.user;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author 翁丞健
 * @Date 2022/1/24 21:02
 * @Version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "创建SysUser请求对象", description = "")
public class CreateSysUserRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(value = "用户名")
    private String accontName;

    @NotNull
    @ApiModelProperty(value = "用户密码")
    private String passowrd;

    @NotNull
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @NotNull
    @ApiModelProperty(value = "用户邮箱")
    private String eamil;

    @ApiModelProperty(value = "自我介绍")
    private String description;

    @ApiModelProperty(value = "用户头像")
    private String avatar;

}
