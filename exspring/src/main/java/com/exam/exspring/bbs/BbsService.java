package com.exam.exspring.bbs;

import java.util.List;

public interface BbsService {

	List<BbsVo> selectBbsList(SearchInfo info);

	int insertBbs(BbsVo vo);

	int delBbs(int no);

	BbsVo selectBbs(int no);

	int updateBbs(BbsVo vo);

}