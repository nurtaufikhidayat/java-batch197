package com.xsis.batch197.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xsis.batch197.model.XAddressBookModel;
import com.xsis.batch197.repository.XAddressBookRepo;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
	@Autowired
	private XAddressBookRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		XAddressBookModel user = this.userRepo.findByAbuidAndEmail(username);
		UserPrincipal userPrincipal = new UserPrincipal(user);
		return userPrincipal;
	}

}
