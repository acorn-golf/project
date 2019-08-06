package com.squirrel.util.golfcc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.squirrel.dto.PageDTO;
import com.squirrel.dto.view.CcGolfScoreDTO;
import com.squirrel.service.GolfccService;
import com.squirrel.util.session.SessionEeum;

public class GetccList {

	public List<CcGolfScoreDTO> CclistGetScore(String cc_name, List<String> loc_list, String orderVal, String descChk,
			HttpSession session) {
		List<CcGolfScoreDTO> list = null;
		HashMap<String, Object> searchVal = new HashMap<String, Object>();

		searchVal.put("cc_name", cc_name);
		searchVal.put("loc_list", loc_list);
		searchVal.put("ord verVal", orderVal);
		searchVal.put("descChk", descChk);

		list = new GolfccService().ccGolfScoreList(searchVal);
		return list;

	}

	/**
	 * 
	 * @param cc_name  검색할 골프장 명 , 없을 경우 null 입력
	 * @param loc_list 검색할 지역 리스트, string 리스트 입력
	 * @param orderVal 정렬 기준 컬럼 명, 잘못된 값을 체크하는 기능이 없으니 유의
	 * @param descChk  정렬 체크, null 일경우 오름차순, 아닐경우 내림차순
	 * @param session  세션값
	 * @param curPage  보여줄 페이지 번호 -1은 널 대용
	 * @param perPage  최대 표현 데이터 수 -1은 널 대용
	 * 
	 * @return
	 */
	public PageDTO<CcGolfScoreDTO> CclistGetScore(String cc_name, List<String> loc_list, String orderVal,
			String descChk, HttpSession session, int curPage, int perPage) {
		// 페이징 기능 추가. cur페이지는 외부에서 입력받아 처리

		PageDTO<CcGolfScoreDTO> pageDto = new PageDTO<CcGolfScoreDTO>();
		HashMap<String, Object> searchVal = setSearchVal(cc_name, loc_list, orderVal, descChk);
		

		if ((boolean) searchVal.get("nullChk") == (curPage < 0||perPage<0)) {
			
			//기존값 유지하되 초기 실행 시, 검색값과 페이지 값 설정.
			if(session.getAttribute(SessionEeum.CC_LIST_SCORE_SearchVal.name())==null)
				session.setAttribute(SessionEeum.CC_LIST_SCORE_SearchVal.name(), searchVal);
			if(session.getAttribute(SessionEeum.CC_LIST_SCORE_Page.name())==null) {
				pageDto.setPerPage(20);
				pageDto.setCurPage(0);
				session.setAttribute(SessionEeum.CC_LIST_SCORE_Page.name(),pageDto);
			}
			
		} else { 
			if ((boolean) searchVal.get("nullChk")) { // 검색값이 없는 경우, 번호만 바뀐다. 검색값은 기ㅇ존 값 사용. 초기 실행시는 해당 값에 접근이 불가능하다.
				pageDto.setCurPage(curPage);
				pageDto.setPerPage(perPage);
				session.setAttribute(SessionEeum.CC_LIST_SCORE_Page.name(),pageDto);
			}
			else //검색값이 있는 경우, 검색값 새션 저장. cur이 null 인경우.
			{
				session.setAttribute(SessionEeum.CC_LIST_SCORE_SearchVal.name(), searchVal);
				pageDto.setCurPage(0);
				pageDto.setPerPage(perPage);
				session.setAttribute(SessionEeum.CC_LIST_SCORE_Page.name(),pageDto);
			}
		}

		// 세션에서 검색값 가져오기 ,page
		searchVal = (HashMap<String, Object>)session.getAttribute(SessionEeum.CC_LIST_SCORE_SearchVal.name());
		pageDto = (PageDTO<CcGolfScoreDTO>)session.getAttribute(SessionEeum.CC_LIST_SCORE_Page.name());
		
		return new GolfccService().ccGolfScoreList(searchVal, pageDto);

	}

	private HashMap<String, Object> setSearchVal(String cc_name, List<String> loc_list, String orderVal,
			String descChk) {
		// 검색값 유지 시 사용. 재검색의 경우 상단에서 세션을 초기화 시켜줘야한다.
		HashMap<String, Object> searchVal = new HashMap<String, Object>();
		searchVal.put("cc_name", cc_name);
		searchVal.put("loc_list", loc_list);
		searchVal.put("orderVal", orderVal);
		searchVal.put("descChk", descChk);
		searchVal.put("nullChk", (orderVal == null && loc_list == null && cc_name == null));

		return searchVal;
	}

}
