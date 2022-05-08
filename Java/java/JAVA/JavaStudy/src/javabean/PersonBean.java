package javabean;

import java.io.Serializable;

public class PersonBean implements Serializable {

    /**
     * name 屬性(注意大小寫)
     */
    private String name;

    private boolean deceased;

    /** 無參數建構子(没有參數) */
    public PersonBean() {
    }

    /**
     * name 屬性的 Getter方法
     */
    public String getName() {
        return name;
    }

    /**
     * name 屬性的Setter方法
     * @param value
     */
    public void setName(final String value) {
        name = value + "123";
    }

    /**
     * deceased 屬性的Getter方法
     * 布林值屬性Getter方法的不同形式(這裡使用了is而非get)
     */
    public boolean isDeceased() {
        return deceased;
    }

    /**
     * deceased 屬性的Setter方法
     * @param value
     */
    public void setDeceased(final boolean value) {
        deceased = value;
    }
}
