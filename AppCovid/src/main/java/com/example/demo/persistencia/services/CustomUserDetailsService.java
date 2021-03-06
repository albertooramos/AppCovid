package com.example.demo.persistencia.services;

import java.util.Optional;

import com.example.demo.modelo.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserEntityService userEntityService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = userEntityService.findByUserName(username);
		if(user.isPresent()) {
			return user.get();
		}else {
			throw new UsernameNotFoundException(username+" not found");
		}		
	}
	
	public UserDetails loadUserById(String id) throws UsernameNotFoundException {
		Optional<UserEntity> user = userEntityService.findById(id);
		if(user.isPresent()) {
			return user.get();
		}else {
			throw new UsernameNotFoundException(id+" not found");
		}		
	}
}