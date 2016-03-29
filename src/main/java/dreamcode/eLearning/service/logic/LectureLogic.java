package dreamcode.eLearning.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dreamcode.eLearning.domain.Lecture;
import dreamcode.eLearning.service.LectureService;
import dreamcode.eLearning.store.LectureStore;

@Service
public class LectureLogic implements LectureService {

	@Autowired
	private LectureStore lectureStore;
	
	@Override
	public Lecture findLecture(Integer id) {
		Lecture lecture = lectureStore.retrieve(id);
		return lecture;
	}

	@Override
	public List<Lecture> findAllLectures() {
		List<Lecture> allLectures = lectureStore.retrieveAll();
		return allLectures;
	}

	@Override
	public List<Lecture> findAllByCategory(String category) {
		List<Lecture> lecturesByCategory = lectureStore.retrieveAllByCategory(category);
		return lecturesByCategory;
	}

	@Override
	public Integer registerLecture(Lecture lecture) {
		Integer id = this.nextId();
		lecture.setId(id);
		lectureStore.create(lecture);
		return id;
	}

	@Override
	public void modifyLecture(Lecture lecture) {
		lectureStore.update(lecture);
	}

	@Override
	public void removeLecture(Integer id) {
		lectureStore.delete(id);
	}

	private Integer nextId(){
		Integer nextId=0;
		Integer maxId = lectureStore.maxId();
		if(maxId !=null){
			nextId = maxId;
		}
		return nextId+1;
	}
}
