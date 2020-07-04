package org.ygy.study.javacore.validation;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

/**
 *
 */
public class Drink {

    @NotBlank(groups = {Update.class, Add.class}, message = "名称不能为空")
    private String name;

    @NotBlank(groups = {Update.class, Add.class}, message = "描述不能为空")
    private String description;

    @Digits(groups = {Add.class}, integer = 2, fraction = 2,message = "单价不符合标准")
    private Double price;
}
