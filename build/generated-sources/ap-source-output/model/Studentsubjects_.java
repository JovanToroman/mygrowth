package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Migrant;
import model.StudentsubjectsPK;
import model.Subject;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-13T22:35:45")
@StaticMetamodel(Studentsubjects.class)
public class Studentsubjects_ { 

    public static volatile SingularAttribute<Studentsubjects, String> evaluation;
    public static volatile SingularAttribute<Studentsubjects, Migrant> migrant;
    public static volatile SingularAttribute<Studentsubjects, StudentsubjectsPK> studentsubjectsPK;
    public static volatile SingularAttribute<Studentsubjects, String> level;
    public static volatile SingularAttribute<Studentsubjects, Subject> subject;

}