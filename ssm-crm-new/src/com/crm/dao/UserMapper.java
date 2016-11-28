/**
 * 
 */
package com.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.crm.model.SysMenu;
import com.crm.model.User;
import com.crm.model.easyui.PageHelper;

/**
 * @author zh
 * 2014-8-2
 */
public interface UserMapper {

	public User findUserByName(@Param("username") String username);

	public String getUsernameById(@Param("id") int id);

	public List<SysMenu> getMenuByUserId(@Param("userId") int userId);
	
	public List<User> getDatagrid();

	public Long getDatagridTotal(@Param("user")User user,@Param("csysid")Integer sysid);

	public List<User> datagridUser(@Param("page")PageHelper page,@Param("csysid")Integer sysid);

	public void addUser(User user);

	public void editUser(User user);
	
	public void deleteUser(int id);

}
