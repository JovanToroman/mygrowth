package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Studentsubjects;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-27T20:34:23")
@StaticMetamodel(Subject.class)
public class Subject_ { 

    public static volatile CollectionAttribute<Subject, Studentsubjects> studentsubjectsCollection;
    public static volatile SingularAttribute<Subject, String> imageUrl;
    public static volatile SingularAttribute<Subject, String> subjectName;

}