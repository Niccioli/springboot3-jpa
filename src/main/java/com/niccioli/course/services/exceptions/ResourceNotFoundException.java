package com.niccioli.course.services.exceptions;

import com.niccioli.course.entities.User;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
       super("Resouce not found. Id " + id);
    }

}
