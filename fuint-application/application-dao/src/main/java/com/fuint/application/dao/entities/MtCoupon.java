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
 * mt_coupon 实体类
 * Created by FSQ
 * Contact wx fsq_better
 * Site https://www.fuint.cn
 */
@Entity 
@Table(name = "mt_coupon")
public class MtCoupon implements Serializable{
   /**
    * 自增ID 
    */ 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, length = 10)
    private Integer id;

   /**
    * 分组ID
    */ 
    @Column(name = "GROUP_ID", nullable = false, length = 10)
    private Integer groupId;

   /**
    * 券类型
    */
    @Column(name = "TYPE", nullable = false, length = 1)
    private String type;

   /**
    * 券名称 
    */ 
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;

   /**
    * 是否允许转赠
    */
    @Column(name = "IS_GIVE", length = 1)
    private Integer isGive;

   /**
    * 获得卡券所消耗积分
    */
    @Column(name = "POINT", length = 10)
    private Integer point;

   /**
    * 领取码
    */
    @Column(name = "RECEIVE_CODE", length = 32)
    private String receiveCode;

   /**
    * 开始有效期 
    */ 
    @Column(name = "BEGIN_TIME")
    private Date beginTime;

   /**
    * 结束有效期 
    */ 
    @Column(name = "END_TIME")
    private Date endTime;

   /**
    * 面额 
    */ 
    @Column(name = "AMOUNT")
    private BigDecimal amount;

   /**
    * 获取方式
    */
    @Column(name = "SEND_WAY", length = 20)
    private String sendWay;

    /**
     * 适用商品
     */
    @Column(name = "APPLY_GOODS", length = 20)
    private String applyGoods;

   /**
    * 每次发放数量
    */ 
    @Column(name = "SEND_NUM", length = 10)
    private Integer sendNum;

   /**
    * 发行总数量
    */
    @Column(name = "TOTAL", length = 10)
    private Integer total;

   /**
    * 数量限制
    */
   @Column(name = "LIMIT_NUM", length = 10)
   private Integer limitNum;

   /**
    * 例外日期，逗号隔开。周末：weekend；其他：2021-01-02~2021-02-09
    */ 
    @Column(name = "EXCEPT_TIME", length = 500)
    private String exceptTime;

   /**
    * 所属店铺ID,逗号隔开 
    */ 
    @Column(name = "STORE_IDS", length = 100)
    private String storeIds;

   /**
    * 描述信息 
    */ 
    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

   /**
    * 效果图片 
    */ 
    @Column(name = "IMAGE", length = 100)
    private String image;

   /**
    * 后台备注 
    */ 
    @Column(name = "REMARKS", length = 1000)
    private String remarks;

   /**
    * 获取券的规则 
    */ 
    @Column(name = "IN_RULE", length = 1000)
    private String inRule;

   /**
    * 核销券的规则 
    */ 
    @Column(name = "OUT_RULE", length = 1000)
    private String outRule;

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
    * 最后操作人 
    */ 
    @Column(name = "OPERATOR", length = 30)
    private String operator;

   /**
    * A：正常；D：删除 
    */ 
    @Column(name = "STATUS", length = 1)
    private String status;

    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
    this.id=id;
    }
    public Integer getGroupId(){
        return groupId;
    }
    public void setGroupId(Integer groupId){
    this.groupId=groupId;
    }
    public String getType(){
           return type;
       }
    public void setType(String type){
           this.type=type;
       }
    public String getName(){
        return name;
    }
    public void setName(String name){
    this.name=name;
    }
    public Integer getIsGive(){
       return isGive;
   }
    public void setIsGive(Integer isGive){
       this.isGive=isGive;
   }
    public Integer getPoint(){
       return point;
   }
    public void setPoint(Integer point){
       this.point=point;
   }
    public String getReceiveCode(){
       return receiveCode;
   }
    public void setReceiveCode(String receiveCode){
           this.receiveCode=receiveCode;
       }
    public Date getBeginTime(){
        return beginTime;
    }
    public void setBeginTime(Date beginTime){
    this.beginTime=beginTime;
    }
    public Date getEndTime(){
        return endTime;
    }
    public void setEndTime(Date endTime){
    this.endTime=endTime;
    }
    public BigDecimal getAmount(){
        return amount;
    }
    public void setAmount(BigDecimal amount){
    this.amount=amount;
    }
    public String getSendWay(){
       return sendWay;
   }
    public void setSendWay(String sendWay){
           this.sendWay=sendWay;
       }
    public String getApplyGoods(){
        return applyGoods;
    }
    public void setApplyGoods(String applyGoods){
        this.applyGoods=applyGoods;
    }
    public Integer getSendNum(){
        return sendNum;
    }
    public void setSendNum(Integer sendNum){
    this.sendNum=sendNum;
    }
    public Integer getTotal(){
           return total;
       }
    public void setTotal(Integer total){
           this.total=total;
       }
    public Integer getLimitNum(){
       return limitNum;
   }
    public void setLimitNum(Integer limitNum){
           this.limitNum=limitNum;
       }
    public String getExceptTime(){
        return exceptTime;
    }
    public void setExceptTime(String exceptTime){
    this.exceptTime=exceptTime;
    }
    public String getStoreIds(){
        return storeIds;
    }
    public void setStoreIds(String storeIds){
    this.storeIds=storeIds;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
    this.description=description;
    }
    public String getImage(){
        return image;
    }
    public void setImage(String image){
    this.image=image;
    }
    public String getRemarks(){
        return remarks;
    }
    public void setRemarks(String remarks){
    this.remarks=remarks;
    }
    public String getInRule(){
        return inRule;
    }
    public void setInRule(String inRule){
    this.inRule=inRule;
    }
    public String getOutRule(){
        return outRule;
    }
    public void setOutRule(String outRule){
    this.outRule=outRule;
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

