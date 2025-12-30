package designpattern.creationalpattern;

// eager loading (object is initialized at class loading whether useful or not)
// thread safe as Object is static and initialized at start
/*
class JudgeAnalytics{
    private static final JudgeAnalytics judgeAnalytics=new JudgeAnalytics();

    private JudgeAnalytics(){}
    public static JudgeAnalytics getJudgeAnalytics(){
        return judgeAnalytics;
    }
}
*/

//lazy loading ( object is initialized when called)
class JudgeAnalytics{
    private static JudgeAnalytics judgeAnalytics;

    private JudgeAnalytics(){}

    //not thread safe
    /*public static JudgeAnalytics getJudgeAnalytics(){
        if (judgeAnalytics == null){
            judgeAnalytics=new JudgeAnalytics();
        }
        return judgeAnalytics;
    }*/

    // it will check for synchronization even when object created , again and again
   /* public static synchronized JudgeAnalytics getInstance(){
        if(judgeAnalytics == null){
            judgeAnalytics=new JudgeAnalytics();
        }
        return judgeAnalytics;
    }*/

    public static JudgeAnalytics getInstance(){
        if(judgeAnalytics == null){
            synchronized(JudgeAnalytics.class){
                if(judgeAnalytics == null){
                    judgeAnalytics=new JudgeAnalytics();
                }
            }
            return judgeAnalytics;
        }
        return judgeAnalytics;
    }

}


public class Singleton {
    public static void main(String[] args) {

        JudgeAnalytics judgeAnalytics = JudgeAnalytics.getInstance();
        JudgeAnalytics judgeAnalytics2 = JudgeAnalytics.getInstance();
        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics2);

    }
}
