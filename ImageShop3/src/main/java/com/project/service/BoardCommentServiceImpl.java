package com.project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.domain.BoardComment;
import com.project.mapper.BoardCommentMapper;

@Service
public class BoardCommentServiceImpl implements BoardCommentService {

    @Autowired
    private BoardCommentMapper mapper;

    @Override
    public int register(BoardComment comment) throws Exception {
        return mapper.insert(comment);
    }

    @Override
    public List<BoardComment> listByBoardNo(Long boardNo) throws Exception {
        return mapper.listByBoardNo(boardNo);
    }

    @Override
    public int remove(Long commentNo) throws Exception {
        return mapper.delete(commentNo);
    }
}