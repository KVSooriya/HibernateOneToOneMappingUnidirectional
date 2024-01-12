package com.vismee.advancedhibernatemapping.dao;

import com.vismee.advancedhibernatemapping.entity.Instructor;

public interface AppDAO
{
    void saveInstructor(Instructor instructor);
    Instructor findInstructorById(int id);
    void deleteInstructorById(int id);
}
