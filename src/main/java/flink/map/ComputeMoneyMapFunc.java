package flink.map;

import flink.codec.TransMetric;
import org.apache.flink.api.common.functions.MapFunction;

public class ComputeMoneyMapFunc implements MapFunction<String, TransMetric> {
    @Override
    public TransMetric map(String s) throws Exception {
        String goodsName = "";
        int prices = 0;
        String[] tokens = s.toLowerCase().split("\\W+");
        goodsName = tokens[0];
        prices = Integer.parseInt(tokens[1]);
        return new TransMetric(goodsName, prices);
    }
}
