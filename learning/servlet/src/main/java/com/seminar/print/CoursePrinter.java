package com.seminar.print;

import com.seminar.util.Course;
import com.seminar.util.Student;

public abstract class CoursePrinter {

	public String print(Course course) {
		String result = header(course);

		for (Student student : course.students()) {
			result += render(student);
		}

		result += footer();

		return result;
	}

	public abstract String header(Course course);
	public abstract String render(Student student);
	public abstract String footer();
}
