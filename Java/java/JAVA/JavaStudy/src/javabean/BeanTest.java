package javabean;

public class BeanTest {
    public static void main(String[] args) {
        PersonBean person = new PersonBean();

        person.setName("張三");
        person.setDeceased(true);
        person.setName("張三zxcza");
        person.setDeceased(true);
        // 輸出: "張三[活著]"
        System.out.print(person.getName());
        System.out.println(person.isDeceased() ? " [已故]" : " [活著]");
    }
}
