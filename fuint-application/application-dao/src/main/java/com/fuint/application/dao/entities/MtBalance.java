package com.fuint.application.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * mt_balance 实体类
 * Created by FSQ
 * Contact wx fsq_better
 * Site https://www.fuint.cn
 */ 
@Entity 
@Table(name = "mt_balance")
public class MtBalance implements Serializable{
   /**
    * 自增ID 
    */ 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 11)
    private Integer id;

   /**
    * 手机号 
    */ 
    @Column(name = "MOBILE", length = 11)
    private String mobile;

   /**
    * 用户ID 
    */ 
    @Column(name = "USER_ID", nullable = false, length = 11)
    private Integer userId;

   /**
    * 订单号 
    */ 
    @Column(name = "ORDER_SN", length = 32)
    private String orderSn;

   /**
    * 余额变化数量 
    */ 
    @Column(name = "AMOUNT", nullable = false)
    private BigDecimal amount;

   /**
    * 创建时间 
    */ 
    @Column(name = "CREATE_TIME")
    private Date createTime;

   /**
    * 更新时间 
    */ 
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

   /**
    * 备注说明 
    */ 
    @Column(name = "DESCRIPTION", length = 200)
    private String description;

   /**
    * 最后操作人 
    */ 
    @Column(name = "OPERATOR", length = 30)
    private String operator;

   /**
    * 状态，A正常；D作废 
    */ 
    @Column(name = "STATUS", length = 1)
    private String status;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public String getMobile(){
        return mobile;
    }
    public void setMobile(String mobile){
        this.mobile=mobile;
    }
    public Integer getUserId(){
        return userId;
    }
    public void setUserId(Integer userId){
        this.userId=userId;
    }
    public String getOrderSn(){
        return orderSn;
    }
    public void setOrderSn(String orderSn){
        this.orderSn=orderSn;
    }
    public BigDecimal getAmount(){
        return amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount=amount;
    }
    public Date getCreateTime(){
        return createTime;
    }
    public void setCreateTime(Date createTime){
        this.createTime=createTime;
    }
    public Date getUpdateTime(){
        return updateTime;
    }
    public void setUpdateTime(Date updateTime){
        this.updateTime=updateTime;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public String getOperator(){
        return operator;
    }
    public void setOperator(String operator){
        this.operator=operator;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status=status;
    }
}
