package com.exam.myapp.bbs;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exam.myapp.attach.AttachDao;
import com.exam.myapp.attach.AttachVo;

@Service
public class BbsServiceImpl implements BbsService {
	@Autowired
	private BbsDao bbsDao;
	@Autowired
	private AttachDao attachDao;

	@Override
	public List<BbsVo> selectList() {
		return bbsDao.selectList();
	}

	@Override
	public int insert(BbsVo vo) {
		int num = bbsDao.insert(vo);
		
		for (MultipartFile mf : vo.getUpfileList()) {
			System.out.println(mf.getOriginalFilename());
			System.out.println(mf.getSize());
			//MultipartFile 객체 mf의 정보를 AttachVo 객체에 담은 다음
			AttachVo avo = new AttachVo();
			avo.setAttOrgName(mf.getOriginalFilename());
			String newName = UUID.randomUUID().toString(); //중복확률이 매우 낮은 임의의 문자열 생성
			try {
				mf.transferTo(new File("D:/web/upload/" + newName)); //mf의 파일 내용을 지정한 파일로 저장
				avo.setAttNewName(newName);
				avo.setAttBbsNo(vo.getBbsNo());
				//AttachVo 객체의 정보를 attach 테이블에 insert
				attachDao.insert(avo);
				
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			} 
			
		}
		return num;
	}

	@Override
	public BbsVo select(BbsVo vo) {
		return bbsDao.select(vo);
	}

	@Override
	public int update(BbsVo vo) {
		return bbsDao.update(vo);
	}

	@Override
	public int delete(BbsVo vo) {
		return bbsDao.delete(vo);
	}

}
