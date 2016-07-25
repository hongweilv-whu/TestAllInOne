package powermock;

/**
 * 各种显示字段的基类
 * Created by lvhw on 2016/7/6.
 */
public class BaseFieldTestHong {

    private String fieldID;

    private String dbFieldName;

    private String dbObjName;

    private String fieldName;

    private String fieldType;

    private int seq;

    public BaseFieldTestHong(){

    }


    public String getFieldID() {
        return fieldID;
    }

    public void setFieldID(String fieldID) {
        this.fieldID = fieldID;
    }

    public String getDbFieldName() {
        return dbFieldName;
    }

    public void setDbFieldName(String dbFieldName) {
        this.dbFieldName = dbFieldName;
    }

    public String getDbObjName() {
        return dbObjName;
    }

    public void setDbObjName(String dbObjName) {
        this.dbObjName = dbObjName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
