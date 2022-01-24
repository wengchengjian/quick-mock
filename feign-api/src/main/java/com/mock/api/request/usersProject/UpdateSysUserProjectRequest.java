package com.mock.api.request.usersProject;

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
 * @Date 2022/1/24 21:26
 * @Version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "更新SysUserProject请求对象", description = "")
public class UpdateSysUserProjectRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    @ApiModelProperty(value = "id")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "用户id")
    private Long userId;

    @NotNull
    @ApiModelProperty(value = "项目id")
    private Long projectId;

}
