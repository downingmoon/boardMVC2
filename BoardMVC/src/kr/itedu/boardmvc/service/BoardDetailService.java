package kr.itedu.boardmvc.service;

import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;

public class BoardDetailService {
	public BoardVO getBoardDetail(int bid, int btype) {
		BoardVO vo = BoardDAO.getBoardDetail(bid, btype);
		
		//vo = dao.getBoardDetail(bid);
		
		return vo;
	}
}
