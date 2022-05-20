package reflexionapi;

import reflexionapi.utils.ColumnFieldField;
import reflexionapi.utils.Metamodel;
import reflexionapi.utils.PrimaryKeyField;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.List;

public class PlayWithMetamodel {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person person = Person.class.getConstructor(String.class, int.class).newInstance("mehdi", 34);
        Metamodel<Person> metamodel = Metamodel.of(Person.class);

        PrimaryKeyField primaryKeyField = metamodel.getPrimaryKey();
        List<ColumnFieldField> columnFieldFieldList = metamodel.getColumns();

        System.out.println(MessageFormat.format("Primary Key name : {0} Type name : {1} ",primaryKeyField.getName(), primaryKeyField.getType()));
        for (ColumnFieldField field :
                columnFieldFieldList) {
            System.out.println(MessageFormat.format("Column name : {0} Type name  : {1} ",field.getName(), field.getType().getSimpleName()));
        }


    }
}
