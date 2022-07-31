import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class Kmeans (fichierDonnees: String, fichierAttributs : String) :
  private val clusters = new ArrayBuffer[Cluster]
  private val donnees = new Data(fichierDonnees, fichierAttributs)
  private val exemples =  donnees.getNormalizedData
  private var stable = false

  // Initialisation des clusters
  def initialisation(k:Int) : Unit = {
    for (i <- 0 until k) {
      this.clusters += new Cluster("cluster", this.exemples, 4, k)
      this.clusters(i).setCentre(Individu.generateRandomIndividu(4, Random))
    }
  }

  //assignation
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

  // calcule des points moyens
  def calculePointMoyens(k: Int): Unit = {
    for (i <- 0 until k) {
      this.clusters(i).setNewCentroid
    }
  }


  def distanceInter(k: Int): Double = {
    var somme = 0.0
    for (i <- 0 until k - 1) {
      for (j <- 1 until k) {
        somme += this.clusters(i).getCentre.distance(this.clusters(j).getCentre)
      }
    }
    val nbrDistances = 2.toFloat / ((k - 1) * k)
    return nbrDistances * somme
  }

  def moyDistanceIntra(k: Int): Double = {
    var somme = 0.0
    for (i <- 0 until k) {
      somme += this.clusters(i).getDistanceIntra
    }
    return somme.toFloat / k

  }


  def clustering(k : Int): Double =
    var centroid = new Array[Individu](k)
    initialisation(k)
//    println("Initialisation")


    for (i <- 0 until k) {
      centroid(i)=Individu.generateRandomIndividu(4, Random)
    }

    // Boucle de l'algorithme
    while (!this.stable) do
      // Initialisation des clusters
      assignation(k)
      // calcule des points moyens
      calculePointMoyens(k)
//      println("calculePointMoyens")


      //verification
      var somme = 0.0
      for (i <- 0 until k){
       somme += centroid(i).distance(this.clusters(i).getCentre)
//        println(somme)
      }
      if (somme == 0){
        this.stable = true
      }else{
        for (i <- 0 until k) {
          centroid(i) = this.clusters(i).getCentre
        }
      }

//    println("----fin du clustering")
    val inter = distanceInter(k)
    val moyintra = moyDistanceIntra(k)
    val quality = inter.toFloat/moyintra

    stable = false
    return quality






