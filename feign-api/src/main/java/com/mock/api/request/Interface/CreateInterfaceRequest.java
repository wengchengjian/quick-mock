package com.mock.api.request.Interface;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @Author 翁丞健
 * @Date 2022/1/22 19:08
 * @Version 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="创建Interface请求对象", description="")
public class CreateInterfaceRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String name;

    @NotNull
    private String methodType;

    @NotNull
    private String address;

    private Integer delay;

    private String description;

    @NotNull
    private String responseText;

    @NotNull
    private Long projectId;

    @NotNull
    private Long groupId;


}
