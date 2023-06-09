package com.fuint.base.dao.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 平台实体
 *
 * Created by FSQ
 * Contact wx fsq_better
 */
@Entity
@Table(name = "t_platform")
@NamedQuery(name = "TPlatform.findAll", query = "SELECT c FROM TPlatform c")
public class TPlatform implements Serializable {

    /**  */
    private static final long serialVersionUID = -6612153566082678820L;
    /**
     * 平台主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "owner_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "description", nullable = true)
    private String describe;

    @Column(name = "platform_type", nullable = false)
    private int platformType;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }


    public int getPlatformType() {
        return platformType;
    }

    public void setPlatformType(int platformType) {
        this.platformType = platformType;
    }
}
