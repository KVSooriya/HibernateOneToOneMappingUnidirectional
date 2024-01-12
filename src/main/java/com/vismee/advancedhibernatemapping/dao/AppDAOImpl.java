package com.vismee.advancedhibernatemapping.dao;

import com.vismee.advancedhibernatemapping.entity.Instructor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImpl implements AppDAO
{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {
        // It also persists the related entity InstructorDetail because of cascadingtype as ALL
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        // It also removes the related entity InstructorDetail because of cascadingtype as ALL
        entityManager.remove(instructor);
    }
}
