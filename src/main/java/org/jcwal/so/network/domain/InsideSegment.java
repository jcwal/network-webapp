package org.jcwal.so.network.domain;

import org.macula.core.domain.AbstractAuditable;

public class InsideSegment extends AbstractAuditable<Long> {

	private static final long serialVersionUID = 1L;
	//序号	区域	IP地址段（/24）	用  途	获取方式	VLAN 号	VLAN 名	起始IP	终止IP	IP地址数	子网掩码	网关	网关设备	保 留 IP	保留IP数	启用日期	取消日期	备注		
	private String tarea;
	private String tsegment;
	private String tusage;
	private String taccess;
	private String tvlanCode;
	private String tvlanName;

	private String tstartIp;
	private String tendIp;
	private String tipSize;
	private String tmask;
	private String tgateway;
	private String tgatewayType;
	private String tkeepIps;
	private String tkeepIpSize;
	private String tvalidateDate;
	private String tinvalidateDate;
	private String comments;

	public String getTarea() {
		return tarea;
	}

	public void setTarea(String tarea) {
		this.tarea = tarea;
	}

	public String getTsegment() {
		return tsegment;
	}

	public void setTsegment(String tsegment) {
		this.tsegment = tsegment;
	}

	public String getTusage() {
		return tusage;
	}

	public void setTusage(String tusage) {
		this.tusage = tusage;
	}

	public String getTaccess() {
		return taccess;
	}

	public void setTaccess(String taccess) {
		this.taccess = taccess;
	}

	public String getTvlanCode() {
		return tvlanCode;
	}

	public void setTvlanCode(String tvlanCode) {
		this.tvlanCode = tvlanCode;
	}

	public String getTvlanName() {
		return tvlanName;
	}

	public void setTvlanName(String tvlanName) {
		this.tvlanName = tvlanName;
	}

	public String getTstartIp() {
		return tstartIp;
	}

	public void setTstartIp(String tstartIp) {
		this.tstartIp = tstartIp;
	}

	public String getTendIp() {
		return tendIp;
	}

	public void setTendIp(String tendIp) {
		this.tendIp = tendIp;
	}

	public String getTipSize() {
		return tipSize;
	}

	public void setTipSize(String tipSize) {
		this.tipSize = tipSize;
	}

	public String getTmask() {
		return tmask;
	}

	public void setTmask(String tmask) {
		this.tmask = tmask;
	}

	public String getTgateway() {
		return tgateway;
	}

	public void setTgateway(String tgateway) {
		this.tgateway = tgateway;
	}

	public String getTgatewayType() {
		return tgatewayType;
	}

	public void setTgatewayType(String tgatewayType) {
		this.tgatewayType = tgatewayType;
	}

	public String getTkeepIps() {
		return tkeepIps;
	}

	public void setTkeepIps(String tkeepIps) {
		this.tkeepIps = tkeepIps;
	}

	public String getTkeepIpSize() {
		return tkeepIpSize;
	}

	public void setTkeepIpSize(String tkeepIpSize) {
		this.tkeepIpSize = tkeepIpSize;
	}

	public String getTvalidateDate() {
		return tvalidateDate;
	}

	public void setTvalidateDate(String tvalidateDate) {
		this.tvalidateDate = tvalidateDate;
	}

	public String getTinvalidateDate() {
		return tinvalidateDate;
	}

	public void setTinvalidateDate(String tinvalidateDate) {
		this.tinvalidateDate = tinvalidateDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
}
