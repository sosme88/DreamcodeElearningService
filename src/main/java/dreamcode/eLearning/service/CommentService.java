package dreamcode.eLearning.service;

import java.util.List;

import dreamcode.eLearning.domain.Comment;
import dreamcode.eLearning.domain.User;


/**
 * @author 09162 김범종
 * CommentService 입니다.
 */
public interface CommentService {

	
	/**
	 * 코멘트를 찾아주는 서비스 method
	 */
	Comment findComment(Integer id);
	
	/**
	 * 코멘트를 전부 찾아주는 서비스 method
	 * 관리자 페이지에서 호출합니다.
	 */
	List<Comment> findAll();
	
	/**
	 * 선택된 강의에 해당하는
	 * 코멘트들을 전부 찾아주는 서비스 method
	 */
	List<Comment> findAllByLecture(Integer lectureId);
	
	/**
	 * comment를 등록해주는 서비스 method
	 */
	Integer registerComment(Comment comment);
	
	/**
	 * 코멘트를 수정해주는 서비스 method
	 */
	void modifyComment(Comment comment);
	
	/**
	 * 코멘트를 지워주는 서비스 method
	 * 이 method는 코멘트를 작성한 작성자가 호출하는 method 입니다.
	 */
	void removeComment(Integer id);
	
	/**
	 * 강의를 지우면 해당 강의에 등록되어있는
	 * 코멘트들을 전부 찾아 지워주는 서비스 method
	 */
	void removeCommentsByLecture(Integer lectureId);
	
	/**
	 * 유저가 탈퇴하면
	 * 해당 유저가 작성한 코멘트들을 전부 찾아 지워주는 서비스 method
	 */
	void removeCommentsByUser(String userId);
	
	/**
	 * 유저정보가 수정되면
	 * 해당 유저가 작성한 코멘트들의 정보를
	 * 수정해주는 서비스 method
	 */
	void modifyByUser(User user);
}
