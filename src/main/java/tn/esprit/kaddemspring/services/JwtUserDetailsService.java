package tn.esprit.kaddemspring.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import tn.esprit.kaddemspring.model.TypeRole;
import tn.esprit.kaddemspring.repository.UserDao;
import tn.esprit.kaddemspring.model.DAOUser;
import tn.esprit.kaddemspring.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public DAOUser save(UserDTO user) {
		DAOUser user1 = userDao.findByUsername(user.getUsername());
		if (user1 == null){
			DAOUser newUser = new DAOUser();
			newUser.setUsername(user.getUsername());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			newUser.setRole(user.getRole());
			return userDao.save(newUser);
		}
else {
	return null;
		}
	}

	public TypeRole getRole(String username){
		DAOUser user = userDao.findByUsername(username);
		return user.getRole();
	}
}
