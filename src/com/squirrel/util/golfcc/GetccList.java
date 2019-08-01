package com.squirrel.util.golfcc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.view.CcGolfScoreDTO;
import com.squirrel.service.GolfccService;

public class GetccList {

	protected List<CcGolfScoreDTO> CclistGetScore(String cc_name,List<String> loc_list,String orderVal,String descChk ,HttpSession session) 
	{
		List<CcGolfScoreDTO> list = null;
		HashMap<String, Object> searchVal = new HashMap<String, Object>();
		
		searchVal.put("cc_name", cc_name);
		searchVal.put("loc_list", loc_list);
		searchVal.put("cc_name", orderVal);
		searchVal.put("cc_name", descChk);
		
		list = new GolfccService().ccGolfScoreList(searchVal);
		return list;
		
	}
	
}
