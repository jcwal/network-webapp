package org.jcwal.so.network.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.macula.core.domain.AbstractAuditable;
import org.macula.core.utils.EnvironmentUtils;

@Entity
@DynamicInsert
@DynamicUpdate
public class NetworkResource extends AbstractAuditable<Long> {

	private static final long serialVersionUID = 1L;

	private String ip;
	private String type;

	private String position;
	private String usage;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	@OneToMany
	private List<RentResource> rents;

	public boolean isUsable() {
		Date now = EnvironmentUtils.getCurrentTime();
		if (rents != null) {
			for (RentResource rent : rents) {
				if ((rent.getBegin() == null || rent.getBegin().before(now))
						&& (rent.getEnd() == null || rent.getEnd().after(now))) {
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

}
