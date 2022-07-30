object testkmeans {
  def main(args: Array[String]): Unit = {

    println("Hello world!")
    val kmeans = new Kmeans("src/main/resources/iris.data", "src/main/resources/irisAttributesNames.txt")
    kmeans.clustering(3)
   

//    val data = new Data("src/main/resources/iris.data", "src/main/resources/irisAttributesNames.txt")
//    val exemples = data.getNormalizedData
//    var stable = false
//    if(exemples(0).distance(exemples(1)) == 0){
//      stable = true
//    }
//    println(stable)

  }
}
