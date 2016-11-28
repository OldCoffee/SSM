package ssm;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.expr.NewArray;

import org.springframework.beans.BeanUtils;

import com.crm.model.SysMenu;
import com.crm.model.easyui.Tree;
import com.crm.util.common.JsonTools;

public class TestJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SysMenu s1=new SysMenu();
    	s1.setIconCls("图片-1");
    	s1.setId(1);
    	s1.setParentid(0);
    	s1.setName("文本1");
    	s1.setUrl("url-1");
    	
    	SysMenu s2=new SysMenu();
    	s2.setIconCls("图片-2");
    	s2.setId(2);
    	s2.setParentid(0);
    	s2.setName("文本2");
    	s2.setUrl("url-2");
    	
    	SysMenu s3=new SysMenu();
    	s3.setIconCls("图片-3");
    	s3.setId(3);
    	s3.setParentid(1);
    	s3.setName("文本3");
    	s3.setUrl("url-3");
    	
    	SysMenu s4=new SysMenu();
    	s4.setIconCls("图片-4");
    	s4.setId(4);
    	s4.setParentid(2);
    	s4.setName("文本4");
    	s4.setUrl("url-4");
    	
    	SysMenu s5=new SysMenu();
    	s5.setIconCls("图片-5");
    	s5.setId(5);
    	s5.setParentid(2);
    	s5.setName("文本5");
    	s5.setUrl("url-5");
    	
    	SysMenu s6=new SysMenu();
    	s6.setIconCls("图片-6");
    	s6.setId(6);
    	s6.setParentid(2);
    	s6.setName("文本6");
    	
    	List<SysMenu> menuList = new ArrayList<>();
    	
    	menuList.add(s1);
    	menuList.add(s2);
    	menuList.add(s3);
    	menuList.add(s4);
    	menuList.add(s5);
    	menuList.add(s6);
    	
    	List<Map<String, Object>> treeMenu = new ArrayList<Map<String, Object>>();
    	List<Map<String, Object>> treeNode = new ArrayList<Map<String, Object>>();
    	
        for (SysMenu menu : menuList) {
        	
        	Map<String, Object> attrMenu = new HashMap<String, Object>();
        	Map<String, Object> attrNode = new HashMap<String, Object>();
        	if (menu.getParentid()==0) {
        		attrMenu.put("menuid", menu.getId());
        		attrMenu.put("icon", menu.getIconCls());
        		attrMenu.put("menuname", menu.getName());
        		treeMenu.add(attrMenu);
			}else {
				attrNode.put("menuid", menu.getId());
				attrNode.put("icon", menu.getIconCls());
				attrNode.put("menuname", menu.getName());
				attrNode.put("url", menu.getUrl());
				treeNode.add(attrNode);
			}
        }

		String jsonMenu = JsonTools.createJsonString(treeMenu);
		String jsonNode = JsonTools.createJsonString(treeNode);
		System.out.println(jsonMenu);
		System.out.println(jsonNode);
	}
	
	
	/*1.List list = new ArrayList();  
	2. 
	3. * list 从后台请求的数据结果，此处添加获取数据过程 
	4.   
	5.Map map = new HashMap(); //  
	6.map.put(paramName, paramValue);  
	7.map.put(value, list);  
	8. 使用Struts 用Gson来进行json封装   
	9.HttpServletReponse res= ServletActionContext.getResponse();  
	10.PrintWriter out = res.getWriter();  
	11.out.write(new Gson().toJson(map).toString());  
	12.out.flush();  */


}
