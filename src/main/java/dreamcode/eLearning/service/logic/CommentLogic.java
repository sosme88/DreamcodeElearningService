package dreamcode.eLearning.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dreamcode.eLearning.domain.Comment;
import dreamcode.eLearning.domain.User;
import dreamcode.eLearning.service.CommentService;
import dreamcode.eLearning.store.CommentStore;

@Service
public class CommentLogic implements CommentService {

	@Autowired
	private CommentStore commentStore;
	
	@Override
	public Comment findComment(Integer id) {
		Comment comment = commentStore.retrieve(id);
		return comment;
	}
	
	@Override
	public List<Comment> findAll(){
		List<Comment> comments = commentStore.retrieveAll();
		return comments;
	}

	@Override
	public List<Comment> findAllByLecture(Integer lectureId) {
		List<Comment> commentsByLecture = commentStore.retrieveAllByLecture(lectureId);
		return commentsByLecture;
	}

	@Override
	public Integer registerComment(Comment comment) {
		Integer id = this.nextId();
		comment.setId(id);
		commentStore.create(comment);
		return id;
	}

	@Override
	public void modifyComment(Comment comment) {
		commentStore.update(comment);
	}

	@Override
	public void removeComment(Integer id) {
		commentStore.delete(id);
	}
	@Override
	public void removeCommentsByLecture(Integer lectureId){
		commentStore.deleteByLecture(lectureId);
	}
	@Override
	public void removeCommentsByUser(String userId){
		commentStore.deleteByUser(userId);
	}
	@Override
	public void modifyByUser(User user){
		commentStore.updateByUser(user);
	}
	private Integer nextId(){
		Integer nextId=0;
		Integer maxId = commentStore.maxId();
		if(maxId !=null){
			nextId = maxId;
		}
		return nextId+1;
	}
	
}
