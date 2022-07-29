object testkmeans {
  def main(args: Array[String]): Unit = {

    println("Hello world!")
    val kmeans = new Kmeans("src/main/resources/iris.data", "src/main/resources/irisAttributesNames.txt")
    kmeans.clustering(3)
    println(kmeans.getClusters(0))


  }
}
