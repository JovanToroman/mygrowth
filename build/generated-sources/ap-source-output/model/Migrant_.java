package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Migrantteacher;
import model.Studentresults;
import model.Studentsubjects;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-27T20:34:23")
@StaticMetamodel(Migrant.class)
public class Migrant_ { 

    public static volatile SingularAttribute<Migrant, String> firstName;
    public static volatile SingularAttribute<Migrant, String> lastName;
    public static volatile CollectionAttribute<Migrant, Studentsubjects> studentsubjectsCollection;
    public static volatile SingularAttribute<Migrant, String> motherTongue;
    public static volatile CollectionAttribute<Migrant, Studentresults> studentresultsCollection;
    public static volatile SingularAttribute<Migrant, String> studentCode;
    public static volatile SingularAttribute<Migrant, Date> dateOfBirth;
    public static volatile SingularAttribute<Migrant, String> countryOfOrigin;
    public static volatile CollectionAttribute<Migrant, Migrantteacher> migrantteacherCollection;
    public static volatile SingularAttribute<Migrant, String> profileImageUrl;
    public static volatile SingularAttribute<Migrant, String> email;

}