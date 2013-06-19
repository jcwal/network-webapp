package org.jcwal.so.network.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.macula.core.domain.AbstractAuditable;

@Entity
@DynamicInsert
@DynamicUpdate
public class ServiceResource extends AbstractAuditable<Long> {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private NetworkResource source;
	@ManyToOne
	private NetworkResource target;

	private String application;
	private String apply;
	private String charge;

	private Date begin;
	private Date end;

	public NetworkResource getSource() {
		return source;
	}

	public void setSource(NetworkResource source) {
		this.source = source;
	}

	public NetworkResource getTarget() {
		return target;
	}

	public void setTarget(NetworkResource target) {
		this.target = target;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getApply() {
		return apply;
	}

	public void setApply(String apply) {
		this.apply = apply;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	private String comments;

	public NetworkResource getResource() {
		return source;
	}

	public void setResource(NetworkResource source) {
		this.source = source;
	}
}
