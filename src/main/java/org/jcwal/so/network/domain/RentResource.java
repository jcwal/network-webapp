package org.jcwal.so.network.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.macula.core.domain.AbstractAuditable;

@Entity
@DynamicInsert
@DynamicUpdate
public class RentResource extends AbstractAuditable<Long> {

	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)
	private NetworkResource resource;

	@Column(nullable = false)
	private String apply;
	@Column(nullable = false)
	private String charge;

	@Column(nullable = false)
	private Date begin;
	private Date end;

	private String comments;

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
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

	public NetworkResource getResource() {
		return resource;
	}

	public void setResource(NetworkResource resource) {
		this.resource = resource;
	}
}
