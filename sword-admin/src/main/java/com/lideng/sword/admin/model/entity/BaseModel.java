package com.lideng.sword.admin.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

/**
 * 基础模型
 * @author lideng
 * @date Sep 13, 2018
 */
@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @Id
    @GenericGenerator(name = "idWorker", strategy = "com.lideng.sword.common.utils.IdGenerator" )
    @GeneratedValue(generator = "idWorker")
    @Column(name = "ID")
	private String id;

    @Column(name = "create_by")
    @CreatedBy
    private String createBy;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "last_update_by")
    @LastModifiedBy
    private String lastUpdateBy;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(name = "last_update_time")
    private Date lastUpdateTime;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "del_flag")
    private DelStatus delFlag;

    private Integer version;
}
