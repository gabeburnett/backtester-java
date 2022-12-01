package nz.gabe.backtester.api.event.events;

import nz.gabe.backtester.api.event.Event;
import nz.gabe.backtester.api.event.EventType;
import nz.gabe.backtester.api.model.Balance;

import java.util.List;

public class BalanceEvent implements EventBase {

    private List<Balance> balances;

    public BalanceEvent(List<Balance> balances) {
        this.balances = balances;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    public String toJson() {
        return Event.toJson(EventType.BALANCE, this);
    }
}
