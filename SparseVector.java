/**
 * @author Hamza Guerabli - 20112229
 * @author Prénom Nom - Matricule
 */

public class SparseVector {

    private Node head;
   // private Node last ;
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

    /**
     * constructeur
     * @param length longueur de vecteur creux
     */
    public SparseVector(int length) {

        if(length > 0) {

            head = new Node(null, null);
            lengthVictorNull++;
            lengthVictOriginal++;

            Node currantNode = head;

            for (int i = 1; i < length; i++) {

                currantNode.next = new Node(null, null);
                currantNode = currantNode.next;

                //this.last = currantNode;

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
        if (index < 0  )
            throw new NullPointerException("l'index : "+index+" out of bounds for length "+lengthVictOriginal);

        for (int i = 0; i < index ; i++)
            node = node.next;

        return node.data;
    }

    // Ajouter ou mettre à jour l'élément à la position index
    public void set(int index, Object value) {

        if(index < 0 ||  index > this.size())
            throw new ArrayIndexOutOfBoundsException("your Index  out of bounds ");

        else {

            Node curentNod = head;

            for (int i = 0; i < index; i++) {

                if(index != lengthVictOriginal )
                    curentNod = curentNod.next;
            }

            if (curentNod.data != null){
                sizeNonull--;
                lengthVictorNull++;
            }
            curentNod.data = value;

            sizeNonull++;
            lengthVictorNull--;
        }

    }
    // Supprimer l'élément à la position index
    public void remove(int index) {

       if(this.size() == 0 || index < 0 || index >= this.size())
            throw new ArrayIndexOutOfBoundsException("Array index out of range: "+index);

       else if(this.size() == 1) {
            head = null;
           sizeNonull--;
           lengthVictorNull++;
       }
       else{

            Node previous = head ;
            Node curentNod = head.next;

            if(index == 0){
               head =curentNod;

            }else {

               for (int j = 0; j < index; j++) {

                   if((index - j )!= 1)
                       previous =curentNod;

                   curentNod =curentNod.next;
               }
               previous.next = curentNod;

            }
           sizeNonull--;
           lengthVictorNull++;
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
    public void print() {
        Node node = this.head;
        int i = 0;
        while (i < this.size()) {
            System.out.println(node.data);
            node = node.next;
            i++;
        }

    }
}
