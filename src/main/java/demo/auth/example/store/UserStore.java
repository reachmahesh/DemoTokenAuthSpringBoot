package demo.auth.example.store;

import org.springframework.stereotype.Component;

import demo.auth.example.model.User;
import demo.auth.example.model.UserRole;

/**
 * This class represents a in-memory user store. For productive usage
 * this store should be a database.
 */
@Component
public class UserStore extends AbstractStore<String, User> {

	public UserStore() {
	}

	@Override
	protected void initilizeStore() {
		store.put("admin", new User("admin", "admin", UserRole.ADMIN, UserRole.USER));
		store.put("user", new User("user", "user", UserRole.USER));
	}

	@Override
	public User get(String username) {
		return super.get(username);
	}

	@Override
	public boolean contains(String username) {
		return super.contains(username);
	}
}
