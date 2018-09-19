package kr.itedu.boardmvc.service;

import kr.itedu.boardmvc.*;
import kr.itedu.boardmvc.common.BoardDAO;

public class BoardInsertService {
	public BoardVO boardInsert(String btitle, String bcontent, int btype) {
		BoardVO ins = new BoardVO();
		BoardDAO dao = BoardDAO.getInstance();
		ins = dao.Insert(btitle, bcontent, btype);
		return ins;
		
	}
//	String title = request.getParameter("btitle");
//	String content = request.getParameter("bcontent");
//	Query.Insert(title, content);
}
