package nz.gabe.backtester.api.model;

public class Balance {

    private String asset;

    private float amount;

    public Balance(String asset, float amount) {
        this.asset = asset;
        this.amount = amount;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
