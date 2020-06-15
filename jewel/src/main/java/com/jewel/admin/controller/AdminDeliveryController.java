package com.jewel.admin.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jewel.admin.paging.AdminDeliveryListPaging;
import com.jewel.admin.service.AdminDeliveryService;
import com.jewel.common.CommandMap;

@Controller
public class AdminDeliveryController {
	@Resource(name="AdminDeliveryListPaging")
	AdminDeliveryListPaging AdminDeliveryListPaging;
	@Resource(name="AdminDeliveryService")
	private AdminDeliveryService AdminDeliveryService;
	
	@RequestMapping(value="/openDeliveryList")
	public ModelAndView openDeliveryList(CommandMap commandMap,HttpServletRequest request)throws Exception{
		ModelAndView mv=new ModelAndView("adminDeliveryList");
		
	 
	return mv;
		
	}
	
	
	@RequestMapping(value="/adminDeliveryList")
	public ModelAndView adminDeliveryList(CommandMap commandMap,HttpServletRequest request)throws Exception{
			ModelAndView mv=new ModelAndView("jsonView");  
			
			int show=12;//�������� ������ ��ǰ ����
	    	int block=5;//�������� ������ ����������
	    	int pg;
	    	if(commandMap.get("pg")==null) {
		    	  pg=1;
		      }
	    	else {
	    	pg=Integer.parseInt((String)commandMap.get("pg"));
	    	}
	    	
	    	int endNum = pg*show;
			int startNum = endNum-(show-1);
			
			commandMap.put("START_NUM", startNum);
			commandMap.put("END_NUM", endNum);
			
	    	@SuppressWarnings("unused")
			int totalList=AdminDeliveryService.normalTotalList(commandMap.getMap());
	    	AdminDeliveryListPaging.setPath(request.getContextPath());
	    	AdminDeliveryListPaging.setCurrentPage(pg);
	    	AdminDeliveryListPaging.setTotalList(totalList);
	    	AdminDeliveryListPaging.setPageBlock(block);
	    	AdminDeliveryListPaging.setPageSize(show);
	    	
	    	AdminDeliveryListPaging.makePagingHTML();
	    
	    	mv.addObject("AdminDeliveryListPaging",AdminDeliveryListPaging);
			
			List<Map<String,Object>>list=AdminDeliveryService.selectNormalList(commandMap.getMap());
		  mv.addObject("list",list);
		 
		return mv;
	}
	@RequestMapping(value="/adminRefundList")
	public ModelAndView adminRefundList(CommandMap commandMap,HttpServletRequest request)throws Exception{
			ModelAndView mv=new ModelAndView("jsonView");  
			
			int show=12;//�������� ������ ��ǰ ����
	    	int block=5;//�������� ������ ����������
	    	int pg;
	    	if(commandMap.get("pg")==null) {
		    	  pg=1;
		      }
	    	else {
	    	pg=Integer.parseInt((String)commandMap.get("pg"));
	    	}
	    	
	    	int endNum = pg*show;
			int startNum = endNum-(show-1);
			
			commandMap.put("START_NUM", startNum);
			commandMap.put("END_NUM", endNum);
			
	    	@SuppressWarnings("unused")
			int totalList=AdminDeliveryService.refundTotalList(commandMap.getMap());
	    	AdminDeliveryListPaging.setPath(request.getContextPath());
	    	AdminDeliveryListPaging.setCurrentPage(pg);
	    	AdminDeliveryListPaging.setTotalList(totalList);
	    	AdminDeliveryListPaging.setPageBlock(block);
	    	AdminDeliveryListPaging.setPageSize(show);
	    	
	    	AdminDeliveryListPaging.makePagingHTML();
	    
	    	mv.addObject("AdminRefundListPaging",AdminDeliveryListPaging);
			
			List<Map<String,Object>>list=AdminDeliveryService.selectRefundList(commandMap.getMap());
		  mv.addObject("list",list);
		 
		return mv;
	}
	@RequestMapping(value="/adminDeliveryDetail")
	public ModelAndView adminDeliveryDetail(CommandMap commandMap)throws Exception{
		ModelAndView mv=new ModelAndView("adminDeliveryDetail");
		Map<String,Object> map=AdminDeliveryService.selectDeliveryDetail(commandMap.getMap());
		mv.addObject("map",map);
	
		return mv;
	}
	@RequestMapping(value="/updateDelivery")
	public ModelAndView updateDelivery(CommandMap commandMap)throws Exception{
		ModelAndView mv=new ModelAndView("redirect:openDeliveryList");
		AdminDeliveryService.updateDelivery(commandMap.getMap());
		
		return mv;
	}
}
