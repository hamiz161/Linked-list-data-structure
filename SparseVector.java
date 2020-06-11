/**
 * @author Hamza Guerabli - 20112229
 * @author Yuyin Ding  - 20125263
 *
 *
 * méthode print() pour tester a la fin
 * */

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
    /**
     *
     * @param index
     * @param value
     * @throws NullPointerException
     */
    public void set(int index, Object value)throws NullPointerException {

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

    /**
     *
     * @param index
     */
    public void remove(int index) {

        if(index < 0 || index >= this.length)
            throw new ArrayIndexOutOfBoundsException("Array index out of range: "+index);

        Node nodeCuren = head ;

        // si on juste un node a la position 0
        if(nodeCuren.next == null)
            head = null;

        else {

            Node previous = null;
            while (nodeCuren != null){

                if(nodeCuren.indexNode == index ) {
                    // supprimer le prmier node d un vector length > 0
                    if (previous == null) {
                        this.head = nodeCuren.next;


                    } else {
                        //suprimer le dernier node
                        if (nodeCuren.next == null) {
                            previous.next = null;

                        // suprimer un node au milieu de la liste
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

    /**
     *
     * @return la taille  de vector null
     */
   public int length() {
        int length = this.length;
        Node node = head;

        while(node != null) {
            node = node.next;
            length --;
        }

        return length;
    }

    /**
     *
     * @return la taille de vector non null
     */
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
