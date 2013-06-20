package org.jcwal.so.network.service;

import java.util.List;

import org.jcwal.so.network.domain.NetworkResource;
import org.springframework.transaction.annotation.Transactional;

public interface NetworkResourceService {

	@Transactional
	List<NetworkResource> createResourceBySegment(String segment, String type);
}
