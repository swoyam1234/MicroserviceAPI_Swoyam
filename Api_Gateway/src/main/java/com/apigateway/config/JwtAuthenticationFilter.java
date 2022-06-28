package com.apigateway.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.apigateway.service.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		final String requestTokenHeader = request.getHeader("Authorization");
		String userName = null;
		String jwtToken = null;
		
		if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				userName = this.jwtUtil.extractUsername(jwtToken);
			}catch(ExpiredJwtException e)
			{
				e.printStackTrace();
				System.out.println("jwt token has expired");
			}catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("error");
			}
		}else {
			System.out.println("invalid token , not start with bearer string");
		}
		
		
		if(userName != null && SecurityContextHolder.getContext().getAuthentication()== null)
		{
			final UserDetails userDetails =this.userDetailsServiceImpl.loadUserByUsername(userName);
			
			if(this.jwtUtil.validateToken(jwtToken, userDetails))
			{
				 UsernamePasswordAuthenticationToken usernamePasswordAuthentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				 usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				 
				 
				 SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}else {
			System.out.println("Token is not valid");
		}
		
		filterChain.doFilter(request, response);
	}

}