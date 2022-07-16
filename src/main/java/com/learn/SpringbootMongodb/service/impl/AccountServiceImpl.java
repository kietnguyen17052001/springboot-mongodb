package com.learn.SpringbootMongodb.service.impl;

import com.learn.SpringbootMongodb.entity.Account;
import com.learn.SpringbootMongodb.entity.Role;
import com.learn.SpringbootMongodb.exception.BadRequestException;
import com.learn.SpringbootMongodb.exception.NotFoundException;
import com.learn.SpringbootMongodb.repository.AccountRepo;
import com.learn.SpringbootMongodb.repository.RoleRepo;
import com.learn.SpringbootMongodb.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService, UserDetailsService {
    private final AccountRepo repo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder encoder;

    @Override
    public Account register(Account account) {
        try {
            account.setPassword(encoder.encode(account.getPassword()));
            return repo.save(account);
        } catch (Exception e) {
            throw new BadRequestException("Username " + account.getUsername() + " is already exists");
        }
    }

    @Override
    public Role addRole(Role role) {
        try {
            return roleRepo.save(role);
        } catch (Exception e) {
            throw new BadRequestException("Role name " + role.getName() + " is already exists");
        }
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        Account account = repo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        if (account == null || role == null) {
            throw new NotFoundException("Not found username or role");
        } else {
            account.getRoles().add(role);
            repo.save(account);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = repo.findByUsername(username);
        if (account == null) {
            throw new NotFoundException("Not found username " + username);
        } else {
            Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
            account.getRoles().forEach(role -> {
                simpleGrantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            });
            return new User(account.getUsername(), account.getPassword(), simpleGrantedAuthorities);
        }
    }
}
