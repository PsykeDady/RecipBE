package psykeco.recipbe.api;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import psykeco.recipbe.resposes.GenericResponse;

@RestController
public class TestApi {

	private AtomicInteger ai= new AtomicInteger();

	@GetMapping("ciao")
	public GenericResponse ciao() {
		return new GenericResponse().code(200).message("CIAO").property("nChiamata", ai.getAndIncrement());
	}

	@GetMapping("ciaoA")
	public GenericResponse ciaoA(@RequestParam(value = "nome", defaultValue = "nessuno") String nm) {
		return new GenericResponse().code(200).message("Ciao Francesco sono "+nm);
	}

	@PostMapping(path="salutami")
	public GenericResponse salutami (@RequestBody Map<String,Object> arg) {
		return new GenericResponse().code(200).message("Ciao "+arg.get("nome"));
	}
}
