package com.exam.exspring.bbs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbsServiceImpl implements BbsService {
	@Autowired
	private BbsDao bbsDao;

	@Override
	public List<BbsVo> selectBbsList(SearchInfo info) {		
		return bbsDao.selectBbsList(info);
	}

	@Override
	public int insertBbs(BbsVo vo) {
		return bbsDao.insertBbs(vo);
	}

	@Override
	public int delBbs(int no) {		
		return bbsDao.delBbs(no);
	}

	@Override
	public BbsVo selectBbs(int no) {
		return bbsDao.selectBbs(no);
	}

	@Override
	public int updateBbs(BbsVo vo) {
		return bbsDao.updateBbs(vo);
	}

	

}
