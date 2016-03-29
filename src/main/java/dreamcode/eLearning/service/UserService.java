package dreamcode.eLearning.service;

import java.util.List;

import dreamcode.eLearning.domain.User;

/**
 * @author 09162 김범종
 * UserService 입니다.
 */
public interface UserService {

	/**
	 * 유저를 찾아주는 서비스 method
	 */
	User findUser(String loginId);
	
	/**
	 * 모든 유저를 찾아주는 서비스 method
	 * 매니저 컨트롤러에서 호출합니다.
	 */
	List<User> findAllUser();
	
	/**
	 * 유저를 등록해주는 서비스 method
	 */
	Integer registerUser(User user);
	
	/**
	 * 유저를 수정해주는 서비스 method
	 */
	void modifyUser(User user);
	
	/**
	 * 유저를 지워주는 서비스 method
	 */
	void removeUser(Integer id);
	
	/**
	 * 유저의 프로필 이미지를 수정해주는
	 * 서비스 method
	 */
	void modifyUserProfileImg(User user);
}
