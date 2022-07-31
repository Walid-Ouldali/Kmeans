import scala.collection.mutable.ArrayBuffer
import scala.util.Random

class Cluster (nom : String, exemples : Array[Exemple], attributs : Int, categories : Int) :
    private val exemple = new ArrayBuffer[Exemple]
    private var centroid = Individu(attributs)

    def add (numero : Int) : Unit = {
        this.exemple += this.exemples(numero)
    }

   //Tostring
    override def toString : String = {
        return "Cluster " + this.nom + " : " + this.exemple.toString()
    }
    

    //getters
    def getNom : String = {
        return this.nom
    }
    def getExemples : Array[Exemple] = {
        return this.exemple.toArray
    }
    def getAttributs : Int = {
        return this.attributs
    }
    def getCategories : Int = {
        return this.categories
    }
    def getCentre : Individu = {
        return this.centroid
    }
    //setters
    //setcentre
    def setCentre(uncentroid: Individu) : Unit = {
      this.centroid = uncentroid
    }





    def setNewCentroid: Unit = {
      for (j <- 0 to 3) {
        var somme = 0.0
        for (i <- 0 until this.exemple.length) {
          somme += this.exemple(i).get(j)
        }

        this.centroid.set(j, somme.toFloat/this.exemple.length)
      }
    }


    def getDistanceIntra : Double = {
        var somme = 0.0
        for (i <- 0 until this.exemple.length){
          somme += math.pow(this.exemple(i).distance(this.centroid),2)
        }
        return 1.toFloat/this.exemple.length*(somme)
    }