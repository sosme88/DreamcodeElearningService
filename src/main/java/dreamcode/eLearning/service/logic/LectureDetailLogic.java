package dreamcode.eLearning.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dreamcode.eLearning.domain.LectureDetail;
import dreamcode.eLearning.service.LectureDetailService;
import dreamcode.eLearning.store.LectureDetailStore;

@Service
public class LectureDetailLogic implements LectureDetailService {

	@Autowired
	private LectureDetailStore lectureDetailStore;
	
	@Override
	public LectureDetail findLectureDetail(Integer id) {
		LectureDetail lectureDetail = lectureDetailStore.retrieve(id);
		return lectureDetail;
	}

	@Override
	public List<LectureDetail> findAllByLecture(Integer lectureId) {
		List<LectureDetail> lectureDetailsByLecture = lectureDetailStore.retrieveAllByLecture(lectureId);
		return lectureDetailsByLecture;
	}

	@Override
	public Integer registerLectureDetail(LectureDetail lectureDetail) {
		Integer id = this.nextId();
		lectureDetail.setId(id);
		lectureDetailStore.create(lectureDetail);
		return id;
	}

	@Override
	public void modifyLectureDetail(LectureDetail lectureDetail) {
		lectureDetailStore.update(lectureDetail);
	}

	@Override
	public void removeLectureDetail(Integer id) {
		lectureDetailStore.delete(id);
	}
	
	@Override
	public void removeLectureDetailByLecture(Integer lectureId){
		lectureDetailStore.deleteByLecture(lectureId);
	}
	
	private Integer nextId(){
		Integer nextId=0;
		Integer maxId = lectureDetailStore.maxId();
		if(maxId !=null){
			nextId = maxId;
		}
		return nextId+1;
	}

}
