package kr.itedu.boardmvc.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.*;
import kr.itedu.boardmvc.common.*;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		BoardListService service = new BoardListService();
		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		ArrayList<BoardVO> data = service.getBoardList(btype);
		//request.setAttribute("boardList", result);
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardList");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
//		request.setAttribute("pageName", Var.TEMPLATE_1);
		
		
		
		return forward;
	}

}
