package com.exam.myapp.bbs;

import java.util.List;

import com.exam.myapp.attach.AttachVo;

public interface BbsService {
	public List<BbsVo> selectList();

	public int insert(BbsVo vo);

	public BbsVo select(BbsVo vo);

	public int update(BbsVo vo);

	public int delete(BbsVo vo);

	public AttachVo selectAttach(AttachVo vo);
}
