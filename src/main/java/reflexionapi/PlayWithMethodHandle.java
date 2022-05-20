package reflexionapi;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.MethodType;

public class PlayWithMethodHandle {
    public static void main(String[] args) throws Throwable {
        Lookup lookup = MethodHandles.lookup();
        MethodType emptyConstructorMethodeType = MethodType.methodType(void.class);
        MethodHandle emptyConstructor = lookup.findConstructor(PersonV2.class, emptyConstructorMethodeType);
        PersonV2  personV2 = (PersonV2) emptyConstructor.invoke();
        System.out.println(personV2);
        MethodType constructorMethodeType = MethodType.methodType(void.class, String.class, int.class);
        MethodHandle constructor = lookup.findConstructor(PersonV2.class, constructorMethodeType);
        PersonV2  personV2James = (PersonV2) constructor.invoke("James", 28);
        System.out.println(personV2James);

        MethodType nameGetterMethodType = MethodType.methodType(String.class);
        MethodHandle getName = lookup.findVirtual(PersonV2.class, "getName", nameGetterMethodType);
        String name = (String) getName.invoke(personV2James);
        System.out.println(name);

        /*Lookup privateLookup = MethodHandles.privateLookupIn(PersonV2.class, lookup);
        MethodHandle nameReader = privateLookup.findGetter(PersonV2.class, "name", String.class);
        String name2 = (String) nameReader.invoke(personV2James);
        System.out.println(name2);*/
    }
}
