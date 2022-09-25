package com.arnav.StudentInfo.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
//import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arnav.StudentInfo.domain.Roles;
import com.arnav.StudentInfo.domain.Users;
import com.arnav.StudentInfo.repository.UsersRepository;
import com.arnav.StudentInfo.web.dto.UserRegistrationDto;

@Service
public class UsersServiceImpl implements UsersService{
	
	private UsersRepository usersrepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UsersServiceImpl(UsersRepository usersrepo) {
		super();
		this.usersrepo = usersrepo;
	}

	@Override
	public List<Users> getAllUsers() {
		return usersrepo.findAll();
	}

	@Override
	public Users save(UserRegistrationDto registrationDto) {
		Users user = new Users(registrationDto.getFirst_name(), 
				registrationDto.getLast_name(), 
				registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()),
				new HashSet<>(Arrays.asList(new Roles("Editor"))));
		
		return usersrepo.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersrepo.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Roles> role){
		return role.stream().map(roles -> new SimpleGrantedAuthority(roles.getRole_name())).collect(Collectors.toSet());
	}
	
//	@Override
//	public void saveUser(Users user) {
//		this.usersrepo.save(user);
//	}
	

}
