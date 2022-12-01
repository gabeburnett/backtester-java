package nz.gabe.backtester.api.model;

public class SymbolAssets {

    private final long symbolId;

    private final String buyAsset;

    private final String sellAsset;

    public SymbolAssets(long symbolId, String buyAsset, String sellAsset) {
        this.symbolId = symbolId;
        this.buyAsset = buyAsset;
        this.sellAsset = sellAsset;
    }

    public long getSymbolId() {
        return symbolId;
    }

    public String getBuyAsset() {
        return buyAsset;
    }

    public String getSellAsset() {
        return sellAsset;
    }
}