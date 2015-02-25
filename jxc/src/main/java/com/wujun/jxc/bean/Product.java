package com.wujun.jxc.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;
@Table("product")
public class Product {
	@Id
	int id;
	@Name
	String tiaoma;
	@Column
	String huohao;
	@Column
	String name;
	@Column
	double jinjia;
	@Column
	double kucun;
	@Column
	double xiaoliang;
	@Column
	double shoujia;
	@Column
	double youhuijia;
	@Column
	String danwei;
	@Column
	String info;
	@Many(field = "pid", target = Price.class)
	List<Price> prices;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTiaoma() {
		return tiaoma;
	}
	public void setTiaoma(String tiaoma) {
		this.tiaoma = tiaoma;
	}
	public String getHuohao() {
		return huohao;
	}
	public void setHuohao(String huohao) {
		this.huohao = huohao;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getJinjia() {
		return jinjia;
	}
	public void setJinjia(double jinjia) {
		this.jinjia = jinjia;
	}
	public double getKucun() {
		return kucun;
	}
	public void setKucun(double kucun) {
		this.kucun = kucun;
	}
	public double getXiaoliang() {
		return xiaoliang;
	}
	public void setXiaoliang(double xiaoliang) {
		this.xiaoliang = xiaoliang;
	}
	public double getShoujia() {
		return shoujia;
	}
	public void setShoujia(double shoujia) {
		this.shoujia = shoujia;
	}
	public String getDanwei() {
		return danwei;
	}
	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public double getYouhuijia() {
		return youhuijia;
	}
	public void setYouhuijia(double youhuijia) {
		this.youhuijia = youhuijia;
	}
	public List<Price> getPrices() {
		return prices;
	}
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}
	
}
