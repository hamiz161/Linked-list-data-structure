/**
 * @author Prénom Nom - Matricule
 * @author Prénom Nom - Matricule
 */

public class SparseVector {


    // TODO Ajoutez vos attributs ici
    public class Node {
        public int element;
        public Node prochain;
        private int length;
        private Node premier;

        public Node ( int element, Node prochain ) {
            this.element = element;
            this.prochain = prochain;
        }
    }

    public class ListIndexOutOfBounds extends Exception {

        public ListIndexOutOfBounds() {
        }

        public ListIndexOutOfBounds(String str) {
            super(str);
        }

        public void getMessage() {
            return "Illegal Capacity";
        }
    }



    public SparseVector() {
        this(10);
    }

    public SparseVector(int length) { // Number of elements
        if (length > 0) {
            this.length = length;
        } else
            ListIndexOutOfBounds e;
            System.out.println( e.getMessage() );
            System.exit( 1 );
        }

    // Obtenir la valeur de l'élément à la position index
    public Object get(int index) {
        Node node = this.premier;

        if( index >= 0 && index < length() ) {
            for( int i =0 ; i < index; i++ ) {
                node = node.prochain;
            }
            return node;
        }

        return null;
    }

    // Ajouter ou mettre à jour l'élément à la position index
    public void set(int index, Object value) {
        try {
            get( i ).element = value;
        } catch( ListIndexOutOfBounds e ) {
            System.out.println( e.getMessage() );
            System.exit( 1 );
        }
        // TODO À compléter
    }

    // Supprimer l'élément à la position index
    public void remove( int i ) {         // Delete ith element
        int retour = 0;

        // Cas 1 : retirer le premier élément
        if( i == 0 ) {
            retour = this.premier.element;
            this.premier = this.premier.prochain;
        }

        // Cas 2 : retirer le ième élément
        else {
            try {
                Node precedent = getNoeud( i - 1 );
                // On obtient l'element i
                retour = precedent.prochain.element;

                // On connecte le noeud i-1 au noeud i+1
                precedent.prochain = precedent.prochain.prochain;
            } catch ( ListIndexOutOfBounds e ) {
                System.out.println( e.getMessage() );
                System.exit( 1 );
            }
        }
        return retour;
    }

    /**
     * Affiche les éléments de la liste
     */
    public void print() {
        Node node = this.premier;

        while( node != null ) {
            System.out.println( node.element );
            node = node.prochain;
        }
    }

    // Longueur du vecteur creux
    public int length() {
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
        int size = 0;
        Node node = this.premier;

        while( node != null ) {
            size++;
            node = node.prochain;
        }
        return size;
    }


}
