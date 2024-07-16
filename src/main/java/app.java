import java.util.*;

public class app {
    public static void main(String[] args) {
//        for (int root = 9; root >= 0; root--) {
//            run(root, 0);
//        }
        //vSystem.out.println(dualFactorFinder(25));
        List<List<Integer>> list = new ArrayList<>();
        //System.out.println(printFactors(32, list, 32));
        System.out.println(factComb(30));
        System.out.println(getPermutations(factComb(30)));
    }

    public static void run(int root, int currentStreak) {
        List<List<Integer>> list = factComb(root);


    }

    public static List<Integer> primeFactors(int number) {
        int n = number;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }

    public static List<Integer> numberSplitter(int root) {
        List<Integer> result = new ArrayList<Integer>();
        String stringNumber = Integer.toString(root);
        for (int i = 0; i < stringNumber.length(); i++) {
            result.add(Integer.parseInt(stringNumber.substring(i, i+1)));
        }
        return result;
    }

    public static int numberCombiner(List<Integer> list) {
        String number = "";
        for (int i = 0; i < list.size(); i++) {
            number += list.get(i).toString();
        }
        return (Integer.parseInt(number));
    }

    public static int getProduct(List<Integer> list) {
        int total = list.remove(0);
        for (int i = 0; list.size() != 0;) {
            total *= list.remove(i);
        }
        return total;
    }

    public static List<List<Integer>> dualFactorFinder(int root) {
        List<List<Integer>> factorList = new ArrayList<>();

        for (int i = 1; i <= root; i++) {
            for (int j = 1; j <= root; j++) {
                if (i * j == root) {
                    factorList.add(new ArrayList<>(Arrays.asList(i,j)));
//                    if (i != j) {
//                        factorList.add(new ArrayList<>(Arrays.asList(j,i)));
//                    }
                }
            }
        }
        return factorList;
    }

    public static List<List<Integer>> factorFinder(List<List<Integer>> list) {
        List<List<Integer>> factorList = new ArrayList<>();

        for (int permutation = 0; permutation < list.size(); permutation++) {
            if (list.get(permutation).size() != 2) {
                break;
            }
            for (int factor = 0; factor < list.get(permutation).size(); factor++)
            {
                List<List<Integer>> factors = dualFactorFinder(list.get(permutation).get(factor));
                if (factors.size() != 1) {

                }
            }
        }


        return factorList;
    }

    public static List<List<Integer>> getPermutations(List<List<Integer>> list) {
        List<List<Integer>> permutedList = new ArrayList<>();
        for (List<Integer> factors : list) {
            for (int i = 0; i < factors.size(); i++) {
                permutedList.add(shiftList(factors,i));
            }
        }
        return permutedList;
    }

    public static List<Integer> shiftList(List<Integer> list, int shiftValue) {
        List<Integer> shiftedList = new ArrayList<>();
        shiftValue = shiftValue % list.size();
        if (shiftValue <= 0) {
            return list;
        }

        int i = 0;
        while (shiftValue - i <= 0) {
            shiftedList.add(list.get(list.size() - shiftValue - i));
            i--;
        }
        System.out.println(shiftedList);

        i = 0;
        while (i <= shiftValue) {
            shiftedList.add(list.get(i));
            i++;
        }
        System.out.println(shiftedList);

        return shiftedList;
    }



    public static List<List<Integer> > factComb(int n)
    // Returns a list containing all ways to factorize
    // a number n.
    {
        // making list of lists to store all
        // possible combinations of factors
        List<List<Integer> > result_list =
                new ArrayList<List<Integer> >();
        List<Integer> list = new ArrayList<Integer>();

        // function to calculate all the combinations
        // of factors
        factorsListFunc(2, 1, n, result_list, list);
        return result_list;
    }

    // First is current factor to be considered.
    // each_product is current product of factors.
    public static void factorsListFunc(int first,
                                       int each_prod, int n,
                                       List<List<Integer> > result_list, List<Integer>
                                               single_result_list)
    {
        // Terminating condition of this recursive
        // function
        if (first > n || each_prod > n)
            return;

        // When each_prod is equal to n, we get
        // the list of factors in 'single_result_
        // _list' so it is  added to the result_
        // _list list .
        if (each_prod == n) {

            ArrayList<Integer> t =
                    new ArrayList<Integer>(single_result_list);

            result_list.add(t);

            return;
        }

        // In this loop we first calculate factors
        // of n and then it's combination so that
        // we get the value n in a recursive way .
        for (int i = first; i < n; i++) {
            if (i * each_prod > n)
                break;

            // if i divides n
            // properly then it
            // is factor of n
            if (n % i == 0) {

                // it is added to 'single_result_list' list
                single_result_list.add(i);

                // Here function is called recursively
                // and when (i*each_prod) is equal to n
                // we will store the 'single_result_list' (it is
                // basically the list containing all
                // combination of factors) into result_list.
                factorsListFunc(i, i * each_prod, n,
                        result_list, single_result_list);

                // here we will empty the 'single_result_list'
                // List so that new combination of factors
                // get stored in it.
                single_result_list.remove(single_result_list.size() - 1);
            }
        }
    }

    //    public static List<List<Integer>> printFactors(int number, List<List<Integer>> parentFactors, int parentVal) {
//        int newVal = parentVal;
//        for (int i = number - 1; i >= 2; i--) {
//
//            if (number % i == 0) {
//                if (newVal > i) {
//                    newVal = i;
//                }
//                if (number / i <= parentVal && i <= parentVal
//                        && number / i <= i) {
//                    parentFactors.add(new ArrayList<>(Arrays.asList(i,number/i)));
//                    newVal = number / i;
//                }
//
//                if (i <= parentVal) {
//                    parentFactors.get(parentFactors.size() - 1).add(i);
//                    printFactors(number / i, parentFactors, newVal);
//                }
//            }
//
//        }
//        return parentFactors;
//    }
}
