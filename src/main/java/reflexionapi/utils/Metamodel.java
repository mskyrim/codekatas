package reflexionapi.utils;

import reflexionapi.annotation.Column;
import reflexionapi.annotation.PrimaryKey;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Metamodel<T> {

    private Class<T> clss;

    public Metamodel(Class<T> clss) {
        this.clss = clss;
    }

    public static <T> Metamodel of(Class<T> targetClass) {
        return new Metamodel(targetClass);
    }

    public PrimaryKeyField getPrimaryKey() {
        Field[] declaredFields = this.clss.getDeclaredFields();
        for (Field field : declaredFields) {
            PrimaryKey annotation = field.getAnnotation(PrimaryKey.class);
            if (annotation != null) {
                return new PrimaryKeyField(field);
            }

        }
        throw new IllegalArgumentException(" No primary key field found in class " + clss.getSimpleName());
    }

    public List<ColumnFieldField> getColumns() {
        Field[] declaredFields = clss.getDeclaredFields();
        List<ColumnFieldField> columnFieldFields = Arrays.stream(declaredFields).filter(field -> field.getAnnotation(Column.class) != null)
                .map(ColumnFieldField::new)
                .collect(Collectors.toList());
        Optional<List<ColumnFieldField>> columnFieldFieldList = Optional.of(columnFieldFields);
        return columnFieldFieldList.orElseThrow(() -> new IllegalArgumentException(MessageFormat.format(" No column field found in class {0}", clss.getSimpleName())));
    }
}
