package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Migrantteacher;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-13T22:35:45")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile SingularAttribute<Teacher, String> firstName;
    public static volatile SingularAttribute<Teacher, String> lastName;
    public static volatile SingularAttribute<Teacher, String> teacherCode;
    public static volatile SingularAttribute<Teacher, String> educationalInstitutionName;
    public static volatile SingularAttribute<Teacher, String> countryOfResidence;
    public static volatile CollectionAttribute<Teacher, Migrantteacher> migrantteacherCollection;
    public static volatile SingularAttribute<Teacher, String> email;

}