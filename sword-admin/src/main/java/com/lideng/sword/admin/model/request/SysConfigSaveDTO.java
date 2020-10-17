package com.lideng.sword.admin.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lideng
 */
@Data
public class SysConfigSaveDTO implements Serializable,Cloneable{

    private static final long serialVersionUID = 1L;

    private String value;

    private String label;

    private String type;

    private String description;

    private String sort;

    private String remarks;

}