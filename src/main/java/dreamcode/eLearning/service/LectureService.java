package dreamcode.eLearning.service;

import java.util.List;

import dreamcode.eLearning.domain.Lecture;

/**
 * @author 09162 김범종
 * LectureService 입니다.
 */
public interface LectureService {

	/**
	 * 강의를 찾아주는 서비스 method
	 */
	Lecture findLecture(Integer id);
	
	/**
	 * 강의를 전부 찾아주는 서비스 method
	 * 매니저 컨트롤러에서 호출합니다.
	 */
	List<Lecture> findAllLectures();
	
	/**
	 * category(앱인벤터, 파이썬)에 
	 * 따라 강의목록들을 전부 찾아주는 서비스 method
	 */
	List<Lecture> findAllByCategory(String category);
	
	/**
	 * 강의를 등록해주는 서비스 method
	 */
	Integer registerLecture(Lecture lecture);
	
	/**
	 * 강의를 수정해주는 서비스 method
	 */
	void modifyLecture(Lecture lecture);
	
	/**
	 * 강의를 지워주는 서비스 method
	 */
	void removeLecture(Integer id);
}
