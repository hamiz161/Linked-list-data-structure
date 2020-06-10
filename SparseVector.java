/**
 * @author Hamza Guerabli - 20112229
 * @author Prénom Nom - Matricule
 */

public class SparseVector {

    private Node head = null;
    private int length;

    private class Node {

        public Object data ;
        public Node next = null;
        public int indexNode = 0;

        public Node (int index, Object data ){
           this.data = data ;
           indexNode = index ;
        }
    }

    public SparseVector() {
        this(10);
    }


    public SparseVector(int length) {

        if(length > 0 ) {
            this.length = length;
        }
        else
            throw new IllegalArgumentException("Illegal Capacity");
    }

    // Obtenir la valeur de l'élément à la position index

    /**
     *
     * @param index
     * @return la valeur
     * @throws NullPointerException
     */
    public Object get(int index) throws NullPointerException{

        if (index < 0  || index >= this.length  )
            throw new NullPointerException("l'index :  out of bounds for length "+ length);

        Node node = head;

        while (node != null) {
            if (node.indexNode == index) {
                return node.data;
            }

            node = node.next;
        }

        return null;
    }
    // Ajouter ou mettre à jour l'élément à la position index

    public void set(int index, Object value) {

        if(index < 0 || index >= this.length)
            throw new ArrayIndexOutOfBoundsException("your Index  out of bounds ");

        else {
                Node node = head;
                Node previous = null;

                if (node == null) {
                    head = new Node(index, value);

                } else {
                    while (node != null) {
                        if (node.indexNode == index) {
                            node.data = value;
                            break;

                        } else if(node.indexNode > index) {
                            if (previous == null) {
                                head = new Node(index, value);
                                head.next = node;

                            } else {
                                previous.next = new Node(index, value);
                                previous.next.next = node;
                            }
                            break;
                        } else {
                            
                            previous = node;
                            node = previous.next;

                            if (node == null) {
                                previous.next = new Node(index, value);
                            }
                        }
                    }
                }

            }
    }
    // Supprimer l'élément à la position index
    public void remove(int index) {

        if(index < 0 || index >= this.length)
            throw new ArrayIndexOutOfBoundsException("Array index out of range: "+index);

        Node nodeCuren = head ;

        if(nodeCuren.next == null)
            head = null;

        else {
            Node previous = null;
            while (nodeCuren != null){

                if(nodeCuren.indexNode == index ) {
                    if (previous == null) {
                        this.head = nodeCuren.next;
                    } else {
                        if (nodeCuren.next == null) {
                            previous.next = null;
                        } else {
                            previous.next = nodeCuren.next;
                        }
                    }
                }
                previous = nodeCuren;
                nodeCuren = previous.next;
            }
        }
    }

    // Longueur du vecteur creux

    int length() {
        int length = this.length;
        Node node = head;

        while(node != null) {
            node = node.next;
            length --;
        }

        return length;
    }

    // Nombre d'éléments non nuls
    public int size() {
        int length = 0;
        Node node = head;

        while(node != null) {
            node = node.next;
            length ++;
        }

        return length;
    }

    /**
     * méthode pour tester
     */
    public void print() {
        Node node = this.head;

        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
