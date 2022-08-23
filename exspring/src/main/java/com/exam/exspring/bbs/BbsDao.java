package com.exam.exspring.bbs;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsDao {

	List<BbsVo> selectBbsList(SearchInfo info);

	int insertBbs(BbsVo vo);

	int delBbs(int no);

	BbsVo selectBbs(int no);

	int updateBbs(BbsVo vo);

}