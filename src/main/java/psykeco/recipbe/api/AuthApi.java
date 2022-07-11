package psykeco.recipbe.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import psykeco.recipbe.model.UserModel;
import psykeco.recipbe.resposes.GenericResponse;

@RestController
@RequestMapping("auth")
@CrossOrigin(originPatterns = "*")
public class AuthApi {
	@PostMapping("signin")
	public GenericResponse signin(@RequestBody UserModel userModel){
		return new GenericResponse().code(200).message(userModel.getHashSession());
	}

	@PostMapping("signup")
	public GenericResponse signup(@RequestBody UserModel userModel){
		return new GenericResponse().code(200).message("");
	}
}
