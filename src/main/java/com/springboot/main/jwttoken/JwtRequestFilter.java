package com.springboot.main.jwttoken;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springboot.main.service.UserService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	private JwtTokenUtil jwtTokenUtil;
	private UserService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String requestTokenHeader = request.getHeader("Authorization");
		
		String userName = null;
		String Token = null;
		
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer")) {
			Token = requestTokenHeader.substring(7);
			
			try {
				userName = jwtTokenUtil.getUserNameFromToken(Token);
			}
			catch(IllegalArgumentException e) {
				System.out.println("unable to get");
			}
			catch(ExpiredJwtException e) {
				System.out.println(e);
			}
		}
		else {
			logger.warn("JWT Token does not begin with Bearer String");
		}
		
		
		
		if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.userService.loadUserByUsername(userName);
			
			if(jwtTokenUtil.validateToken(Token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request) );
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		
		
		filterChain.doFilter(request, response);
	}

}
