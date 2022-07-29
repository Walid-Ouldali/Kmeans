import scala.io.Source

@main
def main(): Unit = {
  println("Hello world!")

  val donnees = new Data("iris.data", "irisAttributesNames.txt")
  donnees.displayData()
}