package com.mgusani.springsecuritydb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mgusani.springsecuritydb.model.MyUserDetails;
import com.mgusani.springsecuritydb.model.User;
import com.mgusani.springsecuritydb.repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Optional<User> user = userRepository.findByFirstName(username);
		
		user
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		return user.map(MyUserDetails::new).get();
	}
	
	

}
