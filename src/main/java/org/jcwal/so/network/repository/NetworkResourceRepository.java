package org.jcwal.so.network.repository;

import java.util.List;

import org.jcwal.so.network.domain.NetworkResource;
import org.macula.core.repository.MaculaJpaRepository;

public interface NetworkResourceRepository extends MaculaJpaRepository<NetworkResource, Long> {

	List<NetworkResource> findByIpLike(String segment);
}
