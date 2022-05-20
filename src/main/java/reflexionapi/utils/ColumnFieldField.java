package reflexionapi.utils;

import java.lang.reflect.Field;

public class ColumnFieldField {
    private final Field field;

    public ColumnFieldField(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return field.getName();
    }

    public Class<?> getType() {
        return field.getType();
    }
}
