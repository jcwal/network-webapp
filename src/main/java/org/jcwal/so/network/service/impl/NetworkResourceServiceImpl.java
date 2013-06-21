package org.jcwal.so.network.service.impl;

import java.util.List;

import org.jcwal.so.network.domain.NetworkResource;
import org.jcwal.so.network.exception.NetworkException;
import org.jcwal.so.network.repository.NetworkResourceRepository;
import org.jcwal.so.network.service.NetworkResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkResourceServiceImpl implements NetworkResourceService {

	@Autowired
	private NetworkResourceRepository networkResourceRepository;

	@Override
	public List<NetworkResource> createResourceBySegment(String segment, String type) {
		List<NetworkResource> existedResources = networkResourceRepository.findByIpLike(segment + ".%");
		if (!existedResources.isEmpty()) {
			throw new NetworkException("IP地址段已经有IP存在，不能批量创建！");
		}

		String prefix = segment + '.';
		for (int i = 1; i < 0xFF; i++) {
			NetworkResource resource = new NetworkResource();
			resource.setIp(prefix + i);
			resource.setType(type);
			networkResourceRepository.save(resource);
			existedResources.add(resource);
		}
		return existedResources;
	}
}
