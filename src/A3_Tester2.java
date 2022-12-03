import java.util.ArrayList;
import java.util.Stack;

class findMostSenior1 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);

        if (!(catCafe.root.findMostSenior().equals(A))) {
            throw new AssertionError("findMostSenior() did not return the correct value."
                    + "\n Expected A but got "
                    + catCafe.root.findMostSenior());
        }

        System.out.println("Test passed.");
    }
}

class findMostSenior2 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 20, 2, 250.0);
        Cat C = new Cat("C", 18, 10, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe catCafe = new CatCafe();

        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);
        catCafe.hire(D);

        catCafe.retire(D);

        if (!(catCafe.root.findMostSenior().equals(B))) {
            throw new AssertionError("findMostSenior() did not return the correct value."
                    + "\n Expected Cat B but got "
                    + catCafe.root.findMostSenior());
        }

        System.out.println("Test passed.");
    }
}

class findMostSenior3 implements Runnable{
    @Override
    public void run() {

        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 20, 2, 250.0);
        Cat C = new Cat("C", 18, 10, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);
        Cat E = new Cat("E", 22, 39, 9, 20.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);
        catCafe.hire(D);
        catCafe.hire(E);

        Cat mostSenior = catCafe.root.senior.findMostSenior();
        Cat expected = D;

        if (!(mostSenior.equals(expected))) {
            throw new AssertionError("findMostSenior() did not return the correct value."
                    + "\n Expected Cat D but got "
                    + mostSenior);
        }

        System.out.println("Test passed.");
    }
}

class findMostJunior1 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);

        if (!(catCafe.root.findMostJunior().equals(A))) {
            throw new AssertionError("findMostJunior() did not return the correct value."
                    + "\n Expected A but got "
                    + catCafe.root.findMostJunior());
        }

        System.out.println("Test passed.");
    }
}

class findMostJunior2 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 20, 2, 250.0);
        Cat C = new Cat("C", 18, 10, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe catCafe = new CatCafe();

        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);
        catCafe.hire(D);

        catCafe.retire(A);

        if (!(catCafe.root.findMostJunior().equals(C))) {
            throw new AssertionError("findMostJunior() did not return the correct value."
                    + "\n Expected Cat C but got "
                    + catCafe.root.findMostJunior());
        }

        System.out.println("Test passed.");
    }
}

class findMostJunior3 implements Runnable{
    @Override
    public void run() {

        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 20, 2, 250.0);
        Cat C = new Cat("C", 18, 10, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);
        Cat E = new Cat("E", 22, 39, 9, 20.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);
        catCafe.hire(D);
        catCafe.hire(E);

        Cat mostJunior = catCafe.root.senior.findMostJunior();
        Cat expected = C;

        if (!(mostJunior.equals(expected))) {
            throw new AssertionError("findMostJunior() did not return the correct value."
                    + "\n Expected Cat C but got "
                    + mostJunior);
        }

        System.out.println("Test passed.");
    }
}

class shallow_copy1 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 10, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 20, 2, 250.0);
        Cat C = new Cat("C", 18, 28, 12, 30.0);
        Cat D = new Cat("D", 12, 45, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);


        CatCafe copy = new CatCafe(cafe);

        if ((copy == cafe)) {
            System.out.println("Shallow copy did not create a new CatCafe object");
        }

        boolean CatNodeA = copy.root.senior!=null && copy.root.senior == cafe.root.senior;
        boolean CatNodeB = copy.root.junior.senior == cafe.root.junior.senior;
        boolean CatNodeC = copy.root.junior == cafe.root.junior;
        boolean CatNodeD = copy.root == cafe.root;


        if (CatNodeA || CatNodeB || CatNodeC || CatNodeD) {
            throw new AssertionError("Shallow copy did not create new CatNode objects");
        }

        System.out.println("Test passed");
    }
}

class shallow_copy2 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 10, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 20, 2, 250.0);
        Cat C = new Cat("C", 18, 10, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);

        CatCafe copy = new CatCafe(cafe);

        if ((copy == cafe)) {
            System.out.println("Shallow copy did not create a new CatCafe object");
        }

        boolean CatA = copy.root.catEmployee == cafe.root.catEmployee;
        boolean CatB = copy.root.junior.catEmployee == cafe.root.junior.catEmployee;
        boolean CatC = copy.root.junior.junior.catEmployee == cafe.root.junior.junior.catEmployee;
        boolean CatD = copy.root.junior.senior.catEmployee == cafe.root.junior.senior.catEmployee;

        if (!(CatA || CatB || CatC || CatD)) {
            throw new AssertionError("Shallow copy created new Cat objects");
        }

        System.out.println("Test passed");
    }
}

class shallow_copy3 implements Runnable {
    @Override
    public void run() {
        Cat A = new Cat("A", 25, 33, 5, 85.0);
        Cat B = new Cat("B", 35, 29, 2, 250.0);
        Cat C = new Cat("C", 18, 12, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);

        cafe.retire(B);
        cafe.retire(C);

        CatCafe copy = new CatCafe(cafe);

        if ((copy == cafe)) {
            System.out.println("Shallow copy did not create a new CatCafe object");
        }

        boolean CatA = copy.root.catEmployee == cafe.root.catEmployee;
        boolean CatB = copy.root.senior.catEmployee == cafe.root.senior.catEmployee;

        if (!(CatA || CatB)) {
            throw new AssertionError("Shallow copy created new Cat objects");
        }

        boolean CatNodeA = copy.root == cafe.root;
        boolean CatNodeB = copy.root.senior == cafe.root.senior;

        if (CatNodeA || CatNodeB) {
            throw new AssertionError("Shallow copy did not create new CatNode objects");
        }

        System.out.println("Test passed");
    }
}

class hire_rotation1 implements Runnable{
    public void run(){
        // example in the pdf
        Cat B = new Cat("Buttercup", 45, 53, 5, 85.0);
        Cat JTO = new Cat("J. Thomas O'Malley", 21, 10, 9, 20.0);
        Cat C = new Cat("Chessur", 8, 23, 2, 250.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(B);
        catCafe.hire(JTO);
        catCafe.hire(C);

        if (!(catCafe.root.catEmployee.equals(B) && catCafe.root.senior.catEmployee.equals(C) && catCafe.root.senior.junior.catEmployee.equals(JTO))){
            throw new AssertionError("Left rotation did not work." +
                    " Chessur should be Buttercup's senior, and JTO should be Chessur's junior.");
        }
        System.out.println("Test passed.");
    }
}

class hire_rotation2 implements Runnable {
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 10, 50, 2, 250.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);


        if (!(catCafe.root.catEmployee.equals(B) && catCafe.root.junior.catEmployee.equals(A))) {
            throw new AssertionError("Left rotation did not work." +
                    " Cat B should be root and Cat A should be B's junior");
        }

        if (catCafe.root.junior.parent != catCafe.root || catCafe.root.parent != null) {
            throw new AssertionError("Parent pointers are not set correctly.");
        }

        System.out.println("Test passed.");
    }
}

class hire_rotation3 implements Runnable {
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 30, 50, 2, 250.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);

        if (!(catCafe.root.catEmployee.equals(B) && catCafe.root.senior.catEmployee.equals(A))) {
            throw new AssertionError("Right rotation did not work." +
                    " Cat B should be root and Cat A should be B's senior");
        }

        if (catCafe.root.senior.parent != catCafe.root) {
            throw new AssertionError("Parent pointers are not set correctly");
        }

        System.out.println("Test passed.");
    }
}

class hire_rotation4 implements Runnable {
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 10, 50, 2, 250.0);
        Cat C = new Cat("C", 30, 60, 2, 250.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);

        if (!(catCafe.root.catEmployee.equals(C) && catCafe.root.senior.catEmployee.equals(B) && catCafe.root.senior.junior.catEmployee.equals(A))) {
            throw new AssertionError("Left and right rotations did not work." +
                    " Cat C should be root, Cat B should be C's senior and Cat A should be B's junior");
        }

        if (catCafe.root.senior.parent != catCafe.root && catCafe.root.senior.junior.parent != catCafe.root.senior) {
            throw new AssertionError("Parent pointers are not set correctly.");
        }
        System.out.println("Test passed.");
    }
}

class hire_megaRotation implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 30, 2, 250.0);
        Cat C = new Cat("C", 10, 35, 2, 250.0);
        Cat D = new Cat("D", 8, 38, 5, 85.0);
        Cat E = new Cat("E", 22, 39, 9, 20.0);
        Cat F = new Cat("F", 25, 48, 9, 20.0);
        Cat G = new Cat("G", 28, 45, 9, 20.0);
        Cat H = new Cat("H", 30, 28, 9, 20.0);
        Cat I = new Cat("I", 29, 50, 9, 20.0);


        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);
        catCafe.hire(D);
        catCafe.hire(E);
        catCafe.hire(F);
        catCafe.hire(G);
        catCafe.hire(H);
        catCafe.hire(I);

        // tree should end up looking like this (going from top to bottom):

        //                      (root)
        //          ---------  I (29, 50) --------
        //        /                                 \
        //      H (30, 28)               ----   F (25, 48) ----
        //                              /                       \
        //                         G (28, 45)            --- A (20, 40) ---
        //                                             /                     \
        //                                           E (22, 39)         -- D (8, 38)
        //                                                             /
        //                                                       -- C (10, 35)
        //                                                     /
        //                                                 B (15, 30)


        // tree should end up looking like this (going from ;eft to right):

        //                                      D (8, 38)
        //                                      /           \
        //                                     /             \
        //                            A (20, 40)               C (10, 35)
        //                           /          \                       \
        //                          /            \                       \
        //            F (25, 48)                  E (22, 39)             B (15, 30)
        //              /           \
        //             /             \
        //            /               G (28, 45)
        //  (root) I (29, 50)
        //            \
        //             \
        //              \
        //                H (30, 28)

        if (!(catCafe.root.catEmployee.equals(I))) {
            throw new AssertionError("Incorrect root." +
                    "Cat I should be root but got " + catCafe.root.catEmployee);
        }

        CatCafe.CatNode current = catCafe.root;

        while (current.junior != null) {
            current = current.junior;
        }
        if (!(current.catEmployee.equals(H))) {
            throw new AssertionError("Incorrect leftmost node." +
                    "Cat H should be leftmost node to the root but got " + current.catEmployee);
        }

        current = catCafe.root;
        while (current.senior != null) {
            current = current.senior;
        }
        if (!(current.catEmployee.equals(D))) {
            throw new AssertionError("Incorrect rightmost node." +
                    "Cat D should be rightmost node to the root but got " + current.catEmployee);
        }

        if (catCafe.root.parent != null || catCafe.root.junior.parent != catCafe.root || catCafe.root.senior.parent != catCafe.root) {
            throw new AssertionError("Parent pointers of the 1st and 2nd level are not set correctly.");
        }

        if (!(catCafe.root.findMostSenior().equals(D) && catCafe.root.findMostJunior().equals(H))) {
            throw new AssertionError("findMostSenior() or findMostJunior() is not working correctly."
                    + "\n Expected D (most senior) and H (most junior) but got "
                    + catCafe.root.findMostSenior() + " and "
                    + catCafe.root.findMostJunior());
        }

        System.out.println("Test passed.");
    }
}

class retire_rotation1 implements Runnable{
    @Override
    public void run() {
        // example from the pdf
        Cat B = new Cat("Buttercup", 45, 53, 5, 85.0);
        Cat C = new Cat("Chessur", 8, 23, 2, 250.0);
        Cat JTO = new Cat("J. Thomas O’Malley", 21, 10, 9, 20.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(B);
        catCafe.hire(JTO);
        catCafe.hire(C);

        catCafe.retire(B);

        if (!(catCafe.root.catEmployee.equals(C) && catCafe.root.junior.catEmployee.equals(JTO) && catCafe.root.senior == null)) {
            throw new AssertionError("Retire did not work properly." +
                    "\n Cat C should be root and Cat JTO should be its junior but got " + catCafe.root
                    + " as root and " + catCafe.root.junior + " as its junior");
        }

        if (catCafe.root.parent != null || catCafe.root.junior.parent != catCafe.root) {
            throw new AssertionError("Parent pointers are not set correctly.");
        }

        System.out.println("Test passed.");
    }
}

class retire_rotation2 implements Runnable{
    @Override
    public void run() {
        // example from the pdf continued
        Cat C = new Cat("Chessur", 8, 23, 2, 250.0);
        Cat J = new Cat("Jonesy", 0, 21, 12, 30.0);
        Cat JJ = new Cat("JIJI", 156, 17, 1, 30.0);
        Cat JTO = new Cat("J. Thomas O’Malley", 21, 10, 9, 20.0);
        Cat MrsN = new Cat("Mrs. Norris", 100, 68, 15, 115.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(C);
        catCafe.hire(JTO);
        catCafe.hire(JJ);
        catCafe.hire(J);
        catCafe.hire(MrsN);

        catCafe.retire(MrsN);

        if (!(catCafe.root.catEmployee.equals(C))) {
            throw new AssertionError("Retire did not work properly." +
                    "\n Cat C should be the new root but got " + catCafe.root);
        }

        if (!(catCafe.root.junior.catEmployee.equals(JJ) && catCafe.root.senior.catEmployee.equals(J))) {
            throw new AssertionError("Retire did not work properly." +
                    "\n Cat Jiji should be the C's junior and Cat Jonesy should be the C's senior but got "
                    + catCafe.root.junior + " as the junior and " + catCafe.root.senior + " as the senior");
        }

        if (!(catCafe.root.junior.senior.catEmployee.equals(JTO) && catCafe.root.junior.junior == null)) {
            throw new AssertionError("Retire did not work properly." +
                    "\n Cat JTO should be the JJ's senior and JJ should not have a junior but got "
                    + catCafe.root.junior.senior + " as the senior and " + catCafe.root.junior.junior + " as the junior");
        }

        if (!(catCafe.root.senior.senior == null && catCafe.root.senior.junior == null)) {
            throw new AssertionError("Retire did not work properly." +
                    "\n Jonesy should not have any juniors or seniors but got "
                    + catCafe.root.senior.senior + " as the senior and " + catCafe.root.senior.junior + " as the junior");
        }

        if (catCafe.root.parent != null || catCafe.root.junior.parent != catCafe.root || catCafe.root.senior.parent != catCafe.root) {
            throw new AssertionError("Parent pointers of the 1st and 2nd level are not set correctly.");
        }

        if (catCafe.root.junior.senior.parent != catCafe.root.junior) {
            throw new AssertionError("Parent pointers of 3rd level are not set correctly.");
        }

        System.out.println("Test passed.");
    }
}

class retire_megaRotation3 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 30, 2, 250.0);
        Cat C = new Cat("C", 10, 35, 2, 250.0);
        Cat D = new Cat("D", 8, 38, 5, 85.0);
        Cat E = new Cat("E", 22, 39, 9, 20.0);
        Cat F = new Cat("F", 25, 48, 9, 20.0);
        Cat G = new Cat("G", 28, 45, 9, 20.0);
        Cat H = new Cat("H", 60, 28, 9, 20.0);
        Cat I = new Cat("I", 50, 50, 9, 20.0);
        Cat J = new Cat("J", 70, 18, 9, 20.0);
        Cat K = new Cat("K", 55, 20, 9, 20.0);
        Cat L = new Cat("L", 59, 10, 9, 20.0);
        Cat M = new Cat("M", 58, 25, 9, 20.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);
        catCafe.hire(D);
        catCafe.hire(E);
        catCafe.hire(F);
        catCafe.hire(G);
        catCafe.hire(H);
        catCafe.hire(I);
        catCafe.hire(J);
        catCafe.hire(K);
        catCafe.hire(L);
        catCafe.hire(M);

        catCafe.retire(I);
        // should move K up to the root
        // then down-heap through rotations
        // to the right place (as the senior to M at level 5)

        if (!(catCafe.root.catEmployee.equals(F))) {
            throw new AssertionError("Retire did not work properly." +
                    "\n Cat F should be the new root but got " + catCafe.root);
        }

        if (!(catCafe.root.junior.catEmployee.equals(G) && catCafe.root.senior.catEmployee.equals(A))) {
            throw new AssertionError("Retire rotations did not work properly for the 2nd level.");
        }

        if (!(catCafe.root.junior.junior.catEmployee.equals(H) && catCafe.root.senior.senior.catEmployee.equals(D)) && catCafe.root.senior.junior.catEmployee.equals(E)) {
            throw new AssertionError("Retire rotations did not work properly for the 3rd level.");
        }

        if (!(catCafe.root.junior.junior.junior.catEmployee.equals(J) && catCafe.root.junior.junior.senior.catEmployee.equals(M))
                && catCafe.root.senior.senior.junior.catEmployee.equals(C) && catCafe.root.senior.senior.senior.catEmployee == null
        && catCafe.root.senior.junior.junior.catEmployee == null && catCafe.root.senior.junior.senior.catEmployee == null) {
            throw new AssertionError("Retire rotations did not work properly for the 4th level.");
        }

        if (!(catCafe.root.junior.junior.junior.junior == null && catCafe.root.junior.junior.junior.senior == null
        && catCafe.root.junior.junior.senior.junior.catEmployee.equals(L) && catCafe.root.junior.junior.senior.senior.catEmployee.equals(K)
        && catCafe.root.senior.senior.junior.junior.catEmployee.equals(B) && catCafe.root.senior.senior.junior.senior == null)) {
            throw new AssertionError("Retire rotations did not work properly for the 5th level.");
        }

        if (catCafe.root.parent != null || catCafe.root.junior.parent != catCafe.root || catCafe.root.senior.parent != catCafe.root) {
            throw new AssertionError("Parent pointers of the 1st and 2nd level are not set correctly.");
        }

        if (!catCafe.root.findMostSenior().equals(D))
            throw new AssertionError("findMostSenior() did not work properly."
                    + "\n Cat D should be the most senior but got " + catCafe.root.findMostSenior());

        if (!catCafe.root.findMostJunior().equals(J))
            throw new AssertionError("findMostJunior() did not work properly."
                    + "\n Cat J should be the most junior but got " + catCafe.root.findMostJunior());

        System.out.println("Test passed.");
    }
}

class retire_edgeCase1 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 25, 33, 5, 85.0);
        Cat B = new Cat("B", 35, 29, 2, 250.0);
        Cat C = new Cat("C", 18, 12, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);

        CatCafe.CatNode returnValue = cafe.root.junior.retire(A);

        if (!(returnValue.catEmployee.equals(B))) {
            throw new AssertionError("Retire did return the correct node." +
                    "\n The node the method was called on (Cat B node) should be returned but got"
                    + cafe.root.junior);
        }

        System.out.println("Test passed.");
    }
}

class retire_edgeCase2 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 25, 33, 5, 85.0);
        Cat B = new Cat("B", 35, 29, 2, 250.0);
        Cat C = new Cat("C", 18, 12, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);

        CatCafe.CatNode returnValue = cafe.root.retire(D);

        if (!(returnValue.catEmployee.equals(A))) {
            throw new AssertionError("Retire did return the correct node." +
                    "\n The node the method was called on (Cat A node) should be returned but got "
                    + returnValue);
        }

        System.out.println("Test passed.");
    }
}

class retire_edgeCase4 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 25, 33, 5, 85.0);
        Cat B = new Cat("B", 35, 29, 2, 250.0);
        Cat C = new Cat("C", 18, 12, 12, 30.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);

        cafe.retire(A);
        cafe.retire(A);

        if (!(cafe.root.catEmployee.equals(B) && cafe.root.senior.catEmployee.equals(C))) {
            throw new AssertionError("Retire did not work properly." +
                    "\n The root should be Cat B and the junior should be Cat C but got " + cafe.root);
        }

        System.out.println("Test passed.");
    }
}

class retire_edgeCase5 implements Runnable {
    @Override
    public void run() {
        Cat A = new Cat("A", 25, 33, 5, 85.0);
        Cat B = new Cat("B", 35, 29, 2, 250.0);
        Cat C = new Cat("C", 18, 12, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);

        cafe.retire(A);
        cafe.retire(D);

        if (!(cafe.root.catEmployee.equals(B) && cafe.root.senior.catEmployee.equals(C))) {
            throw new AssertionError("Retire did not work properly." +
                    "\n The root should be Cat B and the junior should be Cat C but got " + cafe.root);
        }

        System.out.println("Test passed.");
    }
}

class retire_edgeCase6 implements Runnable {
    @Override
    public void run() {
        Cat A = new Cat("A", 25, 33, 5, 85.0);
        Cat B = new Cat("B", 35, 29, 2, 250.0);
        Cat C = new Cat("C", 40, 12, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);

        cafe.retire(A);
        cafe.retire(D);

        if (!(cafe.root.catEmployee.equals(B) && cafe.root.junior.catEmployee.equals(C))) {
            throw new AssertionError("Retire did not work properly." +
                    "\n The root should be Cat B and the junior should be Cat C but got " + cafe.root);
        }

        System.out.println("Test passed.");
    }
}

class retire_edgeCase7 implements Runnable {
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 20, 2, 250.0);
        Cat C = new Cat("C", 18, 10, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);
        Cat E = new Cat("E", 22, 39, 9, 20.0);
        Cat F = new Cat("F", 25, 48, 9, 20.0);
        Cat G = new Cat("G", 28, 45, 9, 20.0);
        Cat H = new Cat("H", 60, 28, 9, 20.0);
        Cat I = new Cat("I", 50, 50, 9, 20.0);
        Cat J = new Cat("J", 70, 18, 9, 20.0);
        Cat K = new Cat("K", 55, 20, 9, 20.0);
        Cat L = new Cat("L", 59, 10, 9, 20.0);
        Cat M = new Cat("M", 58, 25, 9, 20.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);
        catCafe.hire(D);
        catCafe.hire(E);
        catCafe.hire(F);
        catCafe.hire(G);
        catCafe.hire(H);
        catCafe.hire(I);
        catCafe.hire(J);
        catCafe.hire(K);
        catCafe.hire(L);
        catCafe.hire(M);

        CatCafe.CatNode nodeReturned = catCafe.root.senior.senior.retire(C);

        if (!(nodeReturned.catEmployee.equals(A))) {
            throw new AssertionError("Retire did not return the correct node." +
                    "\n The node the method was called on (Cat A node) should be returned but got "
            + nodeReturned);
        }

        if (!(catCafe.root.senior.senior.senior.junior == null)){
            throw new AssertionError("Retire did not work properly." +
                    "\n Cat C should be removed from the tree.");
        }

        System.out.println("Test passed.");
    }
}

class retire_edgeCase8 implements Runnable {
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 20, 2, 250.0);
        Cat C = new Cat("C", 18, 10, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);
        Cat E = new Cat("E", 22, 39, 9, 20.0);
        Cat F = new Cat("F", 25, 48, 9, 20.0);
        Cat G = new Cat("G", 28, 45, 9, 20.0);
        Cat H = new Cat("H", 60, 28, 9, 20.0);
        Cat I = new Cat("I", 50, 50, 9, 20.0);
        Cat J = new Cat("J", 70, 18, 9, 20.0);
        Cat K = new Cat("K", 55, 20, 9, 20.0);
        Cat L = new Cat("L", 59, 10, 9, 20.0);
        Cat M = new Cat("M", 62, 25, 9, 20.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);
        catCafe.hire(D);
        catCafe.hire(E);
        catCafe.hire(F);
        catCafe.hire(G);
        catCafe.hire(H);
        catCafe.hire(I);
        catCafe.hire(J);
        catCafe.hire(K);
        catCafe.hire(L);
        catCafe.hire(M);

        CatCafe.CatNode nodeReturned = catCafe.root.junior.retire(H);

        if (!(nodeReturned.catEmployee.equals(M))) {
            throw new AssertionError("Retire did not return the correct node." +
                    "\n The method must return the root of the tree obtained by removing Cat H from the latter." +
                    "\n The root of the tree obtained by removing Cat H from the latter is Cat M but got " + nodeReturned);
        }

        System.out.println("Test passed.");
    }
}

class retire_edgeCase9 implements Runnable {
    @Override
    public void run() {
        Cat A = new Cat("A", 10, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 20, 2, 250.0);
        Cat C = new Cat("C", 18, 28, 12, 30.0);
        Cat D = new Cat("D", 12, 45, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);

        CatCafe.CatNode nodeReturned = cafe.root.junior.retire(C);

        if (!(nodeReturned.catEmployee.equals(B))) {
            throw new AssertionError("Retire did not return the correct node." +
                    "\n The method must return the root of the tree obtained by removing Cat C from the latter." +
                    "\n The new root should now be B but got " + nodeReturned);
        }

        System.out.println("Test passed.");
    }
}

class hire_retire1 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 30, 2, 250.0);
        Cat C = new Cat("C", 10, 35, 2, 250.0);
        Cat D = new Cat("D", 8, 38, 5, 85.0);
        Cat E = new Cat("E", 22, 39, 9, 20.0);
        Cat F = new Cat("F", 25, 48, 9, 20.0);
        Cat G = new Cat("G", 28, 45, 9, 20.0);
        Cat H = new Cat("H", 60, 28, 9, 20.0);
        Cat I = new Cat("I", 50, 50, 9, 20.0);
        Cat J = new Cat("J", 70, 18, 9, 20.0);
        Cat K = new Cat("K", 55, 20, 9, 20.0);
        Cat L = new Cat("L", 59, 10, 9, 20.0);
        Cat M = new Cat("M", 58, 25, 9, 20.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);
        catCafe.hire(D);
        catCafe.hire(E);
        catCafe.hire(F);
        catCafe.hire(G);
        catCafe.hire(H);
        catCafe.hire(I);
        catCafe.hire(J);
        catCafe.hire(K);
        catCafe.hire(L);
        catCafe.hire(M);

        catCafe.retire(I);
        catCafe.retire(J);
        catCafe.retire(K);
        catCafe.retire(H);
        catCafe.retire(C);
        catCafe.retire(D);
        catCafe.retire(M);
        catCafe.retire(L);
        catCafe.retire(F);
        catCafe.retire(G);
        catCafe.retire(B);

        if (!(catCafe.root.catEmployee.equals(A))) {
            throw new AssertionError("Retire did not work properly." +
                    "\n Cat A should be the new root but got " + catCafe.root);
        }

        if (!(catCafe.root.junior.catEmployee.equals(E) && catCafe.root.senior == null)) {
            throw new AssertionError("Retire rotations did not work properly" +
                    "\n Cat E should be the junior of A but got " + catCafe.root.junior);
        }

        if (!(catCafe.root.parent == null && catCafe.root.junior.parent == catCafe.root)) {
            throw new AssertionError("Parent pointers are not set correctly.");
        }

        if (!catCafe.root.findMostSenior().equals(A)) {
            throw new AssertionError("findMostSenior() did not work properly."
                    + "\n Cat A should be the most senior but got " + catCafe.root.findMostSenior());
        }


        if (!catCafe.root.findMostJunior().equals(E)) {
            throw new AssertionError("findMostJunior() did not work properly."
                    + "\n Cat E should be the most junior but got " + catCafe.root.findMostJunior());
        }

        System.out.println("Test passed.");
    }
}

class hallOfFame1 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 30, 2, 250.0);
        Cat C = new Cat("C", 10, 35, 2, 250.0);
        Cat D = new Cat("D", 8, 38, 5, 85.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);
        catCafe.hire(D);

        ArrayList<Cat> hallOfFameExpected = new ArrayList<>();
        hallOfFameExpected.add(A);
        hallOfFameExpected.add(D);
        hallOfFameExpected.add(C);
        hallOfFameExpected.add(B);

        ArrayList<Cat> hallOfFame = catCafe.buildHallOfFame(6);

        if (!(hallOfFame.size() == 4)) {
            throw new AssertionError("buildHallOfFame() did not work properly when numOfCatsToHonor" +
                    " is less than the number of cats in the cafe" +
                    "\n Expected size of the hall of fame is 4 but got " + hallOfFameExpected.size());
        }

        for (int i = 0; i < hallOfFameExpected.size(); i++) {
            if (!hallOfFame.get(i).equals(hallOfFameExpected.get(i))) {
                throw new AssertionError("buildHallOfFame() did not work properly when numOfCatsToHonor" +
                        " is less than the number of cats in the cafe" +
                        "\n Expected " + hallOfFameExpected.get(i) + " but got " + hallOfFame.get(i));
            }
        }

        System.out.println("Test passed.");

    }
}

class hallOfFame2 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 30, 2, 250.0);
        Cat C = new Cat("C", 10, 35, 2, 250.0);
        Cat D = new Cat("D", 8, 38, 5, 85.0);
        Cat E = new Cat("E", 22, 39, 9, 20.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);
        catCafe.hire(D);
        catCafe.hire(E);

        catCafe.retire(A);
        catCafe.retire(D);

        ArrayList<Cat> hallOfFameExpected = new ArrayList<>();
        hallOfFameExpected.add(E);
        hallOfFameExpected.add(C);

        ArrayList<Cat> hallOfFame = catCafe.buildHallOfFame(2);

        if (!(hallOfFame.size() == 2)) {
            throw new AssertionError("buildHallOfFame() did not work properly when numOfCatsToHonor" +
                    " is equal to the number of cats in the cafe" +
                    "\n Expected size of the hall of fame is 2 but got " + hallOfFameExpected.size());
        }

        for (int i = 0; i < hallOfFameExpected.size(); i++) {
            if (!hallOfFame.get(i).equals(hallOfFameExpected.get(i))) {
                throw new AssertionError("buildHallOfFame() did not work properly when numOfCatsToHonor" +
                        " is equal to the number of cats in the cafe" +
                        "\n Expected " + hallOfFameExpected.get(i) + " but got " + hallOfFame.get(i));
            }
        }

        System.out.println("Test passed.");

    }
}

class hallOfFame3 implements Runnable{
    @Override
    public void run() {

        CatCafe catCafe = new CatCafe();

        ArrayList<Cat> hallOfFameExpected = new ArrayList<>();

        ArrayList<Cat> hallOfFame = catCafe.buildHallOfFame(2);

        if (!(hallOfFame.size() == 0)) {
            throw new AssertionError("buildHallOfFame() did not work properly when the cafe is empty." +
                    "\n Expected size of the hall of fame is 0 but got " + hallOfFameExpected.size());
        }

        for (int i = 0; i < hallOfFameExpected.size(); i++) {
            if (!hallOfFame.get(i).equals(hallOfFameExpected.get(i))) {
                throw new AssertionError("buildHallOfFame() did not work properly when numOfCatsToHonor" +
                        " is greater than the number of cats in the cafe" +
                        "\n Expected " + hallOfFameExpected.get(i) + " but got " + hallOfFame.get(i));
            }
        }

        System.out.println("Test passed.");
    }
}

class hallOfFame4 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 30, 2, 250.0);
        Cat C = new Cat("C", 10, 35, 2, 250.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);

        ArrayList<Cat> hallOfFame = catCafe.buildHallOfFame(2);

        if (!(catCafe.root.catEmployee.equals(A) && catCafe.root.senior.catEmployee.equals(C) && catCafe.root.senior.junior.catEmployee.equals(B))) {
            throw new AssertionError("The tree should be unchanged after the method call.");
        }

        if (!(hallOfFame.size() == 2)) {
            throw new AssertionError("The hall of fame should contain 2 cats: A and C.");
        }

        System.out.println("Test passed.");

    }
}

class hallOfFame5 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 20, 40, 5, 85.0);
        Cat B = new Cat("B", 15, 30, 2, 250.0);
        Cat C = new Cat("C", 10, 35, 2, 250.0);
        Cat D = new Cat("D", 8, 38, 5, 85.0);
        Cat E = new Cat("E", 22, 39, 9, 20.0);

        CatCafe catCafe = new CatCafe();
        catCafe.hire(A);
        catCafe.hire(B);
        catCafe.hire(C);
        catCafe.hire(D);
        catCafe.hire(E);

        catCafe.retire(A);
        catCafe.retire(D);

        ArrayList<Cat> hallOfFame = catCafe.buildHallOfFame(3);

        if (!(catCafe.root.catEmployee.equals(E) && catCafe.root.senior.catEmployee.equals(C) && catCafe.root.senior.junior.catEmployee.equals(B))) {
            throw new AssertionError("The tree should be unchanged after the method call.");
        }

        if (!(hallOfFame.size() == 3)) {
            throw new AssertionError("The hall of fame should contain 2 cats: A and C.");
        }

        System.out.println("Test passed.");

    }
}

class budgetGroomingExpenses1 implements Runnable{
    @Override
    public void run() {

        Cat A = new Cat("A", 25, 33, 5, 85.0);
        Cat B = new Cat("B", 35, 29, 2, 250.0);
        Cat C = new Cat("C", 18, 12, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);

        double budget = 85+250+85;

        if (cafe.budgetGroomingExpenses(5) != budget) {
            throw new AssertionError("budgetGroomingExpense() did not work properly." +
                    "\n Expected 420.0 but got " + cafe.budgetGroomingExpenses(5));
        }

        cafe.retire(A);
        cafe.retire(B);

        budget = 85;

        if (cafe.budgetGroomingExpenses(5) != budget) {
            throw new AssertionError("budgetGroomingExpense() did not work properly." +
                    "\n Expected 85.0 but got " + cafe.budgetGroomingExpenses(5));
        }

        System.out.println("Test passed.");
    }
}

class budgetGroomingExpenses2 implements Runnable{
    @Override
    public void run() {

        Cat A = new Cat("A", 25, 33, 5, 85.0);
        Cat B = new Cat("B", 35, 29, 2, 250.0);
        Cat C = new Cat("C", 18, 12, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);

        if (cafe.budgetGroomingExpenses(1) != 0) {
            throw new AssertionError("budgetGroomingExpense() did not work properly." +
                    "\n Expected 0.0 but got " + cafe.budgetGroomingExpenses(1));
        }

        System.out.println("Test passed.");
    }
}

class budgetGroomingExpenses3 implements Runnable{
    @Override
    public void run() {

        Cat A = new Cat("A", 25, 33, 5, 85.0);
        Cat B = new Cat("B", 35, 29, 2, 250.0);
        Cat C = new Cat("C", 18, 12, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);

        if (cafe.budgetGroomingExpenses(-5) != 0) {
            throw new AssertionError("budgetGroomingExpense() did not work properly when " +
                    "numOfDays is less than 0.");
        }

        System.out.println("Test passed.");
    }
}

class budgetGroomingExpenses4 implements Runnable{
    @Override
    public void run() {

        Cat A = new Cat("A", 25, 33, 5, 85.0);
        Cat B = new Cat("B", 35, 29, 2, 250.0);
        Cat C = new Cat("C", 18, 12, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);

        cafe.retire(A);
        cafe.retire(B);
        cafe.retire(C);

        if (cafe.budgetGroomingExpenses(5) != 85) {
            throw new AssertionError("budgetGroomingExpense() did not work properly." +
                    "\n Expected 85.0 but got " + cafe.budgetGroomingExpenses(5));
        }

        System.out.println("Test passed.");
    }
}

class budgetGroomingExpenses5 implements Runnable{
    @Override
    public void run() {

        Cat A = new Cat("A", 25, 33, 0, 85.0);
        Cat B = new Cat("B", 35, 29, 2, 20.0);
        Cat C = new Cat("C", 18, 12, 1, 10.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);

        if (cafe.budgetGroomingExpenses(1) != 95) {
            throw new AssertionError("budgetGroomingExpense() did not work properly." +
                    "\n Expected 95.0 but got " + cafe.budgetGroomingExpenses(5));
        }

        System.out.println("Test passed.");
    }
}

class iterator1 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 25, 33, 5, 85.0);
        Cat B = new Cat("B", 35, 29, 2, 250.0);
        Cat C = new Cat("C", 18, 12, 12, 30.0);
        Cat D = new Cat("D", 12, 5, 5, 85.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);

        Stack<Cat> expected = new Stack<>();
        expected.push(B);
        expected.push(A);
        expected.push(C);
        expected.push(D);

        Stack<Cat> actual = new Stack<>();

        for(Cat cat : cafe){
            if(cat == null){
                throw new AssertionError("The iterator should not return null.");
            }
            actual.push(cat);
        }

        if(!expected.equals(actual)){
            throw new AssertionError("The iterator did not work properly.");
        }

        System.out.println("Test passed. ");

    }
}

class iterator2 implements Runnable{
    @Override
    public void run() {

        CatCafe cafe = new CatCafe();

        Stack<Cat> expected = new Stack<>();

        Stack<Cat> actual = new Stack<>();

        for (Cat cat : cafe) {
            if (cat == null) {
                throw new AssertionError("The iterator should not return null because" +
                        " .hasNext() must return false when no non-null elements are left.");
            }
            actual.push(cat);
        }

        if(!expected.equals(actual)){
            throw new AssertionError("The iterator did not work properly.");
        }

        System.out.println("Test passed. ");

    }
}

public class A3_Tester2 {
    static String[] tests = {
            "findMostSenior1",
            "findMostSenior2",
            "findMostSenior3",
            "findMostJunior1",
            "findMostJunior2",
            "findMostJunior3",
            "shallow_copy1",
            "shallow_copy2",
            "shallow_copy3",
            "hire_rotation1",
            "hire_rotation2",
            "hire_rotation3",
            "hire_rotation4",
            "hire_megaRotation",
            "retire_rotation1",
            "retire_rotation2",
            "retire_megaRotation3",
            "retire_edgeCase1",
            "retire_edgeCase2",
            "retire_edgeCase4",
            "retire_edgeCase5",
            "retire_edgeCase6",
            "retire_edgeCase7",
            "retire_edgeCase8",
            "retire_edgeCase9",
            "hire_retire1",
            "hallOfFame1",
            "hallOfFame2",
            "hallOfFame3",
            "hallOfFame4",
            "hallOfFame5",
            "budgetGroomingExpenses1",
            "budgetGroomingExpenses2",
            "budgetGroomingExpenses3",
            "budgetGroomingExpenses4",
            "budgetGroomingExpenses5",
            "iterator1",
            "iterator2"
    };
    public static void main(String[] args) {
        int numPassed = 0;
        for(String className: tests)    {
            System.out.printf("%n======= %s =======%n", className);
            System.out.flush();
            try {
                Runnable testCase = (Runnable) Class.forName(className).getDeclaredConstructor().newInstance();
                testCase.run();
                numPassed++;
            } catch (AssertionError e) {
                System.out.println(e);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }
        System.out.printf("%n%n%d of %d tests passed.%n", numPassed, tests.length);
    }


}




