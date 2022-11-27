package com.codepresso.cheerup.service;

import com.codepresso.cheerup.dao.FreeBoardMapper;
import com.codepresso.cheerup.vo.FreeBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FreeBoardService {
    private final FreeBoardMapper freeBoardMapper;

    //전체 조회
    public List<FreeBoard> getAllFreeBoardList() {
        return freeBoardMapper.getAllFreeBoardList();
    }

    //글 하나 조회
    public FreeBoard getFreeBoardDetail(int boardNo) { return freeBoardMapper.getFreeBoardDetail(boardNo); }
}
