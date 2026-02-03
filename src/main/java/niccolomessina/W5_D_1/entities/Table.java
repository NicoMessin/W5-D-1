package niccolomessina.W5_D_1.entities;

public class Table {
    private int number;
    private int maxSeats;
    private TableStatus status;

    public Table(int number, int maxSeats, TableStatus status) {
        this.number = number;
        this.maxSeats = maxSeats;
        this.status = status;
    }

    public int getNumber() { return number; }
    public int getMaxSeats() { return maxSeats; }
    public TableStatus getStatus() { return status; }
    public void setStatus(TableStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Table{" +
                "number=" + number +
                ", maxSeats=" + maxSeats +
                ", status=" + status +
                '}';
    }
}
