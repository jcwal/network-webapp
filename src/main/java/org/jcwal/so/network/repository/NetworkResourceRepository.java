package org.jcwal.so.network.repository;

import java.util.List;

import org.jcwal.so.network.domain.NetworkResource;
import org.macula.core.repository.MaculaJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NetworkResourceRepository extends MaculaJpaRepository<NetworkResource, Long> {

	List<NetworkResource> findByIpLike(String segment);

	@Query("from NetworkResource t where t.id in :ids")
	List<NetworkResource> findIds(@Param("ids") List<Long> ids);

}
