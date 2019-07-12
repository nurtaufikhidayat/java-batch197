package com.xsis.batch197.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.xsis.batch197.model.XAddressBookModel;

public class UserPrincipal implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private XAddressBookModel user;

	public UserPrincipal(XAddressBookModel user) {
		this.user = user;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		// mendapatkan list role
		this.user.getListRole().forEach(r ->{
			GrantedAuthority auth = new SimpleGrantedAuthority(r.getCode());
			authorities.add(auth);
		});
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.user.getAbpwd();
	}

	@Override
	public String getUsername() {
		return this.user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.user.getIsLocked() == 0;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.getIsDelete() == 0;
	}

}
