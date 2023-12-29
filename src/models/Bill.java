package models;

import java.time.LocalDateTime;

public class Bill extends BaseModel  {
    private LocalDateTime exitTime;
    private double amount;
    private Ticket ticket;
    private Gate gate;


    public Bill(LocalDateTime exitTime, double amount, Ticket ticket, Gate gate) {
        this.exitTime = exitTime;
        this.amount = amount;
        this.ticket = ticket;
        this.gate = gate;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
}
