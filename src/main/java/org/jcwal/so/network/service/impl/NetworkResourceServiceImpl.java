package org.jcwal.so.network.service.impl;

import java.util.List;

import org.jcwal.so.network.domain.NetworkResource;
import org.jcwal.so.network.domain.SegmentResource;
import org.jcwal.so.network.exception.NetworkException;
import org.jcwal.so.network.repository.NetworkResourceRepository;
import org.jcwal.so.network.repository.SegmentResourceRepository;
import org.jcwal.so.network.service.NetworkResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkResourceServiceImpl implements NetworkResourceService {

	@Autowired
	private NetworkResourceRepository networkResourceRepository;

	@Autowired
	private SegmentResourceRepository segmentResourceRepository;

	@Override
	public List<NetworkResource> createResourceBySegment(Long segmentId, String type) {
		SegmentResource segmentResource = segmentResourceRepository.findOne(segmentId);

		if ("A".equals(segmentResource.getType())) {
			String segment = segmentResource.getTsegment();
			segment = segment.substring(0, segment.lastIndexOf('.'));
			List<NetworkResource> existedResources = networkResourceRepository.findByIpLike(segment + ".%");
			if (!existedResources.isEmpty()) {
				throw new NetworkException("IP地址段已经有IP存在，不能批量创建！");
			}
			String prefix = segment + '.';
			// 内网IP段
			for (int i = 1; i < 0xFF; i++) {
				NetworkResource resource = new NetworkResource();
				resource.setIp(prefix + i);
				resource.setType(type);
				networkResourceRepository.save(resource);
				existedResources.add(resource);
			}
			return existedResources;
		}
		// 外网IP段
		String startIp = segmentResource.getTstartIp();
		String segment = startIp.substring(0, startIp.lastIndexOf('.'));
		String prefix = segment + '.';
		String endIp = segmentResource.getTendIp();
		if (!endIp.startsWith(prefix)) {
			throw new NetworkException("起止IP地址不在一个地址段，不能批量创建！");
		}
		List<NetworkResource> existedResources = networkResourceRepository.findByIpLike(segment + ".%");
		if (!existedResources.isEmpty()) {
			throw new NetworkException("IP地址段已经有IP存在，不能批量创建！");
		}
		boolean started = false;
		for (int i = 1; i < 0xFF; i++) {
			if ((prefix + i).equals(startIp)) {
				started = true;
			}
			if (started) {
				NetworkResource resource = new NetworkResource();
				resource.setIp(prefix + i);
				resource.setType(type);
				networkResourceRepository.save(resource);
				existedResources.add(resource);
			}
			if ((prefix + i).equals(endIp)) {
				break;
			}
		}
		return existedResources;
	}
}
