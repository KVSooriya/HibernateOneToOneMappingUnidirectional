package com.vismee.advancedhibernatemapping;

import com.vismee.advancedhibernatemapping.dao.AppDAO;
import com.vismee.advancedhibernatemapping.entity.Instructor;
import com.vismee.advancedhibernatemapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedhibernatemappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedhibernatemappingApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return runner -> {
		       // createInstructor(appDAO);
		       // findInstructorById(appDAO);
			   // deleteInstructorById(appDAO);
		};
	}

	private void deleteInstructorById(AppDAO appDAO)
	{
		System.out.println("Deleting instructor By Id");
		int id = 1;
		appDAO.deleteInstructorById(id);
	}

	private void findInstructorById(AppDAO appDAO)
	{
		System.out.println("Fetching instructor and details by id");
		int instructorId = 1;
		Instructor instructor = appDAO.findInstructorById(instructorId);
		System.out.println("Instructor : " + instructor);
		/* Because of default behaviour of fetch for OneToOne mapping ie. eager fetch, it fetches
           instructorDetail along with instructor
	     */
		System.out.println("Instructor details : " +instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO)
	{
		Instructor instructor = new Instructor("Bhargav","Parithi","Parithi3101@gmail.com");
		InstructorDetail instructorDetail = new InstructorDetail("parithilearnings","experimenting");
		instructor.setInstructorDetail(instructorDetail);

		appDAO.saveInstructor(instructor);
	}

}
