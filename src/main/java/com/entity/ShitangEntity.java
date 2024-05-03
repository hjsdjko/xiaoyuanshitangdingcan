package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 食堂
 *
 * @author 
 * @email
 */
@TableName("shitang")
public class ShitangEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShitangEntity() {

	}

	public ShitangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 食堂编号
     */
    @ColumnInfo(comment="食堂编号",type="varchar(200)")
    @TableField(value = "shitang_uuid_number")

    private String shitangUuidNumber;


    /**
     * 食堂名称
     */
    @ColumnInfo(comment="食堂名称",type="varchar(200)")
    @TableField(value = "shitang_name")

    private String shitangName;


    /**
     * 食堂照片
     */
    @ColumnInfo(comment="食堂照片",type="varchar(200)")
    @TableField(value = "shitang_photo")

    private String shitangPhoto;


    /**
     * 食堂类型
     */
    @ColumnInfo(comment="食堂类型",type="int(11)")
    @TableField(value = "shitang_types")

    private Integer shitangTypes;


    /**
     * 食堂地址
     */
    @ColumnInfo(comment="食堂地址",type="varchar(200)")
    @TableField(value = "shitang_add")

    private String shitangAdd;


    /**
     * 食堂热度
     */
    @ColumnInfo(comment="食堂热度",type="int(11)")
    @TableField(value = "shitang_clicknum")

    private Integer shitangClicknum;


    /**
     * 食堂介绍
     */
    @ColumnInfo(comment="食堂介绍",type="longtext")
    @TableField(value = "shitang_content")

    private String shitangContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "shitang_delete")

    private Integer shitangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：食堂编号
	 */
    public String getShitangUuidNumber() {
        return shitangUuidNumber;
    }
    /**
	 * 设置：食堂编号
	 */

    public void setShitangUuidNumber(String shitangUuidNumber) {
        this.shitangUuidNumber = shitangUuidNumber;
    }
    /**
	 * 获取：食堂名称
	 */
    public String getShitangName() {
        return shitangName;
    }
    /**
	 * 设置：食堂名称
	 */

    public void setShitangName(String shitangName) {
        this.shitangName = shitangName;
    }
    /**
	 * 获取：食堂照片
	 */
    public String getShitangPhoto() {
        return shitangPhoto;
    }
    /**
	 * 设置：食堂照片
	 */

    public void setShitangPhoto(String shitangPhoto) {
        this.shitangPhoto = shitangPhoto;
    }
    /**
	 * 获取：食堂类型
	 */
    public Integer getShitangTypes() {
        return shitangTypes;
    }
    /**
	 * 设置：食堂类型
	 */

    public void setShitangTypes(Integer shitangTypes) {
        this.shitangTypes = shitangTypes;
    }
    /**
	 * 获取：食堂地址
	 */
    public String getShitangAdd() {
        return shitangAdd;
    }
    /**
	 * 设置：食堂地址
	 */

    public void setShitangAdd(String shitangAdd) {
        this.shitangAdd = shitangAdd;
    }
    /**
	 * 获取：食堂热度
	 */
    public Integer getShitangClicknum() {
        return shitangClicknum;
    }
    /**
	 * 设置：食堂热度
	 */

    public void setShitangClicknum(Integer shitangClicknum) {
        this.shitangClicknum = shitangClicknum;
    }
    /**
	 * 获取：食堂介绍
	 */
    public String getShitangContent() {
        return shitangContent;
    }
    /**
	 * 设置：食堂介绍
	 */

    public void setShitangContent(String shitangContent) {
        this.shitangContent = shitangContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShitangDelete() {
        return shitangDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setShitangDelete(Integer shitangDelete) {
        this.shitangDelete = shitangDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shitang{" +
            ", id=" + id +
            ", shitangUuidNumber=" + shitangUuidNumber +
            ", shitangName=" + shitangName +
            ", shitangPhoto=" + shitangPhoto +
            ", shitangTypes=" + shitangTypes +
            ", shitangAdd=" + shitangAdd +
            ", shitangClicknum=" + shitangClicknum +
            ", shitangContent=" + shitangContent +
            ", shitangDelete=" + shitangDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
