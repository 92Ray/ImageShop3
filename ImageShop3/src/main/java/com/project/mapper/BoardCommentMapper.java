package com.project.mapper;

import java.util.List;

import com.project.domain.Board;
import com.project.domain.BoardComment;

public interface BoardCommentMapper {
	
	public int insert(BoardComment comment) throws Exception;

    public List<BoardComment> listByBoardNo(Long boardNo) throws Exception;

    public int delete(Long commentNo) throws Exception;

}
