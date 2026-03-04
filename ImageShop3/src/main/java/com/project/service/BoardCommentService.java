package com.project.service;

import java.util.List;

import com.project.domain.Board;
import com.project.domain.BoardComment;

public interface BoardCommentService {
    public int register(BoardComment comment) throws Exception;
    public List<BoardComment> listByBoardNo(Long boardNo) throws Exception;
    public int remove(Long commentNo) throws Exception;
}
