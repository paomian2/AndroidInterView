package com.linxz.DataStructure.Tree;

/**
 * @author Linxz
 * 创建日期：2020年06月28日 14:51
 * version：v4.5.4
 * 描述：
 */
public class StudentScore implements Comparable<StudentScore> {

    private int score;

    public StudentScore(int score){
        this.score=score;
    }

    @Override
    public int compareTo(StudentScore studentScore) {
        if (score>studentScore.score){
            return 1;
        }else if (score<studentScore.score){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return score+"";
    }

    public static void main(String[] args) {



        BST<StudentScore> studentScoreBSE=new BST<>();

        StudentScore score1=new StudentScore(41);
        StudentScore score2=new StudentScore(41);
        StudentScore score3=new StudentScore(15);
        StudentScore score4=new StudentScore(13);
        StudentScore score5=new StudentScore(33);
        StudentScore score6=new StudentScore(37);
        StudentScore score7=new StudentScore(58);
        StudentScore score8=new StudentScore(50);
        StudentScore score9=new StudentScore(42);
        StudentScore score10=new StudentScore(53);
        StudentScore score11=new StudentScore(60);
        StudentScore score12=new StudentScore(59);
        StudentScore score13=new StudentScore(63);
        studentScoreBSE.add(score1);
        studentScoreBSE.add(score2);
        studentScoreBSE.add(score3);
        studentScoreBSE.add(score4);
        studentScoreBSE.add(score5);
        studentScoreBSE.add(score6);
        studentScoreBSE.add(score7);
        studentScoreBSE.add(score8);
        studentScoreBSE.add(score9);
        studentScoreBSE.add(score10);
        studentScoreBSE.add(score11);
        studentScoreBSE.add(score12);
        studentScoreBSE.add(score13);
//        System.out.println(studentScoreBSE.getSize());
//        studentScoreBSE.printTree();
//
//        StudentScore query=new StudentScore(71);
//        System.out.println(studentScoreBSE.contains(query));
//      //  studentScoreBSE.preOrder();
////        studentScoreBSE.postOrder();
////        System.out.println("--------------------------");
////        studentScoreBSE.preOrderNR();
////        System.out.println("--------------------------");
////        studentScoreBSE.preOrderNR2();
//        studentScoreBSE.queryList();
//        System.out.println("-- --------搜索最小值-------");
//        System.out.println(studentScoreBSE.minValue());
//
////        System.out.println("-- --------删除最小值-------");
////        studentScoreBSE.deleteMin();
//
//        System.out.println("-- --------删除最小值-------");
//        studentScoreBSE.removeMin();
//        studentScoreBSE.queryList();


//        BST<Integer> integerBSE=new BST<>();
//        //随机生成1000个数据
//        Random random=new Random();
//        for (int i=0;i<1000;i++){
//            integerBSE.add(random.nextInt(1000));
//        }
        studentScoreBSE.queryList();
        System.out.println("-- --------删除-------");
        studentScoreBSE.remove(score5);
        studentScoreBSE.queryList();
    }
}
