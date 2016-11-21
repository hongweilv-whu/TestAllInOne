package collect;

import org.apache.commons.lang.StringUtils;

/**
 * Description:
 * Created by lvhw on 2016/8/16 7:31.
 */
public class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        String all = name + id;

        return all.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (obj instanceof Person){
            Person p = (Person)obj;
            if (!StringUtils.equals(p.getName(), name)){
                return false;
            }
            if (p.getId() != id){
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return name + ":" + id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
