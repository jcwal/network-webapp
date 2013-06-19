/**
 * HospitalDoctorLoginRepository.java 2011-6-10
 */
package org.jcwal.so.network.service.impl;

import java.util.UUID;

import org.macula.Configuration;
import org.macula.base.security.principal.UserPrincipal;
import org.macula.base.security.principal.impl.UserPrincipalImpl;
import org.macula.base.security.service.CustomUserLoginRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * <p>
 * <b>HospitalDoctorLoginRepository</b> 是本地用户登录实现.
 * </p>
 * 
 * @since 2011-6-10
 * @author Wilson Luo
 * @version $Id: HospitalDoctorLoginRepository.java 3663 2012-10-31 08:51:06Z wilson $
 */
@Component
public class NetworkLoginRepository implements CustomUserLoginRepository {

	@Override
	public UserPrincipal loadUserByUsername(String username) {
		String sysusers = Configuration.getProperty("SYSUSERS");
		if (sysusers.contains(username)) {
			UserPrincipalImpl principal = new UserPrincipalImpl(username);
			principal.setPassword(UUID.randomUUID().toString());
			return principal;
		}
		throw new UsernameNotFoundException("AbstractUserDetailsAuthenticationProvider.badCredentials");
	}

	@Override
	public void postValidateUserPrincipal(UserPrincipal principal) {
		// nothing
	}

}
