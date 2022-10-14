package com.exam.myapp.bbs;

import java.io.File;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.exam.myapp.attach.AttachDao;
import com.exam.myapp.attach.AttachVo;

@Transactional //이 클래스의 모든 메서드들을 각각 하나의 트랜잭션으로 설정
@Service
public class BbsServiceImpl implements BbsService {
	@Autowired
	private BbsDao bbsDao;
	@Autowired
	private AttachDao attachDao;
	@Value("${upload.path}") //스프링에 등록된 프로퍼티값을 주입
	private String uploadDir;

	@Override
	public List<BbsVo> selectList() {
		return bbsDao.selectList();
	}
	
//	@Transactional //이 메서드를 하나의 트랜잭션으로 정의
	@Override
	public int insert(BbsVo vo) {
		int num = bbsDao.insert(vo); //게시글 정보를 DB에 저장

		if(vo.getUpfileList() != null) { //첨부파일이 존재하면,
			for (MultipartFile mf : vo.getUpfileList()) { //첨부파일을 하나씩 꺼내서
				if(mf.getSize() <= 0) continue; //첨부파일 크기가 0보다 큰 경우에만 저장 
				//MultipartFile 객체 mf의 정보를 AttachVo 객체에 담은 다음
				AttachVo avo = new AttachVo();
				avo.setAttOrgName(mf.getOriginalFilename()); //첨부파일의 원래파일명
				String newName = UUID.randomUUID().toString(); //중복확률이 매우 낮은 임의의 문자열 생성
				try {
					mf.transferTo(new File(uploadDir, newName)); //mf의 파일 내용을 지정한 파일로 저장
					avo.setAttNewName(newName); //첨부파일의 서버저장파일명
					avo.setAttBbsNo(vo.getBbsNo()); //첨부파일 속한 게시글의 글번호
					//AttachVo 객체의 정보를 attach 테이블에 insert
					attachDao.insert(avo);
//					int a = 10/0;
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
					throw new RuntimeException("첨부파일 저장 오류", e);
				} 
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

	@Override
	public AttachVo selectAttach(AttachVo vo) {
		return attachDao.select(vo);
	}

	@Override
	public File getAttachFile(AttachVo vo) {
		return new File(uploadDir, vo.getAttNewName()); //서버에 저장된 첨부파일 객체
	}

}
