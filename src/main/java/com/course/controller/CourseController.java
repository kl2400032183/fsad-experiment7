package com.course.controller;

import com.course.entity.Course;
import com.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Object> createCourse(@RequestBody Course course) {
        if (course.getTitle() == null || course.getDuration() == null || course.getFee() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Missing required fields");
        }
        Course created = courseService.createCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCourseById(@PathVariable Long id) {
        Course course = courseService.getCourseById(id);
        if (course == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found with id: " + id);
        }
        return ResponseEntity.ok(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        if (course.getTitle() == null || course.getDuration() == null || course.getFee() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Missing required fields");
        }
        Course updated = courseService.updateCourse(id, course);
        if (updated == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found with id: " + id);
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCourse(@PathVariable Long id) {
        boolean deleted = courseService.deleteCourse(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Course not found with id: " + id);
        }
        return ResponseEntity.ok("Course deleted successfully");
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<Object> searchCoursesByTitle(@PathVariable String title) {
        List<Course> courses = courseService.searchByTitle(title);
        if (courses.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No courses found with title: " + title);
        }
        return ResponseEntity.ok(courses);
    }
}
