import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class Kmeans (fichierDonnees: String, fichierAttributs : String) :
  private val clusters = new ArrayBuffer[Cluster]
  private val donnees = new Data(fichierDonnees, fichierAttributs)
  private val exemples =  donnees.getNormalizedData


  def clustering(k : Int): Int =
    // Initialisation des clusters
    for (i <- 0 until k-1) {
      this.clusters += new Cluster("cluster",this.exemples, k,4)
    }
    //initialisation
    for (i <- 0 until k-1) {
      this.clusters(i).setCentre(Individu.generateRandomIndividu(k,Random))
    }
    for (j <- 0 until exemples.length-1) {
      var cluster = 0
      var distance = this.exemples(j).distance(clusters(0).getCentroid)
      for (i <- 0 until k-1) {
        distance = this.exemples(j).distance(clusters(i).getCentroid)
        if (this.exemples(j).distance(clusters(i).getCentroid) < distance) {
          distance = this.exemples(j).distance(clusters(i).getCentroid)
          cluster = i
        }
      clusters(cluster).add(j)
      }

    }
// Boucle de l'algorithme



    return 0

  //getters
  def getClusters = this.clusters
