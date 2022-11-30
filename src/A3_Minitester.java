import java.util.ArrayList;



class test_hire_1 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 40, 50, 2, 85.0);
        Cat B = new Cat("B", 20, 10, 2, 20.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);

        if (!(cafe.root.senior.catEmployee.equals(B) && cafe.root.catEmployee.equals(A))){
            throw new AssertionError("CatB should be junior of CatA and CatA is the root");
        };
        System.out.println("Test passed.");
    }
}

class test_hire_2 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 45, 50, 5, 85.0);
        Cat B = new Cat("B", 65, 23, 2, 250.0);


        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);

        if (!(cafe.root.junior.catEmployee.equals(B) && cafe.root.catEmployee.equals(A))){
            throw new AssertionError("B should be senior of A and A is the root");
        }
        System.out.println("Test passed.");
    }
}

class test_hire_3 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 40, 50, 5, 85.0);
        Cat B = new Cat("B", 20, 40, 2, 250.0);
        Cat C = new Cat("C", 10, 30, 12, 30.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);

        if (!(cafe.root.catEmployee.equals(A) && cafe.root.senior.catEmployee.equals(B)&&cafe.root.senior.senior.catEmployee.equals(C))){
            throw new AssertionError("catC should be senior of catB and catB should be senior of catA");
        }
        System.out.println("Test passed.");
    }
}

class test_hire_4 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 10, 30, 5, 85.0);
        Cat B = new Cat("B", 20, 20, 2, 250.0);
        Cat C = new Cat("C", 30, 10, 12, 30.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);

        if (!(cafe.root.catEmployee.equals(A) && cafe.root.junior.catEmployee.equals(B) && cafe.root.junior.junior.catEmployee.equals(C))) {
            throw new AssertionError("catC should be junior of catB and catB should be junior of catA");
        }
        System.out.println("Test passed.");
    }
}

class test_hire_5 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 30, 40, 5, 85.0);
        Cat B = new Cat("B", 20, 20, 2, 250.0);
        Cat C = new Cat("C", 10, 30, 12, 30.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);

        if (!(cafe.root.catEmployee.equals(A) && cafe.root.senior.catEmployee.equals(C) && cafe.root.senior.junior.catEmployee.equals(B))) {
            throw new AssertionError("Cat B should be junior of catC and cat C should be senior of catA");
        }
        System.out.println("Test passed.");
    }
}

class test_retire_1 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 30, 40, 5, 85.0);
        Cat B = new Cat("B", 20, 20, 2, 250.0);


        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.retire(B);
        cafe.toString();

        if (!(cafe.root.catEmployee.equals(A) && cafe.root.senior==null && cafe.root.junior==null)) {
            throw new AssertionError("Cat A should be only cat left in the tree");
        }
        System.out.println("Test passed.");
    }
}

class test_retire_2 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 30, 40, 5, 85.0);
        Cat B = new Cat("B", 40, 20, 2, 250.0);


        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.retire(B);

        if (!(cafe.root.catEmployee.equals(A) && cafe.root.senior==null && cafe.root.junior==null)) {
            throw new AssertionError("Cat A should be only cat left in the tree");
        }
        System.out.println("Test passed.");
    }

}

class test_retire_3 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 30, 30, 5, 85.0);
        Cat B = new Cat("B", 20, 20, 2, 250.0);
        Cat C = new Cat("C", 10, 10, 12, 30.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.retire(B);

        if (!(cafe.root.catEmployee.equals(A) && cafe.root.senior.catEmployee.equals(C) && cafe.root.senior.junior==null && cafe.root.senior.senior==null)) {
            throw new AssertionError("There should only be 2 cats in the tree with A as root and C senior of A");
        }
        System.out.println("Test passed.");
    }

}

class test_retire_4 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 10, 40, 5, 85.0);
        Cat B = new Cat("B", 20, 20, 2, 250.0);
        Cat C = new Cat("C", 30, 30, 12, 30.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.retire(B);

        if (!(cafe.root.catEmployee.equals(A) && cafe.root.junior.catEmployee.equals(C) && cafe.root.junior.senior==null && cafe.root.junior.junior == null)){
            throw new AssertionError("There should only be 2 cats in the tree with A as root and C junior of A");
        }
        System.out.println("Test passed.");
    }

}

class test_retire_5 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 30, 40, 5, 85.0);
        Cat B = new Cat("B", 20, 20, 2, 250.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.retire(A);

        if (!(cafe.root.catEmployee.equals(B) && cafe.root.junior == null && cafe.root.senior==null)){
            throw new AssertionError("Cat B should be only cat left in the tree");
        }
        System.out.println("Test passed.");

    }
}

class test_retire_6 implements Runnable {
    @Override
    public void run() {
        Cat A = new Cat("A", 30, 40, 5, 85.0);
        Cat B = new Cat("B", 40, 20, 2, 250.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.retire(A);

        if (!(cafe.root.catEmployee.equals(B) && cafe.root.junior == null && cafe.root.senior == null)) {
            throw new AssertionError("Cat B should be only cat left in the tree");
        }
        System.out.println("Test passed.");

    }
}



class test_find_most_junior_1 implements Runnable{
    @Override
    public void run() {
        Cat A = new Cat("A", 10, 40, 5, 85.0);
        Cat B = new Cat("B", 20, 30, 2, 250.0);
        Cat C = new Cat("C", 30, 20, 12, 30.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);

        if (!cafe.root.findMostJunior().equals(C)){
            throw new AssertionError("Test failed most junior cat is C but got "+ cafe.root.findMostJunior().toString());
        }
        System.out.println("Test passed.");

    }


}

class test_find_most_junior_2 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 30, 40, 5, 85.0);
        Cat B = new Cat("B", 20, 20, 2, 250.0);
        Cat C = new Cat("C", 10, 30, 12, 30.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);

        if (!(cafe.root.findMostJunior().equals(A))){
            throw new AssertionError("Test failed when most junior cat is the root (A)");
        }
        System.out.println("Test passed.");
    }
}

class test_find_most_junior_3 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 40, 50, 5, 85.0);
        Cat B = new Cat("B", 30, 30, 2, 250.0);
        Cat C = new Cat("C", 60, 20, 12, 30.0);


        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);

        if (!(cafe.root.findMostJunior().equals(C))){
            throw new AssertionError("Test failed when root.junior == null, most junior cat is C");
        }
        System.out.println("Test passed.");
    }
}


class test_find_most_senior_1 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 40, 50, 5, 85.0);
        Cat B = new Cat("B", 30, 30, 2, 250.0);
        Cat C = new Cat("C", 20, 20, 12, 30.0);


        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);

        if (!(cafe.root.findMostSenior().equals(C))){
            throw new AssertionError("Test failed when most senior cat is C but got "+ cafe.root.findMostJunior().toString());
        }
        System.out.println("Test passed.");
    }
}

class test_find_most_senior_2 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 10, 50, 5, 85.0);
        Cat B = new Cat("B", 30, 30, 2, 250.0);
        Cat C = new Cat("C", 60, 20, 12, 30.0);


        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);

        if (!(cafe.root.findMostSenior().equals(A))){
            throw new AssertionError("Test failed when most senior cat is at the root");
        }
        System.out.println("Test passed.");
    }
}

class test_find_most_senior_3 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 20, 50, 5, 85.0);
        Cat B = new Cat("B", 30, 30, 2, 250.0);
        Cat C = new Cat("C", 10, 20, 12, 30.0);


        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);

        if (!(cafe.root.findMostSenior().equals(C))){
            throw new AssertionError("Test failed when root.senior == null, most senior cat is C but got "+cafe.root.findMostSenior().toString());
        }
        System.out.println("Test passed.");
    }
}

class test_build_hof_1 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 20, 50, 5, 85.0);
        Cat B = new Cat("B", 30, 30, 2, 250.0);
        Cat C = new Cat("C", 10, 20, 12, 30.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        ArrayList<Cat> res = new ArrayList<>();
        res.add(A);
        res.add(B);
        res.add(C);

        ArrayList<Cat> ans = cafe.buildHallOfFame(3);
        for (int i =0; i<3; i+=1){
            if (!(ans.get(i).equals(res.get(i)))){
                throw new AssertionError("Test failed when building hall of fame");
            }
        }
        System.out.println("Test passed.");
    }

}

class test_build_hof_2 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 20, 50, 5, 85.0);
        Cat B = new Cat("B", 30, 30, 2, 250.0);
        Cat C = new Cat("C", 10, 20, 12, 30.0);
        Cat D = new Cat("D", 5, 25, 12, 30.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);
        ArrayList<Cat> res = new ArrayList<>();
        res.add(A);
        res.add(B);
        res.add(D);


        ArrayList<Cat> ans = cafe.buildHallOfFame(3);
        for (int i =0; i<3; i+=1){
            if (!(ans.get(i).equals(res.get(i)))){
                throw new AssertionError("Test failed when numOfCatsToHonor less than number of cats in cafe ");
            }
        }
        System.out.println("Test passed.");
    }
}


class test_budget_grooming_expense_1 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 20, 50, 5, 85.0);
        Cat B = new Cat("B", 30, 30, 2, 250.0);
        Cat C = new Cat("C", 10, 20, 12, 30.0);
        Cat D = new Cat("D", 5, 25, 12, 30.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);

        float res = 85+250+30+30;

        if (cafe.budgetGroomingExpenses(13)!=res){
            throw new AssertionError("Test failed for budgetGroomingExpense, budget is " + res + "but got " + cafe.budgetGroomingExpenses(13));
        }
        System.out.println("Test passed.");

    }

}


class test_get_grooming_schedule_1 implements Runnable{
    @Override
    public void run(){
        Cat A = new Cat("A", 30, 50, 5, 85.0);
        Cat B = new Cat("B", 20, 30, 2, 250.0);
        Cat C = new Cat("C", 15, 20, 12, 30.0);
        Cat D = new Cat("D", 10, 25, 12, 30.0);
        Cat E = new Cat("E", 7, 60, 20, 30.0);

        CatCafe cafe = new CatCafe();
        cafe.hire(A);
        cafe.hire(B);
        cafe.hire(C);
        cafe.hire(D);
        cafe.hire(E);

        ArrayList<ArrayList<Cat>> ans = new ArrayList<>();
        ArrayList<Cat> week0 = new ArrayList<>();
        ArrayList<Cat> week1 = new ArrayList<>();
        ArrayList<Cat> week2 = new ArrayList<>();

        week0.add(A);
        week0.add(B);
        week1.add(C);
        week1.add(D);
        week2.add(E);

        ans.add(week0);
        ans.add(week1);
        ans.add(week2);

        ArrayList<ArrayList<Cat>> res = cafe.getGroomingSchedule();
        if (ans.size() !=res.size()){
            System.out.println(ans);
            System.out.println(res);
            throw new AssertionError("Test failed for grooming schedule. size of output array does not match size of expected output");

        }
        for (int i =0; i<3; i+=1){
            ArrayList<Cat> ansW = ans.get(i);
            ArrayList<Cat> resW = res.get(i);

            for (int j=0; j<ansW.size(); j++) {
                if (!(ansW.get(j).equals(resW.get(j)))) {
                    throw new AssertionError("Test failed for grooming schedule. Expected "+ ansW.toString() +
                            " in week " + i + " but got " + resW.toString());

                }
            }
        }
        System.out.println("Test passed.");


    }
}


public class A3_Minitester {

    static String[] tests = {
            "test_hire_1",
            "test_hire_2",
            "test_hire_3",
            "test_hire_4",
            "test_hire_5",
            "test_retire_1",
            "test_retire_2",
            "test_retire_3",
            "test_retire_4",
            "test_retire_5",
            "test_retire_6",
            "test_find_most_junior_1",
            "test_find_most_junior_2",
            "test_find_most_junior_3",
            "test_find_most_senior_1",
            "test_find_most_senior_2",
            "test_find_most_senior_3",
            "test_build_hof_1",
            "test_build_hof_2",
            "test_get_grooming_schedule_1",
            "test_budget_grooming_expense_1"
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

