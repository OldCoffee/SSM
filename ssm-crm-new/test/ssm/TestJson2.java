package ssm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.event.TreeExpansionEvent;

import org.springframework.beans.BeanUtils;

import com.crm.model.SysMenu;
import com.crm.model.easyui.Tree;

public class TestJson2 {

public static void main(String[] args) {
		
		SysMenu s1=new SysMenu();
    	s1.setIconCls("父-图片-1");
    	s1.setId(1);
    	s1.setParentid(0);
    	s1.setName("父-文本1");
    	s1.setUrl("父-url-1");
    	
    	SysMenu s2=new SysMenu();
    	s2.setIconCls("图片-2");
    	s2.setId(2);
    	s2.setParentid(0);
    	s2.setName("父-文本2");
    	s2.setUrl("父-url-2");
    	
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
    	
    	List<Tree> treeList = new ArrayList<Tree>();

        for (SysMenu menu : menuList) {
			Tree node = new Tree();
			BeanUtils.copyProperties(menu, node);
			if(menu.getParentid()!=0){	//有父节点
				node.setPid(menu.getParentid());
			}
			Map<String, Object> attr = new HashMap<String, Object>();
			attr.put("url", menu.getUrl());
			node.setAttributes(attr);
			treeList.add(node);
        }
        
        for (Tree tree : treeList) {
			System.out.println("pid:"+tree.getPid()+" id:"+tree.getId()
					+" text:"+tree.getText()
					+" children:"+tree.getChildren());
		}
    }

}
