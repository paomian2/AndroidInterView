package com.linxz.Base;

/**
 * @author Linxz
 * 创建日期：2020年05月07日 16:32
 * version：v4.5.4
 * 描述：
 */
public class StringTestMain {

    public static void main(String[] args) {
//        Map<String, String> hashMap = new LinkedHashMap<String, String>();
//        for (int i=0;i<1000;i++){
//            hashMap.put("name"+i, "josan"+i);
//        }
//        Set<Map.Entry<String, String>> set = hashMap.entrySet();
//        Iterator<Map.Entry<String, String>> iterator = set.iterator();
//        while(iterator.hasNext()) {
//            Map.Entry entry = iterator.next();
//            String key = (String) entry.getKey();
//            String value = (String) entry.getValue();
//            System.out.println("key:" + key + ",value:" + value);
//        }


        int a=3;
        int b=2;
        System.out.println(a^b);

//        int a[] = {1, 2, 3, 4, 10, 4, 3, 2};
//        int temp=a[0];
//        for (int i=1; i < a.length; i++){
//            temp =  temp^a[i];
//        }
//        System.out.println(temp);


        int age=execute(new Student() {
            @Override
            public void play() {
            }
        });

        int age1=execute1(new AbsStudent() {
            @Override
            public void play() {

            }
        });

        int age2=execute2(new StudentInterface() {
            @Override
            public void play() {
            }

            @Override
            public int getAge() {
                return age;
            }
        });


       // Thread.sleep(1000);


    }

    private static int  execute(Student student){
        return student.getAge();
    }


    private static int  execute1(AbsStudent student){
        return student.getAge();
    }


    private static int  execute2(StudentInterface student){
        return student.getAge();
    }



}
