package com.anbu.demo.cont;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anbu.demo.model.Student;
import com.anbu.demo.service.FirebaseInitializer;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@RestController
public class DemoController {
	@Autowired
	FirebaseInitializer db;
	
	@GetMapping("/getAllEmployees")
	public List<Student> getAllEmployees() throws InterruptedException, ExecutionException {
		List<Student> stList = new ArrayList<Student>();
		CollectionReference students= db.getFirebase().collection("Students");
		ApiFuture<QuerySnapshot> querySnapshot= students.get();
		for(DocumentSnapshot doc:querySnapshot.get().getDocuments()) {
			Student st = doc.toObject(Student.class);
			stList.add(st);
		}

		return stList;
	}

	@PostMapping("/saveEmployee")
	public int saveEmployee(@RequestBody Student student) {
		CollectionReference employeeCR= db.getFirebase().collection("Students");
		employeeCR.document(String.valueOf(student.getId())).set(student);
		return student.getId();
	}
}
