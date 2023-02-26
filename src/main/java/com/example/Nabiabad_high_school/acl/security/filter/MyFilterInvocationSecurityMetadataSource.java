package com.example.Nabiabad_high_school.acl.security.filter;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequest().getRequestURI();

        System.out.println("===>Requesting URL IS " + url);

        // TODO ignore url, please put it here for filtering and release
        if (url.contains("/generateToken")
                || url.contains("/currentUser")
        ) {
            return null;
        }

        ArrayList<String> attributes = new ArrayList<>();
        attributes.add(url);
        System.out.println("Send URL to auth check: " + url);
        return SecurityConfig.createList(String.valueOf(attributes));
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }

}
