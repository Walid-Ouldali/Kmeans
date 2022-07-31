import scala.collection.mutable.ArrayBuffer

object App {
  def main(args: Array[String]): Unit = {
    val kmeans = new Kmeans("src/main/resources/iris.data", "src/main/resources/irisAttributesNames.txt")
    val tabResultat = new ArrayBuffer[String]
    println("Veuillez patienter les résultats sont en cours de calcul et peuvent prendre quelques minutes   ")



    for (i <- 2 to 10){
      var somme = 0.0
      for (j <- 0 until 20){
        somme += kmeans.clustering(i)

      }
      println(s"Pour K = $i : qualité moyenne = ${somme.toFloat/20}")
      tabResultat += s"Pour K = $i : qualité moyenne = ${somme.toFloat/20}"
    }

  }
}
