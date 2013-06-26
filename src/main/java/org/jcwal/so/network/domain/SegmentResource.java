package org.jcwal.so.network.domain;

import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.macula.core.domain.AbstractAuditable;

@Entity
@DynamicInsert
@DynamicUpdate
public class SegmentResource extends AbstractAuditable<Long> {

	private static final long serialVersionUID = 1L;
	private String type;
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
	private Date tvalidateDate;
	private Date tinvalidateDate;

	private String tline;
	private String telec;
	private String tport;
	//	private String tipSize;
	//	private String tstartIp;
	//	private String tendIp;
	//	private String tmask;
	//	private String tgateway;
	private String tmainDns;
	private String tsecondDns;
	//	private String comments;

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

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getTline() {
		return tline;
	}

	public void setTline(String tline) {
		this.tline = tline;
	}

	public String getTelec() {
		return telec;
	}

	public void setTelec(String telec) {
		this.telec = telec;
	}

	public String getTport() {
		return tport;
	}

	public void setTport(String tport) {
		this.tport = tport;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTvalidateDate() {
		return tvalidateDate;
	}

	public void setTvalidateDate(Date tvalidateDate) {
		this.tvalidateDate = tvalidateDate;
	}

	public Date getTinvalidateDate() {
		return tinvalidateDate;
	}

	public void setTinvalidateDate(Date tinvalidateDate) {
		this.tinvalidateDate = tinvalidateDate;
	}
}
