package com.gpdi.common.domain;

/**
 * 出租车对象
 * @author Tom
 *
 */
public class People {
	//纬度
	private Double lat;
	//经度
	private Double lon;
	//微信号
	private String wxNo;
	//昵称
	private String nickName;
	//性别
	private String sex;



	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}

	public String getWxNo() {
		return wxNo;
	}

	public void setWxNo(String wxNo) {
		this.wxNo = wxNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public People(String wxNo, String nickName,String sex, Double lat, Double lon) {
		this.wxNo = wxNo;
		this.nickName = nickName;
		this.sex = sex;
		this.lat = lat;
		this.lon = lon;
	}
}
