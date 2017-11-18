package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Migrant;
import model.MigrantteacherPK;
import model.Teacher;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-13T22:35:45")
@StaticMetamodel(Migrantteacher.class)
public class Migrantteacher_ { 

    public static volatile SingularAttribute<Migrantteacher, Teacher> teacher;
    public static volatile SingularAttribute<Migrantteacher, MigrantteacherPK> migrantteacherPK;
    public static volatile SingularAttribute<Migrantteacher, Migrant> migrant;
    public static volatile SingularAttribute<Migrantteacher, Date> dateTo;
    public static volatile SingularAttribute<Migrantteacher, Date> dateFrom;

}