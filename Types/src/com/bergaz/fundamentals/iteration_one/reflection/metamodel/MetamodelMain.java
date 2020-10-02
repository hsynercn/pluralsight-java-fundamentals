package com.bergaz.fundamentals.iteration_one.reflection.metamodel;

import com.bergaz.fundamentals.iteration_one.reflection.metamodel.model.Person;
import com.bergaz.fundamentals.iteration_one.reflection.metamodel.util.ColumnField;
import com.bergaz.fundamentals.iteration_one.reflection.metamodel.util.Metamodel;
import com.bergaz.fundamentals.iteration_one.reflection.metamodel.util.PrimaryKeyField;

import java.util.List;

public class MetamodelMain {
    public static void main(String[] args) {
        Metamodel metamodel = Metamodel.of(Person.class);

        PrimaryKeyField primaryKeyField = metamodel.getPrimaryKey();
        List<ColumnField> columnFields = metamodel.getColumns();

        System.out.println("Primary key name = " + primaryKeyField.getName() +
                ", type = " + primaryKeyField.getType().getSimpleName());
        for (ColumnField columnField : columnFields) {
            System.out.println("Column name = " + columnField.getName() +
                    ", type = " + columnField.getType().getSimpleName());
        }

    }
}
