package demo.auth.example.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import demo.auth.example.config.security.AuthenticationToken;
import demo.auth.example.model.User;
import demo.auth.example.model.dto.AuthDTO;
import demo.auth.example.model.dto.ErrorResponse;
import demo.auth.example.model.dto.LoginResponse;
import demo.auth.example.store.TokenStore;
import demo.auth.example.store.UserStore;

import java.util.UUID;

/**
 * This controller contains the endpoints for handling user tokens.
 */
@RestController
public class LoginController {
	@Autowired
	UserStore userStore;

	@Autowired
	TokenStore tokenStore;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object login(@RequestBody AuthDTO auth) {
		User user = userStore.get(auth.getUsername());
		if (user != null && user.getPassword().equals(auth.getPassword())) {
			final String token = UUID.randomUUID().toString();
			tokenStore.put(token, auth.getUsername());

			return new LoginResponse(token);
		}

		return new ResponseEntity(new ErrorResponse("Username or password are incorrect!"), HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(path = "/me/logout", method = RequestMethod.POST)
	public void logout(AuthenticationToken authToken) {
		tokenStore.remove(authToken.getToken());
	}
}
