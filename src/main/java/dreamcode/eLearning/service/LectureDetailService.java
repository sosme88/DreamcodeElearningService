package dreamcode.eLearning.service;

import java.util.List;

import dreamcode.eLearning.domain.LectureDetail;

/**
 * @author 09162 김범종
 * LectureDetailService 입니다.
 */
public interface LectureDetailService {

	/**
	 * 강의 디테일을 찾아주는 서비스 method
	 */
	LectureDetail findLectureDetail(Integer id);
	
	/**
	 * 강의를 선택하면 해당 강의에 등록되어있는
	 * 강의 디테일들을 전부 찾아주는 서비스 method
	 */
	List<LectureDetail> findAllByLecture(Integer lectureId);
	
	/**
	 * 강의 디테일을 등록해주는 서비스 method
	 */
	Integer registerLectureDetail(LectureDetail lectureDetail);
	
	/**
	 * 강의 디테일을 수정해주는 서비스 method
	 */
	void modifyLectureDetail(LectureDetail lectureDetail);
	
	/**
	 * 강의 디테일을 지워주는 서비스 method
	 */
	void removeLectureDetail(Integer id);
	
	/**
	 * 강의를 지우면 해당 강의에 등록되어있는
	 * 강의 디테일들을 전부 찾아 지워는 서비스 method
	 */
	void removeLectureDetailByLecture(Integer lectureId);
}
