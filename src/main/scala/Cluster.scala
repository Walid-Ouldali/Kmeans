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
    def getCentroid : Individu = {
        return this.centroid
    }
    //setters
    def setCentre(uncentroid: Individu) : Unit = {
      this.centroid = uncentroid
    }
    //setcentre
