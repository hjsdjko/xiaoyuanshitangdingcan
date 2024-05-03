package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.MeishiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 美食
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("meishi")
public class MeishiView extends MeishiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 美食类型的值
	*/
	@ColumnInfo(comment="美食类型的字典表值",type="varchar(200)")
	private String meishiValue;
	/**
	* 是否上架的值
	*/
	@ColumnInfo(comment="是否上架的字典表值",type="varchar(200)")
	private String shangxiaValue;

	//级联表 商家
		/**
		* 商家名称
		*/

		@ColumnInfo(comment="商家名称",type="varchar(200)")
		private String shangjiaName;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String shangjiaPhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String shangjiaEmail;
		/**
		* 营业执照展示
		*/

		@ColumnInfo(comment="营业执照展示",type="varchar(200)")
		private String shangjiaPhoto;
		/**
		* 商家类型
		*/
		@ColumnInfo(comment="商家类型",type="int(11)")
		private Integer shangjiaTypes;
			/**
			* 商家类型的值
			*/
			@ColumnInfo(comment="商家类型的字典表值",type="varchar(200)")
			private String shangjiaValue;
		/**
		* 现有余额
		*/
		@ColumnInfo(comment="现有余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 商家介绍
		*/

		@ColumnInfo(comment="商家介绍",type="longtext")
		private String shangjiaContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shangjiaDelete;
	//级联表 食堂
		/**
		* 食堂编号
		*/

		@ColumnInfo(comment="食堂编号",type="varchar(200)")
		private String shitangUuidNumber;
		/**
		* 食堂名称
		*/

		@ColumnInfo(comment="食堂名称",type="varchar(200)")
		private String shitangName;
		/**
		* 食堂照片
		*/

		@ColumnInfo(comment="食堂照片",type="varchar(200)")
		private String shitangPhoto;
		/**
		* 食堂类型
		*/
		@ColumnInfo(comment="食堂类型",type="int(11)")
		private Integer shitangTypes;
			/**
			* 食堂类型的值
			*/
			@ColumnInfo(comment="食堂类型的字典表值",type="varchar(200)")
			private String shitangValue;
		/**
		* 食堂地址
		*/

		@ColumnInfo(comment="食堂地址",type="varchar(200)")
		private String shitangAdd;
		/**
		* 食堂热度
		*/

		@ColumnInfo(comment="食堂热度",type="int(11)")
		private Integer shitangClicknum;
		/**
		* 食堂介绍
		*/

		@ColumnInfo(comment="食堂介绍",type="longtext")
		private String shitangContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shitangDelete;



	public MeishiView() {

	}

	public MeishiView(MeishiEntity meishiEntity) {
		try {
			BeanUtils.copyProperties(this, meishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 美食类型的值
	*/
	public String getMeishiValue() {
		return meishiValue;
	}
	/**
	* 设置： 美食类型的值
	*/
	public void setMeishiValue(String meishiValue) {
		this.meishiValue = meishiValue;
	}
	//当前表的
	/**
	* 获取： 是否上架的值
	*/
	public String getShangxiaValue() {
		return shangxiaValue;
	}
	/**
	* 设置： 是否上架的值
	*/
	public void setShangxiaValue(String shangxiaValue) {
		this.shangxiaValue = shangxiaValue;
	}


	//级联表的get和set 商家

		/**
		* 获取： 商家名称
		*/
		public String getShangjiaName() {
			return shangjiaName;
		}
		/**
		* 设置： 商家名称
		*/
		public void setShangjiaName(String shangjiaName) {
			this.shangjiaName = shangjiaName;
		}

		/**
		* 获取： 联系方式
		*/
		public String getShangjiaPhone() {
			return shangjiaPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setShangjiaPhone(String shangjiaPhone) {
			this.shangjiaPhone = shangjiaPhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getShangjiaEmail() {
			return shangjiaEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setShangjiaEmail(String shangjiaEmail) {
			this.shangjiaEmail = shangjiaEmail;
		}

		/**
		* 获取： 营业执照展示
		*/
		public String getShangjiaPhoto() {
			return shangjiaPhoto;
		}
		/**
		* 设置： 营业执照展示
		*/
		public void setShangjiaPhoto(String shangjiaPhoto) {
			this.shangjiaPhoto = shangjiaPhoto;
		}
		/**
		* 获取： 商家类型
		*/
		public Integer getShangjiaTypes() {
			return shangjiaTypes;
		}
		/**
		* 设置： 商家类型
		*/
		public void setShangjiaTypes(Integer shangjiaTypes) {
			this.shangjiaTypes = shangjiaTypes;
		}


			/**
			* 获取： 商家类型的值
			*/
			public String getShangjiaValue() {
				return shangjiaValue;
			}
			/**
			* 设置： 商家类型的值
			*/
			public void setShangjiaValue(String shangjiaValue) {
				this.shangjiaValue = shangjiaValue;
			}

		/**
		* 获取： 现有余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 现有余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 商家介绍
		*/
		public String getShangjiaContent() {
			return shangjiaContent;
		}
		/**
		* 设置： 商家介绍
		*/
		public void setShangjiaContent(String shangjiaContent) {
			this.shangjiaContent = shangjiaContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShangjiaDelete() {
			return shangjiaDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShangjiaDelete(Integer shangjiaDelete) {
			this.shangjiaDelete = shangjiaDelete;
		}
	//级联表的get和set 食堂

		/**
		* 获取： 食堂编号
		*/
		public String getShitangUuidNumber() {
			return shitangUuidNumber;
		}
		/**
		* 设置： 食堂编号
		*/
		public void setShitangUuidNumber(String shitangUuidNumber) {
			this.shitangUuidNumber = shitangUuidNumber;
		}

		/**
		* 获取： 食堂名称
		*/
		public String getShitangName() {
			return shitangName;
		}
		/**
		* 设置： 食堂名称
		*/
		public void setShitangName(String shitangName) {
			this.shitangName = shitangName;
		}

		/**
		* 获取： 食堂照片
		*/
		public String getShitangPhoto() {
			return shitangPhoto;
		}
		/**
		* 设置： 食堂照片
		*/
		public void setShitangPhoto(String shitangPhoto) {
			this.shitangPhoto = shitangPhoto;
		}
		/**
		* 获取： 食堂类型
		*/
		public Integer getShitangTypes() {
			return shitangTypes;
		}
		/**
		* 设置： 食堂类型
		*/
		public void setShitangTypes(Integer shitangTypes) {
			this.shitangTypes = shitangTypes;
		}


			/**
			* 获取： 食堂类型的值
			*/
			public String getShitangValue() {
				return shitangValue;
			}
			/**
			* 设置： 食堂类型的值
			*/
			public void setShitangValue(String shitangValue) {
				this.shitangValue = shitangValue;
			}

		/**
		* 获取： 食堂地址
		*/
		public String getShitangAdd() {
			return shitangAdd;
		}
		/**
		* 设置： 食堂地址
		*/
		public void setShitangAdd(String shitangAdd) {
			this.shitangAdd = shitangAdd;
		}

		/**
		* 获取： 食堂热度
		*/
		public Integer getShitangClicknum() {
			return shitangClicknum;
		}
		/**
		* 设置： 食堂热度
		*/
		public void setShitangClicknum(Integer shitangClicknum) {
			this.shitangClicknum = shitangClicknum;
		}

		/**
		* 获取： 食堂介绍
		*/
		public String getShitangContent() {
			return shitangContent;
		}
		/**
		* 设置： 食堂介绍
		*/
		public void setShitangContent(String shitangContent) {
			this.shitangContent = shitangContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShitangDelete() {
			return shitangDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShitangDelete(Integer shitangDelete) {
			this.shitangDelete = shitangDelete;
		}


	@Override
	public String toString() {
		return "MeishiView{" +
			", meishiValue=" + meishiValue +
			", shangxiaValue=" + shangxiaValue +
			", shitangUuidNumber=" + shitangUuidNumber +
			", shitangName=" + shitangName +
			", shitangPhoto=" + shitangPhoto +
			", shitangAdd=" + shitangAdd +
			", shitangClicknum=" + shitangClicknum +
			", shitangContent=" + shitangContent +
			", shitangDelete=" + shitangDelete +
			", shangjiaName=" + shangjiaName +
			", shangjiaPhone=" + shangjiaPhone +
			", shangjiaEmail=" + shangjiaEmail +
			", shangjiaPhoto=" + shangjiaPhoto +
			", newMoney=" + newMoney +
			", shangjiaContent=" + shangjiaContent +
			", shangjiaDelete=" + shangjiaDelete +
			"} " + super.toString();
	}
}
