cd /usr/local/Cellar/apache-flink/1.8.1

./libexec/bin/start-cluster.sh
nc -l 9000
/usr/local/bin/flink run -c flink.FlinkQuickStart /Users/yadong/Documents/work/algorithm/target/leetcode-1.0-SNAPSHOT.jar 127.0.0.1 9000