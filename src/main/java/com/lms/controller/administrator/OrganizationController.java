package com.lms.controller.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.Faculty;
import com.lms.service.FacultyService;

@CrossOrigin
@RestController
@RequestMapping("/api/admin/organization")
public class OrganizationController {

	@Autowired
	FacultyService facultyService;

	@PostMapping("/faculty/{id}")
	public Faculty update(@PathVariable("id") int id, @RequestBody Faculty faculty) {
		Faculty st = facultyService.findById(id);
//		if(st.isPresent()) {
		return facultyService.save(faculty);
//		}

//		return null;
	}
}
