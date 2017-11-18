package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Result;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-10-13T22:35:45")
@StaticMetamodel(Competence.class)
public class Competence_ { 

    public static volatile SingularAttribute<Competence, Integer> competenceID;
    public static volatile CollectionAttribute<Competence, Result> resultCollection;
    public static volatile SingularAttribute<Competence, String> competenceName;

}