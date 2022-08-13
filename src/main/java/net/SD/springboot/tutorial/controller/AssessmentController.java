package net.SD.springboot.tutorial.controller;

import javax.validation.Valid;

import net.SD.springboot.tutorial.entity.Assessment;
import net.SD.springboot.tutorial.repository.AssessService;
import net.SD.springboot.tutorial.repository.AssessmentRepo;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/assessment/")
public class AssessmentController {

	private final AssessmentRepo assessRepository;
	@Autowired
	AssessService assessservice;


	@Autowired
	public AssessmentController(AssessmentRepo assessRepository) {
		this.assessRepository = assessRepository;
	}

	// inject via application.properties
	@Value("${welcome.message}")
	private String message;
	private String target;

	private List<String> tasks = Arrays.asList("MK76Y", "NV140", "NV141", "NV142", "NV143", "RLD8", "RLD9","RLD14","RLD15");
	//private List<Assessment> assessments=assessservice.findAll();
	@RequestMapping(value = "/postdata", method = RequestMethod.POST)
	@ResponseBody
	public String sendPostMessage(@RequestParam("message") String message,Model model) {
		if(message=="NV143"){
			target="45";
		}
		model.addAttribute("target", target);
		model.addAttribute("tasks", tasks);
		model.addAttribute("message", message);
		return "welcome";
	}
	@GetMapping("/welcome")
	public String returnWelcome(Model model) {

		model.addAttribute("message", message);
		model.addAttribute("tasks", tasks);

		return "icecreamhome"; //view
	}
	@GetMapping("signup")
	public String showSignUpForm(Assessment assess) {
		return "add-user";
	}

	@GetMapping("list")
	public String showUpdateForm(Model model) {
		model.addAttribute("assessments", assessRepository.findAll());
		return "index";
	}

	@PostMapping("add")
	public String addStation(@Valid Assessment assess, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-station";
		}

		assessRepository.save(assess);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Assessment assess = assessRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid station Id:" + id));
		model.addAttribute("student", assess);
		return "update-student";
	}

	@PostMapping("update/{id}")
	public String updateStation(@PathVariable("id") int id, @Valid Assessment assess, BindingResult result,
								Model model) {
		if (result.hasErrors()) {
			assess.setId(id);
			return "update-student";
		}

		assessRepository.save(assess);
		model.addAttribute("assessment", assessRepository.findAll());
		return "index";
	}

	@GetMapping("delete/{id}")
	public String deleteStation(@PathVariable("id") int id, Model model) {
		Assessment assess = assessRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		assessRepository.delete(assess);
		model.addAttribute("assessments", assessRepository.findAll());
		return "index";
	}
	public String getTargetVal(List<String> list){
		return "";

	}
}
