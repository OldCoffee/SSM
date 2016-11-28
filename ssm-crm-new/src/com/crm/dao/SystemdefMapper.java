package com.crm.dao;

import java.util.List;

import com.crm.model.Systemdef;
import com.crm.model.easyui.PageHelper;

public interface SystemdefMapper {
	
	public List<Systemdef> getAll(PageHelper page);

	public Systemdef getSystemdefById(Integer id);
	
	public void insertSystemdef(Systemdef systemdef);
	
	public void updateSystemdef(Systemdef systemdef);
	
	public void deleteSystemdefById(Integer id);
	
}
