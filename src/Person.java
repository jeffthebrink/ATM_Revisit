public class Person {
    String name;
    Integer accountBalance;

    public Person(String name, Integer accountBalance) {
        this.name = name;
        this.accountBalance = accountBalance;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Integer accountBalance) {
        this.accountBalance = accountBalance;
    }
}
