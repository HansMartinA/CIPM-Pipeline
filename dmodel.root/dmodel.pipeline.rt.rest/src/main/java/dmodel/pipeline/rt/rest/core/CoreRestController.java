package dmodel.pipeline.rt.rest.core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class CoreRestController {

	@GetMapping("ping")
	public String ping() {
		return "true";
	}

}
