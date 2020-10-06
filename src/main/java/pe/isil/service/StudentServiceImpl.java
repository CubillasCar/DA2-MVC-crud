package pe.isil.service;

import org.springframework.stereotype.Service;
import pe.isil.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentServiceImpl implements IStudentService {

    AtomicInteger id = new AtomicInteger(1);

    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(id.getAndIncrement(), "Carlos", "Cubillas", "Olano", 28))
            //  new Student(id.getAndIncrement(), "Luis","Cubillas","olano", 30))
    );

    @Override
    public List<Student> getAll() {

        return students;
    }

    @Override
    public void create(Student student) {
        student.setId(id.getAndIncrement());
        students.add(student);

    }

    @Override
    public Student findById(Integer id) {
        Student student = students.stream().
                filter(s -> s.getId() ==(id)).
                findFirst().
                orElseGet(null);
        return student;
    }

    @Override
    public void update(Student student) {
        Student currentStudent = findById(student.getId());
        if (currentStudent != null) {
            int index= students.indexOf(currentStudent);
            students.set(index,student);
        }

    }

    @Override
    public void delete(Student student) {
        students.remove(student);

    }


}
