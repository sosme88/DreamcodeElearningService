package dreamcode.eLearning.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dreamcode.eLearning.domain.User;
import dreamcode.eLearning.service.UserService;
import dreamcode.eLearning.store.UserStore;

@Service
public class UserLogic implements UserService {

	@Autowired
	private UserStore userStore;
	
	@Override
	public User findUser(String loginId) {
		User user = userStore.retrieve(loginId);
		return user;
	}

	@Override
	public List<User> findAllUser() {
		List<User> allUsers = userStore.retrieveAll();
		return allUsers;
	}

	@Override
	public Integer registerUser(User user) {
		Integer id = this.nextId();
		user.setId(id);
		user.setUserType("user");
		user.setProfileImg("http://www.dreamcode.co.kr/Content/Images/DaOFsylMGXaXLJNY/icon.png");
		user.setSelfIntroduction("안녕하세요 반갑습니다!");
		userStore.create(user);
		return id;
	}

	@Override
	public void modifyUser(User user) {
		userStore.update(user);
	}
	
	@Override
	public void modifyUserProfileImg(User user) {
		user.setProfileImg("http://10.250.66.209/userProfile/"+user.getProfileImg());
		userStore.update(user);
	}

	@Override
	public void removeUser(Integer id) {
		userStore.delete(id);
	}
	
	private Integer nextId(){
		Integer nextId=0;
		Integer maxId = userStore.maxId();
		if(maxId !=null){
			nextId = maxId;
		}
		return nextId+1;
	}
}
