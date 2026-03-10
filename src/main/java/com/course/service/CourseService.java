package com.course.service;

import com.course.entity.Course;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CourseService {
    private Map<Long, Course> courses = new HashMap<>();
    private Long idCounter = 1L;

    public Course createCourse(Course course) {
        course.setCourseId(idCounter++);
        courses.put(course.getCourseId(), course);
        return course;
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }

    public Course getCourseById(Long id) {
        return courses.get(id);
    }

    public Course updateCourse(Long id, Course course) {
        if (!courses.containsKey(id)) {
            return null;
        }
        course.setCourseId(id);
        courses.put(id, course);
        return course;
    }

    public boolean deleteCourse(Long id) {
        return courses.remove(id) != null;
    }

    public List<Course> searchByTitle(String title) {
        return courses.values().stream()
                .filter(c -> c.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }
}
