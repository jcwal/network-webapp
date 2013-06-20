package org.jcwal.so.network.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.macula.core.domain.AbstractAuditable;
import org.macula.core.utils.EnvironmentUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicInsert
@DynamicUpdate
public class NetworkResource extends AbstractAuditable<Long> {

	private static final long serialVersionUID = 1L;

	private String ip;
	private String type;

	// mac 地址
	private String tmac;
	//设备类型（网络设备/服务器/虚拟机）	
	private String tgroup;
	//设备型号	
	private String tmodel;
	//设备名称	
	private String tname;
	//应用系统	
	private String tapplication;
	//用途	
	private String tusage;
	// 操作系统	
	private String toperation;
	//网络区域（生产/办公/DMZ）	
	private String tarea;
	//所在机房	
	private String troom;
	//机架位置	
	private String tposition;
	//所在交换机IP	
	private String tswitchIp;
	//交换机端口号	
	private String tswitchPort;
	//配线架号	
	private String tdist;

	//////////////////////////////////外网///////////////////////////////////
	//域名
	private String tdomain;
	//VSIP
	private String tvsIp;
	//F5IP
	private String tf5Ip;
	//内网发布端口
	private String tinsidePort;
	//公网IP
	private String toutsideIp;
	//公网发布端口
	private String toutsidePort;
	//服务器IP
	private String tserverIp;

	//线路名称
	private String tline;
	//备注
	private String comments;

	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "networkResource")
	private List<RentResource> rents = new ArrayList<RentResource>();

	public NetworkResource() {
	}

	public NetworkResource(Long id) {
		this.setId(id);
	}

	public String getMac() {
		return tmac;
	}

	public void setMac(String mac) {
		this.tmac = mac;
	}

	public NetworkResource updateRents() {
		if (rents != null) {
			List<RentResource> removed = new ArrayList<RentResource>();
			for (RentResource rent : rents) {
				if (rent.isDeleted()) {
					removed.add(rent);
				} else if (rent.getNetworkResource() == null) {
					rent.setNetworkResource(this);
				}
			}
			for (RentResource rent : removed) {
				rent.setNetworkResource(null);
				rents.remove(rent);
			}
		}
		return this;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@JsonIgnore
	public boolean isUsable() {
		Date now = EnvironmentUtils.getCurrentTime();
		if (rents != null) {
			for (RentResource rent : rents) {
				if ((rent.getBeginDate() == null || rent.getBeginDate().before(now))
						&& (rent.getEndDate() == null || rent.getEndDate().after(now))) {
					return false;
				}
			}
		}
		return true;
	}

	public List<RentResource> getRents() {
		return rents;
	}

	public void setRents(List<RentResource> rents) {
		this.rents = rents;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTgroup() {
		return tgroup;
	}

	public void setTgroup(String tgroup) {
		this.tgroup = tgroup;
	}

	public String getTmodel() {
		return tmodel;
	}

	public void setTmodel(String tmodel) {
		this.tmodel = tmodel;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getTapplication() {
		return tapplication;
	}

	public void setTapplication(String tapplication) {
		this.tapplication = tapplication;
	}

	public String getTusage() {
		return tusage;
	}

	public void setTusage(String tusage) {
		this.tusage = tusage;
	}

	public String getToperation() {
		return toperation;
	}

	public void setToperation(String toperation) {
		this.toperation = toperation;
	}

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getTroom() {
		return troom;
	}

	public void setTroom(String troom) {
		this.troom = troom;
	}

	public String getTposition() {
		return tposition;
	}

	public void setTposition(String tposition) {
		this.tposition = tposition;
	}

	public String getTswitchIp() {
		return tswitchIp;
	}

	public void setTswitchIp(String tswitchIp) {
		this.tswitchIp = tswitchIp;
	}

	public String getTswitchPort() {
		return tswitchPort;
	}

	public void setTswitchPort(String tswitchPort) {
		this.tswitchPort = tswitchPort;
	}

	public String getTdist() {
		return tdist;
	}

	public void setTdist(String tdist) {
		this.tdist = tdist;
	}

	public String getTdomain() {
		return tdomain;
	}

	public void setTdomain(String tdomain) {
		this.tdomain = tdomain;
	}

	public String getTvsIp() {
		return tvsIp;
	}

	public void setTvsIp(String tvsIp) {
		this.tvsIp = tvsIp;
	}

	public String getTf5Ip() {
		return tf5Ip;
	}

	public void setTf5Ip(String tf5Ip) {
		this.tf5Ip = tf5Ip;
	}

	public String getTinsidePort() {
		return tinsidePort;
	}

	public void setTinsidePort(String tinsidePort) {
		this.tinsidePort = tinsidePort;
	}

	public String getToutsideIp() {
		return toutsideIp;
	}

	public void setToutsideIp(String toutsideIp) {
		this.toutsideIp = toutsideIp;
	}

	public String getToutsidePort() {
		return toutsidePort;
	}

	public void setToutsidePort(String toutsidePort) {
		this.toutsidePort = toutsidePort;
	}

	public String getTserverIp() {
		return tserverIp;
	}

	public void setTserverIp(String tserverIp) {
		this.tserverIp = tserverIp;
	}

	public String getTline() {
		return tline;
	}

	public void setTline(String tline) {
		this.tline = tline;
	}

}
