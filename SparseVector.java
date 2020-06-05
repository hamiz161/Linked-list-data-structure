/**
 * @author Prénom Nom - Matricule
 * @author Prénom Nom - Matricule
 */

public class SparseVector {

    private Node head;
    private Node last ;
    private  Node previous;
    private int lengthVictorNull = 0  ;
    private int lengthVictOriginal = 0;
    private  int sizeNonull = 0 ;





    private class Node {

       public Object data ;
       public Node next ;

       public Node (Object data , Node next){
           this.next = next ;
           this.data = data ;
       }
    }

    public SparseVector() {
        this(10);
    }

    public SparseVector(int length) {

        if(length > 0) {

            head = new Node(null, null);
            lengthVictorNull++;
            lengthVictOriginal++;


            Node currantNode = head;
            this.last = currantNode;

            for (int i = 1; i < length; i++) {

                currantNode.next = new Node(null, null);
                currantNode = currantNode.next;
                this.last = currantNode;
                lengthVictorNull++;
                lengthVictOriginal++;
            }
        }else if(length < 0) {
            throw new IllegalArgumentException("Illegal Capacity");
        }
    }

    // Obtenir la valeur de l'élément à la position index


    public Object get(int index) throws NullPointerException{

        Node node = head;
        if (index < 0)
            throw new NullPointerException("l'index : "+index+" out of bounds for length "+lengthVictOriginal);
        for (int i = 0; i < index ; i++)
            node = node.next;

        return node.data;
    }

    // Ajouter ou mettre à jour l'élément à la position index
    public void set(int index, Object value) {
        if(index < 0 || index >= lengthVictOriginal )
            throw new ArrayIndexOutOfBoundsException("your Index  out of bounds");

        else {

            if (index == 0) {
                Node currentNode = head;
                currentNode.data = value;
                sizeNonull++;
                lengthVictorNull--;


            } else if (index == lengthVictOriginal) {
                this.last.data = value;
            } else {
                Node curentNod = head;

                for (int i = 1; i < index; i++) {
                    curentNod = curentNod.next;
                }
                curentNod = curentNod.next;
                curentNod.data = value;
                sizeNonull++;
                lengthVictorNull--;
            }
        }
    }
    // Supprimer l'élément à la position index
    public void remove(int index) {
       if(lengthVictOriginal == 0)
            throw new ArrayIndexOutOfBoundsException("Array index out of range: "+index);
       else if(lengthVictOriginal == 1) {
           last = head = null;
           sizeNonull--;
           lengthVictorNull++;
       }
       else{
            Node curentNod = head;
            previous = head;
            while (curentNod.next != null){

            }
       }
    }

    // Longueur du vecteur creux

    public int length() {
        return this.lengthVictorNull;
    }

    // Nombre d'éléments non nuls
    public int size() {
        return this.sizeNonull;
    }
}

