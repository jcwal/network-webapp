/**
 * HospitalDoctorLoginRepository.java 2011-6-10
 */
package org.jcwal.so.network.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.jcwal.so.network.domain.Doctor;
import org.jcwal.so.network.repository.DoctorRepository;
import org.macula.base.security.principal.UserPrincipal;
import org.macula.base.security.principal.impl.UserPrincipalImpl;
import org.macula.base.security.service.CustomUserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private DoctorRepository doctorRepository;

	@Override
	public UserPrincipal loadUserByUsername(String username) {
		Doctor user = doctorRepository.findByUsername(username);
		if (user != null) {
			Map<String, Object> attrs = new HashMap<String, Object>();
			attrs.put(UserPrincipal.NICKNAME_ATTR, user.getNickname());
			UserPrincipalImpl principal = new UserPrincipalImpl(user.getUsername());
			principal.setPassword(user.getPassword());
			principal.setAttributes(attrs);
			return principal;
		}
		throw new UsernameNotFoundException("AbstractUserDetailsAuthenticationProvider.badCredentials");
	}

	@Override
	public void postValidateUserPrincipal(UserPrincipal principal) {
		// nothing
	}

}
