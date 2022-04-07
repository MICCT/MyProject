package co.mass.mybatis.member.serviceImpl;

import java.util.List;



import org.apache.ibatis.session.SqlSession;

import co.mass.mybatis.comm.DataSource;
import co.mass.mybatis.member.service.MemberMapper;
import co.mass.mybatis.member.service.MemberService;
import co.mass.mybatis.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
   private SqlSession sqlSession = DataSource.getInstance().openSession(true); //자동연결을 하고 값을 담아서
   //자기자신은 못하기떄문에 하위요소인 sqlSession 을 이용해서 담아서 map 에 값을 담았다
   private MemberMapper map = sqlSession.getMapper(MemberMapper.class); //mapper(맵퍼) 를 연결
   
   @Override
   public List<MemberVO> memberSelectList() {
      // TODO Auto-generated method stub
   //   return sqlSession.selectList("memberSelectList"); //Maapper 없이 사용시 이렇게 쓸수있다.
      return map.memberSelectList(); //위에서 연결을했기에 Member-map.xml 를 찾아서 가져온다.
   
   }

   @Override
   public MemberVO memberSelect(MemberVO vo) {
      // TODO Auto-generated method stub
   //   return sqlSession.selectOne("memberSelect" , vo);
      return map.memberSelect(vo);
   }

   @Override
   public int memberInsert(MemberVO vo) {
      // TODO Auto-generated method stub
      return map.memberInsert(vo);
   }

   @Override
   public int memberUpdate(MemberVO vo) {
      // TODO Auto-generated method stub
      return map.memberUpdate(vo);
   }

   @Override
   public int memberDelete(MemberVO vo) {
      // TODO Auto-generated method stub
      return map.memberDelete(vo);
   }

}