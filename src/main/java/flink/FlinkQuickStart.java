package flink;


import flink.codec.TransMetric;
import flink.map.ComputeMoneyMapFunc;
import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.collector.selector.OutputSelector;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.windowing.WindowFunction;
import org.apache.flink.streaming.api.windowing.windows.GlobalWindow;
import org.apache.flink.util.Collector;

import java.util.ArrayList;
import java.util.HashMap;

public class FlinkQuickStart {
    public static void main(String[] args) throws Exception {

        //参数检查
        if (args.length != 2) {
            System.err.println("USAGE:\nSocketTextStreamWordCount <hostname> <port>");
            return;
        }

        String hostName = args[0];
        Integer port = Integer.parseInt(args[1]);

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> text = env.socketTextStream(hostName, port);

        //计数
        DataStream<TransMetric> transMetricDataStream = text
                .map(new ComputeMoneyMapFunc())
                .keyBy("goodsName")
                .countWindow(2)
                .apply(new WindowFunction<TransMetric, TransMetric, Tuple, GlobalWindow>() {
                    @Override
                    public void apply(Tuple tuple, GlobalWindow globalWindow, Iterable<TransMetric> iterable, Collector<TransMetric> collector) throws Exception {
                        HashMap<String, Integer> map = new HashMap<String, Integer>();
                        for (TransMetric transMetric : iterable) {
                            map.put
                                    (
                                            transMetric.getGoodsName(),
                                            map.getOrDefault(transMetric.getGoodsName(), 0)
                                                    + transMetric.getPrice()
                                    );
                        }
                        for (String key : map.keySet()) {
                            collector.collect(new TransMetric(key, map.get(key)));
                        }
                    }
                });

        transMetricDataStream.print();
        DataStream<TransMetric> aStream = transMetricDataStream.split(new OutputSelector<TransMetric>() {
            @Override
            public Iterable<String> select(TransMetric transMetric) {
                ArrayList<String> transMetrics = new ArrayList<>();
                if(transMetric.getGoodsName().equals("a")){
                    transMetrics.add("a");
                }
                else{
                    transMetrics.add("b");
                }
                return transMetrics;
            }
        }).select("a");
        aStream.print();
//        DataStream<Tuple2<String, Integer>> counts = text.flatMap(new LineSplitter())
//                .keyBy(0)
//                .sum(1);
//        counts.print();

        env.execute("Java WordCount from SocketTextStream Example");
    }

    public static final class LineSplitter implements FlatMapFunction<String, Tuple2<String, Integer>> {
        @Override
        public void flatMap(String s, Collector<Tuple2<String, Integer>> collector) {
            String[] tokens = s.toLowerCase().split("\\W+");

            for (String token : tokens) {
                if (token.length() > 0) {
                    collector.collect(new Tuple2<String, Integer>(token, 1));
                }
            }
        }
    }


}
