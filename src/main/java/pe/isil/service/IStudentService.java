package pe.isil.service;

import pe.isil.model.Student;

import java.util.List;

public interface IStudentService {


    public void create(Student student);
    public void update(Student student);
    public void delete(Student student);

    public Student findById(Integer id);
    public List<Student> getAll();
}
