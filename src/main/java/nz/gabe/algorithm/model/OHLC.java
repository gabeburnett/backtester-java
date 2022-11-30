package nz.gabe.algorithm.model;

import java.io.Serializable;

public class OHLC {

    OHLCId ohlcId;

    float open;

    float high;

    float low;

    float close;

    float volume;

    float volumeAsset;

    public OHLCId getOhlcId() {
        return ohlcId;
    }

    public float getClose() {
        return close;
    }

    public float getHigh() {
        return high;
    }

    public float getLow() {
        return low;
    }

    public float getOpen() {
        return open;
    }

    public float getVolumeAsset() {
        return volumeAsset;
    }

    public float getVolume() {
        return volume;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public void setVolumeAsset(float volumeAsset) {
        this.volumeAsset = volumeAsset;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "OHLC{" +
                "ohlcId=" + ohlcId +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", close=" + close +
                ", volume=" + volume +
                ", volumeAsset=" + volumeAsset +
                '}';
    }

    public static class OHLCId implements Serializable {

        long symbolId;

        long time;

        public OHLCId() {}

        public OHLCId(long symbolId, long time) {
            this.symbolId = symbolId;
            this.time = time;
        }

        public long getTime() {
            return time;
        }

        public long getSymbolId() {
            return symbolId;
        }
    }
}