package domain;

import java.util.Objects;

public class CommonCustomer {

    private String name;
    private int clientNumber;

    public CommonCustomer(String name, int clientNumber) {
        this.name = name;
        this.clientNumber = clientNumber;
    }

    public String getName() {
        return name;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonCustomer that = (CommonCustomer) o;
        return clientNumber == that.clientNumber && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, clientNumber);
    }

    @Override
    public String toString() {
        return "Читатель {" +
                "Имя " + name + '\'' +
                ", Номер читательского билета =" + clientNumber +
                '}';
    }
}
