package com.lideng.sword.admin.model.request;

import lombok.Data;

/**
 * @author lideng
 * @date 2019/10/08
 */
@Data
public class SysDictUpdateDTO {

    private String id;

    private String value;

    private String label;

    private String type;

    private String description;

    private String sort;

    private String remarks;

}