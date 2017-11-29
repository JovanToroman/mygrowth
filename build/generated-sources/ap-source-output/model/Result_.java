package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Competence;
import model.Studentresults;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-27T20:34:23")
@StaticMetamodel(Result.class)
public class Result_ { 

    public static volatile SingularAttribute<Result, Integer> resultID;
    public static volatile CollectionAttribute<Result, Studentresults> studentresultsCollection;
    public static volatile SingularAttribute<Result, Competence> competenceID;
    public static volatile SingularAttribute<Result, String> resultName;

}