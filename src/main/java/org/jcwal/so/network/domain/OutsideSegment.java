package org.jcwal.so.network.domain;

import javax.persistence.Entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.macula.core.domain.AbstractAuditable;

@Entity
@DynamicInsert
@DynamicUpdate
public class OutsideSegment extends AbstractAuditable<Long> {

	private static final long serialVersionUID = 1L;
	//线路名称	电路编号	端口	IP地址数	起始IP地址	终止IP地址	子网掩码	网关	主DNS	备DNS
	private String tline;
	private String tlineCode;
	private String tport;
	private String tipSize;
	private String tstartIp;
	private String tendIp;
	private String tmask;
	private String tgateway;
	private String tmainDns;
	private String tsecondDns;

	public String getTline() {
		return tline;
	}

	public void setTline(String tline) {
		this.tline = tline;
	}

	public String getTlineCode() {
		return tlineCode;
	}

	public void setTlineCode(String tlineCode) {
		this.tlineCode = tlineCode;
	}

	public String getTport() {
		return tport;
	}

	public void setTport(String tport) {
		this.tport = tport;
	}

	public String getTipSize() {
		return tipSize;
	}

	public void setTipSize(String tipSize) {
		this.tipSize = tipSize;
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

	public String getTmainDns() {
		return tmainDns;
	}

	public void setTmainDns(String tmainDns) {
		this.tmainDns = tmainDns;
	}

	public String getTsecondDns() {
		return tsecondDns;
	}

	public void setTsecondDns(String tsecondDns) {
		this.tsecondDns = tsecondDns;
	}

}
