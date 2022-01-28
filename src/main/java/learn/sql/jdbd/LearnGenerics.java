package learn.sql.jdbd;

import java.util.*;


class LearnGenerics {
    public static void main(String[] args){
        // List<String> list = new ArrayList<>();
        // list.add("one");
        // list.add("two");
        // list.add("three");
        // Iterator<String> iterator = list.iterator();
        // while(iterator.hasNext()) {
        //     String value = iterator.next();
        //     System.out.println(value);
        // }

        // Set<String> set = new HashSet<>();
        // set.add("one");
        // set.add("two");
        // set.add("three");
        // Iterator<String> iterator2 = set.iterator();
        // while(iterator2.hasNext()) {
        //     String value = iterator2.next();
        //     System.out.println(value);
        // }

        // {
        //     name
        //     phone
        //     lastname
        //     address
        // }

        List<Person> list_person = Arrays.asList(new Person("Bomb","Sathorn"),new Person("Bomb","Sathorn"), new Person("Mint","Pinklow"), new Person("Chuan","Sathorn"));

/*
        Result<?> result = cloneList(list_person);
        System.out.println(result.getClone_list());
        System.out.println(result.getList_of_duplicates());
        System.out.println(result.getNumber_of_duplicates());
*/

        cloneList1(list_person);


        List<Game> list_game = Arrays.asList(new Game("Mario","PS2",3),new Game("Mario","PS2",3),new Game("Mario","PS2",3));
/*
        Result<?> result1 = cloneList(list_game);
        System.out.println(result1.getClone_list());
        System.out.println(result1.getList_of_duplicates());
        System.out.println(result1.getNumber_of_duplicates());
*/

        cloneList1(list_game);


//        List<String> list_
    }

    public static <T> Result<T> cloneList(List<T> list){
        int number_of_duplicates = 0;
        List<T> clone_list = new ArrayList<T>(list);
        List<Duplicate<T>> list_of_duplicates = new ArrayList<>();

//      TODO  Set<> ลองใช้

        for(int i = 0;i < clone_list.size();i++){
            T first_ele = clone_list.get(i);
            for(int j = i+1;j < clone_list.size();j++) {
                T secound_ele = clone_list.get(j);
                if (first_ele.equals(secound_ele)) {
                    Duplicate<T> duplicate = new Duplicate<>(i, j);
                    list_of_duplicates.add(duplicate);
                }
            }
        }

        number_of_duplicates = (int) list_of_duplicates.stream().count();

        return new Result<T>(number_of_duplicates,clone_list,list_of_duplicates);

    }

    public static <T> void cloneList1(List<T> list){
        int number_of_duplicates = 0;
        List<T> clone_list = new ArrayList<T>(list);
        Set<T> set = new HashSet<>();
//        List<T> list_dup = new ArrayList<>();
        List<Integer> list_index_duplicate = new ArrayList<>();
        for(int index_of_clone_list = 0;index_of_clone_list < clone_list.size();index_of_clone_list++){
            T ele = clone_list.get(index_of_clone_list);
            if(!set.add(ele)){
                list_index_duplicate.add(index_of_clone_list);
            }
        }
        number_of_duplicates = (int) list_index_duplicate.stream().count() + 1;

        System.out.println(number_of_duplicates);
        System.out.println(list_index_duplicate);

    }

//    public static writeExcelSheet(){}


}




