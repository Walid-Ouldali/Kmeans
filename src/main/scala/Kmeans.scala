import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class Kmeans (fichierDonnees: String, fichierAttributs : String) :
  private val clusters = new ArrayBuffer[Cluster]
  private val donnees = new Data(fichierDonnees, fichierAttributs)
  private val exemples =  donnees.getNormalizedData
  private var stable = false

  def initialisation(k:Int) : Unit = {
    for (i <- 0 until k) {
      this.clusters += new Cluster("cluster", this.exemples, 4, k)
      this.clusters(i).setCentre(Individu.generateRandomIndividu(4, Random))
    }
  }

  def assignation(k: Int): Unit = {
    for (m <- 0 until this.exemples.length) {
      var idcluster = 0
      var distance = this.exemples(m).distance(this.clusters(0).getCentre)
      for (i <- 0 until k) {

        if (this.exemples(m).distance(this.clusters(i).getCentre) < distance) {
          distance = this.exemples(m).distance(this.clusters(i).getCentre)
          idcluster = i
        }
        this.clusters(idcluster).add(m)
      }

    }
  }

  def calculePointMoyens(k: Int): Unit = {
    for (i <- 0 until k) {
      this.clusters(i).setNewCentroid
    }
  }


  def clustering(k : Int): Int =
    var centroid = new Array[Individu](k)
    initialisation(k)
    for (i <- 0 until k) {
      centroid(i)=Individu.generateRandomIndividu(4, Random)
    }

    while (!this.stable) do
      assignation(k)
      println("Assignation")
      println(this.clusters(0).getCentre)
      println(this.clusters(1).getCentre)
      println(this.clusters(2).getCentre)
      calculePointMoyens(k)
      println("calculePointMoyens")
      println(this.clusters(0).getCentre)
      println(this.clusters(1).getCentre)
      println(this.clusters(2).getCentre)

      //verification
      var somme = 0.0
      for (i <- 0 until k){
       somme += centroid(i).distance(this.clusters(i).getCentre)
        println(somme)
      }
      if (somme == 0){
        this.stable = true
      }else{
        for (i <- 0 until k) {
          centroid(i) = this.clusters(i).getCentre
        }
      }


    println("----fin du clustering")
    println(this.clusters(0).getCentre)
    println(this.clusters(1).getCentre)
    println(this.clusters(2).getCentre)

    // Initialisation des clusters


    //--------------------------------------
    //assignation

    //------------------------------
    // calcule des points moyens


// Boucle de l'algorithme



    return 0

  //getters
  def getClusters = this.clusters
