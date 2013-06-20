package org.jcwal.so.network.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.macula.core.domain.AbstractAuditable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicInsert
@DynamicUpdate
public class RentResource extends AbstractAuditable<Long> {

	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = false)
	private NetworkResource networkResource;

	@Column(nullable = false)
	private String applyman;
	@Column(nullable = false)
	private String chargeman;

	@Column(nullable = false)
	private Date beginDate;
	@Column(nullable = false)
	private Date endDate;

	@JsonIgnore
	public NetworkResource getNetworkResource() {
		return networkResource;
	}

	public void setNetworkResource(NetworkResource networkResource) {
		this.networkResource = networkResource;
	}

	public String getApplyman() {
		return applyman;
	}

	public void setApplyman(String applyman) {
		this.applyman = applyman;
	}

	public String getChargeman() {
		return chargeman;
	}

	public void setChargeman(String chargeman) {
		this.chargeman = chargeman;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	private String comments;

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	////////////////////////////JSON /////////////////////////
	public void setNetworkResourceId(Long id) {
		setNetworkResource(id == null ? null : new NetworkResource(id));
	}

	public Long getNetworkResourceId() {
		return getNetworkResource() == null ? null : getNetworkResource().getId();
	}
}
