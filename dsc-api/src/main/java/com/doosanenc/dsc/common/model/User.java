package com.doosanenc.dsc.common.model;

import lombok.Data;
import java.util.List;

@Data
public class User {
    
	private String userId;
    private String password;
    private String name;
    private String enabled;
    private List<Role> roles;
    
}
