package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Migrant;
import model.Result;
import model.StudentresultsPK;
import model.Teacher;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-13T22:35:45")
@StaticMetamodel(Studentresults.class)
public class Studentresults_ { 

    public static volatile SingularAttribute<Studentresults, Result> result;
    public static volatile SingularAttribute<Studentresults, String> note;
    public static volatile SingularAttribute<Studentresults, Teacher> teacher;
    public static volatile SingularAttribute<Studentresults, Migrant> migrant;
    public static volatile SingularAttribute<Studentresults, String> level;
    public static volatile SingularAttribute<Studentresults, StudentresultsPK> studentresultsPK;

}