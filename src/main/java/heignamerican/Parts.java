package heignamerican;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Parts {
    private final String name;
    private final List<Parts> list;

    public Parts(String aName) {
        name = aName;
        list = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void add(Parts parts) {
        list.add(parts);
    }

    public Collection<? extends Parts> getParts() {
        return list;
    }
}
