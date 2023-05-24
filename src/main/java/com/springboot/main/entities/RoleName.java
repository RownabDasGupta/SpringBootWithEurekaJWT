package com.springboot.main.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Role_Details")
public class RoleName {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleId;
	private String roleName;
	
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "RoleName [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

}
