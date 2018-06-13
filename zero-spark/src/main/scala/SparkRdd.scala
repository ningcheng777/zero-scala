import org.apache.spark.{SparkConf, SparkContext}

object SparkRdd {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("rddTest").setMaster("local")
    val sc = new SparkContext(conf)
    val data = Array(1, 2, 3, 4, 5)
    val distData = sc.parallelize(data)
    val sum = distData.reduce(_ + _)
    println(sum)
    sc.stop()
  }
}
