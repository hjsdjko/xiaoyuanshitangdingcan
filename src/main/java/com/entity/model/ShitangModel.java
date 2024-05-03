package com.entity.model;

import com.entity.ShitangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 食堂
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShitangModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 食堂编号
     */
    private String shitangUuidNumber;


    /**
     * 食堂名称
     */
    private String shitangName;


    /**
     * 食堂照片
     */
    private String shitangPhoto;


    /**
     * 食堂类型
     */
    private Integer shitangTypes;


    /**
     * 食堂地址
     */
    private String shitangAdd;


    /**
     * 食堂热度
     */
    private Integer shitangClicknum;


    /**
     * 食堂介绍
     */
    private String shitangContent;


    /**
     * 逻辑删除
     */
    private Integer shitangDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
