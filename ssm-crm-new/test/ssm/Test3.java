package ssm;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.crm.model.SysMenu;

public class Test3 {
	
	/**
     * 创建一颗树，以json字符串形式返回
     * @param list 原始数据列表
     * @return 树
     */
   private String createTreeJson(List<SysMenu> list) {
       JSONArray rootArray = new JSONArray();

       for (SysMenu menu : list) {
           if (menu.getParentid() == 0) {  // 0为父节点

               JSONObject rootObj = createBranch(list, menu);
               rootArray.add(rootObj);
           }
       }

       return rootArray.toString();
   }

   /**
    * 递归创建分支节点Json对象
    * @param list 创建树的原始数据
    * @param currentNode 当前节点
    * @return 当前节点与该节点的子节点json对象
    */
   private JSONObject createBranch(List<SysMenu> list, SysMenu currentNode) {
       /*
        * 将javabean对象解析成为JSON对象
        */
       JSONObject currentObj = JSONObject.fromObject(currentNode);
       JSONArray childArray = new JSONArray();

       /*
        * 循环遍历原始数据列表，判断列表中某对象的父id值是否等于当前节点的id值，
        * 如果相等，进入递归创建新节点的子节点，直至无子节点时，返回节点，并将该
        * 节点放入当前节点的子节点列表中
        */
       for (SysMenu newNode : list) {
           if ((newNode.getParentid() != 0) &&
                   (newNode.getParentid().compareTo(currentNode.getId()) == 0)) {
               JSONObject childObj = createBranch(list, newNode);
               childArray.add(childObj);
           }
       }

       /*
        * 判断当前子节点数组是否为空，不为空将子节点数组加入children字段中
        */
       if (!childArray.isEmpty()) {
           currentObj.put("children", childArray);
       }

       return currentObj;
   }
   
   
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SysMenu s1=new SysMenu();
    	s1.setIconCls("父-图片-1");
    	s1.setId(1);
    	s1.setParentid(0);
    	s1.setName("父1");
    	s1.setUrl("父-url-1");
    	
    	SysMenu s2=new SysMenu();
    	s2.setIconCls("图片-2");
    	s2.setId(2);
    	s2.setParentid(0);
    	s2.setName("父2");
    	s2.setUrl("父-url-2");
    	
    	SysMenu s3=new SysMenu();
    	s3.setIconCls("图片-3");
    	s3.setId(3);
    	s3.setParentid(1);
    	s3.setName("父1-节点3");
    	s3.setUrl("url-3");
    	
    	SysMenu s4=new SysMenu();
    	s4.setIconCls("图片-4");
    	s4.setId(4);
    	s4.setParentid(2);
    	s4.setName("父2-节点4");
    	s4.setUrl("url-4");
    	
    	SysMenu s5=new SysMenu();
    	s5.setIconCls("图片-5");
    	s5.setId(5);
    	s5.setParentid(2);
    	s5.setName("父2-节点5");
    	s5.setUrl("url-5");
    	
    	SysMenu s6=new SysMenu();
    	s6.setIconCls("图片-6");
    	s6.setId(6);
    	s6.setParentid(5);
    	s6.setName("父2-父5-节点6");
    	
    	SysMenu s7=new SysMenu();
    	s7.setIconCls("图片-7");
    	s7.setId(7);
    	s7.setParentid(3);
    	s7.setName("父1-父3-节点7");
    	
    	SysMenu s8=new SysMenu();
    	s8.setIconCls("图片-8");
    	s8.setId(8);
    	s8.setParentid(3);
    	s8.setName("父1-父3-节点8"); 
    	
    	SysMenu s9=new SysMenu();
    	s9.setIconCls("图片-9");
    	s9.setId(9);
    	s9.setParentid(8);
    	s9.setName("父1-父3-父8-节点9"); 
    	
    	List<SysMenu> menuList = new ArrayList<>();
    	menuList.add(s1);
    	menuList.add(s2);
    	menuList.add(s3);
    	menuList.add(s4);
    	menuList.add(s5);
    	menuList.add(s6);
    	menuList.add(s7);
    	menuList.add(s8);
    	menuList.add(s9);
    	
    	Test3 t =new Test3();
        String json = t.createTreeJson(menuList);
        System.out.println(json);
	}

}
